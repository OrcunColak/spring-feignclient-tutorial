package com.colak.springfeignclienttutorial.internaldemo.controller.quoteservice1;

import com.colak.springfeignclienttutorial.feignclient.Service1Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/service1")
public class QuoteService1Controller {

    // http://localhost:8080/actuator/health
    // http://localhost:8080/api/service1/getQuote/2
    @GetMapping(path = "getQuote/{id}")
    public ResponseEntity<Service1Response> getQuote (@PathVariable("id") int id) {
        if (id == 2) {
            return ResponseEntity.badRequest().build();
        }
        String message = "Quote 1 : " + id;
        Service1Response service1Response = new Service1Response();
        service1Response.setMsg(message);
        return ResponseEntity.ok(service1Response);
    }
}
