package com.think.models.indicators.variables;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Variable {

    private String key;
    private String name;
    private String unitMeasurement;
    private String measurementFrequency;
    private String initialDate;
    private Boolean isIndicator;
    private String goal;
    private String goalValue;
    private List<Values> values = new ArrayList<>();
}
