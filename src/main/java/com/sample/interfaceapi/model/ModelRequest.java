 package com.autos.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL) @Getter @Setter @NoArgsConstructor
public class ModelRequest {
    @JsonProperty("xVarNames")
    private String[] xVarNames;

    @JsonProperty("yVarName")
    private String yVarName;

    @JsonProperty("polynomial")
    private Integer polynomial;

    @JsonProperty("width")
    private Integer width;
}
