package com.amsidh.mvc.mapping;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DirectMapping {
    private List<Attribute> attributes = new ArrayList<>();
}
