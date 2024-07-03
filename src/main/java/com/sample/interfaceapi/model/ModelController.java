package com.autos.api.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.autos.api.common.SuccessResponse;

@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    Logger logger = LoggerFactory.getLogger(ModelController.class);

    @PostMapping("/model")
    public SuccessResponse<Model> model(@Valid @RequestBody ModelRequest modelRequest) {
        logger.info("Received request to /model");
        return modelService.getModelBlocking(modelRequest);
    }
}
