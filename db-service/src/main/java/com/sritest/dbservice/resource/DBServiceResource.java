package com.sritest.dbservice.resource;


import com.sritest.dbservice.exception.ExceptionResponse;
import com.sritest.dbservice.exception.MyException;
import com.sritest.dbservice.model.Quote;
import com.sritest.dbservice.model.Quotes;
import com.sritest.dbservice.repository.QuotesRepository;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

    private QuotesRepository quotesRepository;

    public DBServiceResource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{userName}")
    public List<String> getQuotes(@PathVariable("userName")final String userName){

        List<Quote> quoteList= quotesRepository.findByUserName(userName);

        if(quoteList.isEmpty())
          throw new MyException("User Not Found");


        return  quoteList
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());

    }

    @PostMapping("/add")
    public List<String> add(@RequestBody    final Quotes quotes){

        quotes.getQuotes()
                .stream()
                .map(quote->new Quote(quotes.getUserName(),quote))
                .forEach(quote->quotesRepository.save(quote));

       return getQuotes(quotes.getUserName());

    }

    @PostMapping("/delete/{userName}")
    public List<String> delete(@PathVariable("userName")final String userName){

        List<Quote> quotes=quotesRepository.findByUserName(userName);
            quotes.forEach(quotesRepository::delete);
                 return getQuotes(userName);

    }
}

