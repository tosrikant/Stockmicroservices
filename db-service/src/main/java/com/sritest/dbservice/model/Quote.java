package com.sritest.dbservice.model;


import javax.persistence.*;


@Entity
@Table(name="quotes",catalog ="test")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer Id;


    @Column(name = "user_name")
    private String userName;

    @Column(name="quote")
    private String quote;

    public Quote(){

    }
    public Quote(String userName, String quote) {
        this.userName = userName;
        this.quote = quote;
    }
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
