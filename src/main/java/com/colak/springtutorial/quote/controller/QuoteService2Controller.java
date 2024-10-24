package com.colak.springtutorial.quote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/service2")
public class QuoteService2Controller {

    /**
     * This controller does not throw exception
     */
    @GetMapping(path = "getQuote/{id}")
    public QuoteResponse getQuote(@PathVariable("id") int id) {
        String message = "Quote 2 : " + id;
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setMsg(message);
        return quoteResponse;
    }
}
