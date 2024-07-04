package com.autos.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL) @Getter @Setter @NoArgsConstructor
public class ModelRequest {
    @NotNull(message = "must provide list of xVarNames")
    @JsonProperty("xVarNames")
    private String[] xVarNames;

    @JsonProperty("yVarName")
    @NotNull(message = "must provide yVarName")
    private String yVarName;

    @JsonProperty("polynomial")
    @NotNull(message = "must provide polynomial")
    private Integer polynomial;

    @JsonProperty("width")
    private Integer width;
}
