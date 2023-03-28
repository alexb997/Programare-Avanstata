package com.company;

public class Building extends Item implements Asset {
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public float getProfit() {
        return profit;
    }

    public Building(String name, int area, int price){
        this.setName(name);
        this.area = area;
        this.setPrice(price);
        this.computeProfit();
    }

    public void computeProfit(){
        profit = area / this.getPrice();
    }

    @Override
    public String toString() {
        return "Building{" +
                "area=" + area +
                ", profit=" + profit +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    private int area;
    private float profit;
}
