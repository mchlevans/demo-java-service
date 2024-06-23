 package com.autos.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class ModelRequest {
    @JsonProperty("xVarNames")
    private String[] xVarNames;

    @JsonProperty("yVarName")
    private String yVarName;

    @JsonProperty("polynomial")
    private int polynomial;
}
