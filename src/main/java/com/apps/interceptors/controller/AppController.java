package com.apps.interceptors.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/app")
public class AppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @RequestMapping(method = RequestMethod.GET, path = "/public")
    public ResponseEntity<String> getPublicContents(){
        LOGGER.info(">>>>> Controller is executing getPublicContents() method...");
        return new ResponseEntity<>("PUBLIC CONTENTS...", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/params")
    public ResponseEntity<String> getParamsContents(){
        LOGGER.info(">>>>> Controller is executing getParamsContents() method...");
        return new ResponseEntity<>("PARAMS CONTENTS...", HttpStatus.OK);
    }
}
