package com.company;

import java.util.ArrayList;
import java.util.Random;

public class RandomAlgorithm implements Algorithm {
    public RandomAlgorithm(){
        this.assetList = new ArrayList<>();
    }

    public void setProblemData(ArrayList<Item> assetList, int maxValue){
        this.assetList.addAll(assetList);
        this.maxValue = maxValue;
    }

    public ArrayList<Item> getSolution(){
        double currentCost = 0.0, currentProfit = 0.0;
        boolean addItem;

        Random random = new Random();
        ArrayList<Item> assetRemove = new ArrayList<>();

        for(Item asset : assetList){
            addItem = (random.nextInt(10) % 2) != 0;

            if(addItem){
                if(currentCost + asset.getPrice() > maxValue){
                    assetRemove.add(asset);
                    continue;
                }
                currentCost += asset.getPrice();
                currentProfit += ((Asset)asset).getProfit();
            }
            else{
                assetRemove.add(asset);
            }
        }

        assetList.removeAll(assetRemove);
        return assetList;
    }

    private ArrayList<Item> assetList;
    private int maxValue;
}
