package com.company;

public class Jewel extends Item {

    public Jewel(String name, double price){
        this.setName(name);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        return "Jewel{" +
                "name='" + name + '\'' +
                ", price=" + price +
                "}\n";
    }
}
