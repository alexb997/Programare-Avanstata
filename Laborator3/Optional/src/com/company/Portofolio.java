package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Portofolio {
    private ArrayList<Item> portofolioList;
    private double finalPrice, finalProfit;

    public Portofolio(){
        portofolioList = new ArrayList<>();
        finalPrice = 0.0;
        finalProfit = 0.0;
    }

    public ArrayList<Item> getPortofolioList() {
        return portofolioList;
    }
    public void setPortofolioList(ArrayList<Item> portofolioList){
        this.portofolioList.addAll(portofolioList);

        Collections.sort(this.portofolioList, new Comparator<Item>() {
            @Override
            public int compare(Item itemOne, Item itemTwo) {
                double valueOne = ((Asset)itemOne).getProfit();
                double valueTwo = ((Asset)itemTwo).getProfit();

                if(valueOne < valueTwo){
                    return -1;
                }
                if(valueOne == valueTwo){
                    return 0;
                }

                return 1;
            }
        });

        for(Item item : portofolioList){
            finalPrice += item.getPrice();
            finalProfit += ((Asset)item).getProfit();
        }
    }

    @Override
    public String toString() {
        return "Portofolio{" +
                "portofolioList=\n" + portofolioList +
                ", finalPrice=" + finalPrice +
                ", finalProfit=" + finalProfit +
                "}\n";
    }
}
