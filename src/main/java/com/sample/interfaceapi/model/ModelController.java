package com.autos.api.model;

import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class ModelController {

    Logger logger = LoggerFactory.getLogger(ModelController.class);

    @PostMapping("/model")
    public ModelResponse model(@RequestBody ModelRequest modelRequest) {
        logger.info("Received request to /model");
        ModelService modelService = new ModelService();
        return modelService.getModelBlocking(modelRequest);
    }

    // see if you can get a more specific error by catching
    // the initial WebClientResponseException and re-throwing
    // your own exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WebClientResponseException.class)
    public ModelResponse handle(WebClientResponseException exception) {
        logger.info("Bad requests handeled in ModelController");
        return exception.getResponseBodyAs(ModelResponse.class);
    }
}
