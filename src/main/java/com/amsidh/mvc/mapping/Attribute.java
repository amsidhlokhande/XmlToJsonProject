package com.amsidh.mvc.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Attribute {

    @JsonProperty("attributeName")
    private String attributeName;

    @JsonProperty("attributeType")
    private String attributeType;

    @JsonProperty("sourceAttribute")
    private String sourceAttribute;

    @JsonProperty("sourceAttributeType")
    private String sourceAttributeType;

    @JsonProperty("populationLogic")
    private String populationLogic;

    @JsonProperty("attributes")
    private List<Attribute> attributes = new ArrayList<>();

}
