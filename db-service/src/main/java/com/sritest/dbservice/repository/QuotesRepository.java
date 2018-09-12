package com.sritest.dbservice.repository;

import com.sritest.dbservice.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotesRepository extends JpaRepository<Quote,Integer> {
    List<Quote> findByUserName(String userName);
}
