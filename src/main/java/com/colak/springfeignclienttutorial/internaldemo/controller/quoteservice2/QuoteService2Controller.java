package com.colak.springfeignclienttutorial.internaldemo.controller.quoteservice2;

import com.colak.springfeignclienttutorial.feignclient.Service1Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/service2")
public class QuoteService2Controller {

    @GetMapping(path = "getQuote/{id}")
    public Service1Response getQuote (@PathVariable("id") int id) {
        String message = "Quote 2 : " + id;
        Service1Response service1Response = new Service1Response();
        service1Response.setMsg(message);
        return service1Response;
    }
}
