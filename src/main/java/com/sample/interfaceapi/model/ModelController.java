package com.autos.api.model;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}
