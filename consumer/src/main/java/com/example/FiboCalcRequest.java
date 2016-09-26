package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Zoltan Altfatter
 */

public class FiboCalcRequest {

    private int number;

    public FiboCalcRequest(@JsonProperty("number") int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
