package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Zoltan Altfatter
 */
public class FiboCalcResponse {

    private int number;

    private long fibo;

    public FiboCalcResponse(@JsonProperty("number") int number, @JsonProperty("fibo") long fibo) {
        this.number = number;
        this.fibo = fibo;
    }

    public int getNumber() {
        return number;
    }

    public long getFibo() {
        return fibo;
    }

}
