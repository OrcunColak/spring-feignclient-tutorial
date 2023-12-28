package com.colak.springfeignclienttutorial.service.impl;

import com.colak.springfeignclienttutorial.feignclient.Service1Client;
import com.colak.springfeignclienttutorial.feignclient.Service1NewClient;
import com.colak.springfeignclienttutorial.feignclient.Service1Response;
import com.colak.springfeignclienttutorial.service.GatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@RequiredArgsConstructor
@Service
public class GatherServiceImpl implements GatherService {

    private final Service1Client service1Client;
    private final Service1NewClient service1NewClient;

    @Override
    public String gather(int id) throws URISyntaxException {
        ResponseEntity<Service1Response> response1 = service1Client.getQuote(id);
        Service1Response service1Response1 = response1.getBody();
        assert service1Response1 != null;

        URI baseUrl = URI.create("http://localhost:8080/api/service1");
        ResponseEntity<Service1Response> response2 = service1NewClient.getQuote(baseUrl,1);
        Service1Response service1Response2 = response2.getBody();
        assert service1Response2 != null;

        return service1Response1.getMsg() + " " + service1Response2.getMsg();
    }
}
