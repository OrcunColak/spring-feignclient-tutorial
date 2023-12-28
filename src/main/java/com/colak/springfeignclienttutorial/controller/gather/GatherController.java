package com.colak.springfeignclienttutorial.controller.gather;

import com.colak.springfeignclienttutorial.service.GatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/gatherservice")
public class GatherController {

    private final GatherService gatherService;

    @GetMapping(path = "gather/{id}")
    public String getQuote (@PathVariable("id") int id) throws URISyntaxException {
        return gatherService.gather(id);
    }
}
