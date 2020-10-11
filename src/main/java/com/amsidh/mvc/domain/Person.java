package com.amsidh.mvc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Person {
    private String personName;
    private List<Location> locations = new ArrayList<Location>();
    private String profession;

}
