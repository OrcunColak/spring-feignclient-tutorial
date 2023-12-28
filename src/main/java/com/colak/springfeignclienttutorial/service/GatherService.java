package com.colak.springfeignclienttutorial.service;

import java.net.URISyntaxException;

public interface GatherService {

    String gather (int id) throws URISyntaxException;
}
