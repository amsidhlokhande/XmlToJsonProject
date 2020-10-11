package com.amsidh.mvc.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonSdpMapping {
    @JsonProperty("attributeMappings")
    private List<AttributeMapping> attributeMappings = new ArrayList<>();
}
