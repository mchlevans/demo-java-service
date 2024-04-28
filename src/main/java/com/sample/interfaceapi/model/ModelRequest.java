 package com.autos.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class ModelRequest {
    @JsonProperty("xVarName")
    private String xVarName;

    @JsonProperty("yVarName")
    private String yVarName;
}
