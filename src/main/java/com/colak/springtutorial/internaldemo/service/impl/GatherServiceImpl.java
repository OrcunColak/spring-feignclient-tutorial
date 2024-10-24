package com.colak.springtutorial.internaldemo.service.impl;

import com.colak.springtutorial.internaldemo.feignclient.Service1Client;
import com.colak.springtutorial.internaldemo.feignclient.Service2Client;
import com.colak.springtutorial.quote.controller.QuoteResponse;
import com.colak.springtutorial.internaldemo.service.GatherService;
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
        QuoteResponse quote = getService1Response(id);
        assert quote != null;

        QuoteResponse quoteResponse2 = getService2Response();
        assert quoteResponse2 != null;

        return quote.getMsg() + " " + quoteResponse2.getMsg();
    }


    private QuoteResponse getService1Response(int id) {
        ResponseEntity<QuoteResponse> response1 = service1Client.getQuote(id);
        return response1.getBody();
    }

    private QuoteResponse getService2Response() {
        URI baseUrl = URI.create("http://localhost:8080/api/service2");
        ResponseEntity<QuoteResponse> response2 = service2Client.getQuote(baseUrl, 2);
        return response2.getBody();
    }
}
