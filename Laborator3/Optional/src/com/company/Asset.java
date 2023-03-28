package com.company;

import java.util.Random;

public interface Asset {
    public void computeProfit();
    public double getProfit();
    public double getRisk();

    default boolean evalRisk(double risk){
        return risk >= 0 && risk <= 1;
    }
}
