package com.company;

public class Vehicle extends Item implements Asset {
    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public float getProfit() {
        return profit;
    }

    public Vehicle(String name, int performance, int price){
        this.setName(name);
        this.performance = performance;
        this.setPrice(price);
        this.computeProfit();
    }

    public void computeProfit(){
        profit = performance / this.getPrice();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "performance=" + performance +
                ", profit=" + profit +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    private int performance;
    private float profit;
}

