package com.autos.api.common;

import java.util.Map;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

// generic error response
@Getter @Setter @NoArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    private List<String> errors;
}
