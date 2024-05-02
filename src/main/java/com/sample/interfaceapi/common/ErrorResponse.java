package com.autos.api.common;

import java.util.Map;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// generic error response
@Getter @Setter @NoArgsConstructor
public class ErrorResponse {
    private String status;
    private Map<String, String[]> errors;
}
