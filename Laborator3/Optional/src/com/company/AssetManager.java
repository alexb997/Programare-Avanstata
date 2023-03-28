package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AssetManager {
    public AssetManager(){
        listItem = new ArrayList<>();
    }

    public void add(Item ... listItem){
        for(Item item : listItem){

            for(Item itemExistent : this.listItem){
                if(itemExistent.getName().equals(item.getName())){
                    return;
                }
            }

            this.listItem.add(item);
        }
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> sortedListItem = new ArrayList<>();
        sortedListItem.addAll(listItem);

        Collections.sort(sortedListItem, new Comparator<Item>() {
            @Override
            public int compare(Item itemOne, Item itemTwo) {
                return  itemOne.getName().compareTo(itemTwo.getName());
            }
        });
        return sortedListItem;
    }

    public ArrayList<Item> getAssets(){
        ArrayList<Item> sortedListItem = new ArrayList<>();
        for(Item item : listItem){
            if(item instanceof Asset){
                sortedListItem.add(item);
            }
        }

        Collections.sort(sortedListItem, new Comparator<Item>() {
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
        return sortedListItem;
    }

    public Portofolio createPortofolio(Algorithm algorithm, int maxValue){
        Portofolio portofolio = new Portofolio();
        ArrayList<Item> assetList = getAssets();

        algorithm.setProblemData(assetList, maxValue);
        portofolio.setPortofolioList(algorithm.getSolution());
        return portofolio;
    }

    private ArrayList<Item> listItem;
}
