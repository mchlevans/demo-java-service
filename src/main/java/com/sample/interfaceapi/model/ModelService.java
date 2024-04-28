package com.autos.api.model;

import org.springframework.stereotype.Component;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ModelService {

    Logger logger = LoggerFactory.getLogger(ModelController.class);

    // simple implementation, default 30 second timeout
    // to-do: move hardcoded url to config
    WebClient client = WebClient.create("http://analytics:8000");

    // fetched model from analytcis API based on configs
    public ModelResponse getModelBlocking(ModelRequest modelRequest) {
        ModelResponse model;

        logger.info("attempt to fetch model from analytics api");
        model = client.post()
            .uri("/poly")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(modelRequest)
            .retrieve()
            .bodyToMono(ModelResponse.class)
            .block();
        
        return model;
    }
}
