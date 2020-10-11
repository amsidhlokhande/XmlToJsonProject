package com.amsidh.mvc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Location {
    private String state;
    private List<Mobile> phoneNumbers = new ArrayList<Mobile>();

}
