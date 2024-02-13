package com.colak.springfeignclienttutorial.internaldemo.controller;

import com.colak.springfeignclienttutorial.internaldemo.feignclient.Service1Client;
import com.colak.springfeignclienttutorial.internaldemo.feignclient.Service1Response;
import com.colak.springfeignclienttutorial.internaldemo.service.GatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/gather")
public class GatheringController {

    private final GatherService gatherService;

    private final Service1Client service1Client;

    // http://localhost:8080/api/gather/getQuote/1
    @GetMapping(path = "getQuote/{id}")
    public String getQuote(@PathVariable("id") int id) throws URISyntaxException {
        return gatherService.gather(id);
    }

    // http://localhost:8080/api/gather/getService1Quote/1
    @GetMapping(path = "getService1Quote/{id}")
    public String getService1Quote(@PathVariable("id") int id) {
        ResponseEntity<Service1Response> response = service1Client.getQuote(id);
        Service1Response service1Response = response.getBody();
        assert service1Response != null;
        return service1Response.getMsg();
    }
}
