package com.autos.api.model;

import java.util.Map;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Model Response from analytics api
@Getter @Setter @NoArgsConstructor
public class ModelResponse {
    private String status;
    private Map<String, String[]> errors;
    private Model data;
}
