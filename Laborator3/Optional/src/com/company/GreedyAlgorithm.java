package com.company;

import java.util.ArrayList;

public class GreedyAlgorithm implements Algorithm {
    public GreedyAlgorithm(){
        assetList = new ArrayList<>();
    }

    public void setProblemData(ArrayList<Item> assetList, int maxValue){
        this.assetList.addAll(assetList);
        this.maxValue = maxValue;
    }

    public ArrayList<Item> getSolution(){
        double currentCost = 0.0;
        ArrayList<Item> keepAsset = new ArrayList<>();

        for(int indexAsset = assetList.size() - 1; indexAsset >= 0; indexAsset --){
            Item currentItem = assetList.get(indexAsset);

            if(currentCost + currentItem.getPrice() <= maxValue){
                keepAsset.add(currentItem);
                currentCost += currentItem.getPrice();
            }
        }
        return keepAsset;
    }

    private ArrayList<Item> assetList;
    private int maxValue;
}
