package com.colak.springfeignclienttutorial.internaldemo.service.impl;

import com.colak.springfeignclienttutorial.internaldemo.feignclient.Service1Client;
import com.colak.springfeignclienttutorial.internaldemo.feignclient.Service2Client;
import com.colak.springfeignclienttutorial.internaldemo.feignclient.Service1Response;
import com.colak.springfeignclienttutorial.internaldemo.service.GatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@RequiredArgsConstructor
@Service
public class GatherServiceImpl implements GatherService {

    private final Service1Client service1Client;
    private final Service2Client service2Client;

    @Override
    public String gather(int id) {
        Service1Response service1Response1 = getService1Response(id);
        assert service1Response1 != null;

        Service1Response service1Response2 = getService2Response();
        assert service1Response2 != null;

        return service1Response1.getMsg() + " " + service1Response2.getMsg();
    }


    private Service1Response getService1Response(int id) {
        ResponseEntity<Service1Response> response1 = service1Client.getQuote(id);
        return response1.getBody();
    }

    private Service1Response getService2Response() {
        URI baseUrl = URI.create("http://localhost:8080/api/service2");
        ResponseEntity<Service1Response> response2 = service2Client.getQuote(baseUrl, 2);
        return response2.getBody();
    }
}
