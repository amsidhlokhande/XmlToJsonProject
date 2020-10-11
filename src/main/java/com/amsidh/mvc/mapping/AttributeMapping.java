package com.amsidh.mvc.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AttributeMapping {

    @JsonProperty("directMappings")
    private List<Attribute> directMappings = new ArrayList<>();

    @JsonProperty("arrayMappings")
    private List<Attribute> arrayMappings = new ArrayList<>();
}
