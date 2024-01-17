package com.colak.springfeignclienttutorial.controller.gather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Run on default port 8080
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class GatherControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    // Gather Quotes from Service1 and Service2
    @Test
    void testGather() {
        String getUrl = "http://localhost:8080/api/gather/getQuote/1";

        ResponseEntity<String> response = restTemplate.getForEntity(getUrl, String.class);
        String message = response.getBody();
        assert message != null;

        assertEquals("Quote 1 : 1 Quote 2 : 2", message);
    }

    // Quote Service1 throws exception for id : 2
    @Test
    void testService1Failure() {
        String getUrl = "http://localhost:8080/api/gather/getService1Quote/2";
        ResponseEntity<String> response = restTemplate.getForEntity(getUrl, String.class);
        String message = response.getBody();
        assert message != null;

        assertEquals("Service 1 default message", message);
    }
}
