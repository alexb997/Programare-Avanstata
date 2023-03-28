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

    private ArrayList<Item> listItem;
}
