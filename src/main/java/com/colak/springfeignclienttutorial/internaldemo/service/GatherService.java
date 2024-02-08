package com.colak.springfeignclienttutorial.internaldemo.service;

import java.net.URISyntaxException;

public interface GatherService {

    String gather (int id) throws URISyntaxException;
}
