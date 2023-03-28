package com.company;

import java.util.ArrayList;

public interface Algorithm {
    public void setProblemData(ArrayList<Item> assetList, int maxValue);
    public ArrayList<Item> getSolution();
}
