package com.autos.api.model;

import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autos.api.common.SuccessResponse;

@Component
@PropertySource("classpath:application.properties")
public class ModelService {
    Logger logger = LoggerFactory.getLogger(ModelController.class);

    

    @Value("${analytics.service.url}")
    private String analyticsServiceUrl;

    // fetched model from analytcis API based on user provided inputs
    public SuccessResponse<Model> getModelBlocking(ModelRequest modelRequest) {
        WebClient client = WebClient.create(analyticsServiceUrl);

        // currently default 30 second timeout on request
        SuccessResponse<Model> model;
        logger.info("attempt to fetch model from analytics api");
        model = client.post()
            .uri("/autos-model")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(modelRequest)
            .retrieve()
            .bodyToMono(SuccessResponse.class)
            .block();
        
        return model;
    }
}
