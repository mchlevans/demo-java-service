package com.autos.api.common;

import java.util.Map;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Model Response from analytics api
@Getter @Setter @NoArgsConstructor
public class SuccessResponse<T> {
    private String status;
    private T data;
}
