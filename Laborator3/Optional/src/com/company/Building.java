package com.company;

public class Building extends Item implements Asset {
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getProfit() {
        return profit;
    }

    public Building(String name, double area, double price, double risk){
        this.setName(name);
        this.area = area;
        this.setPrice(price);
        this.computeProfit();

        if(evalRisk(risk)){
            this.risk = risk;
        }
        else{
            this.risk = 0;
        }
    }
    public Building(String name, double area, double price){
        this.setName(name);
        this.area = area;
        this.setPrice(price);
        this.computeProfit();
        this.risk = 0;
    }

    public double getRisk(){
        return risk;
    }
    public void computeProfit(){
        profit = area / this.getPrice() * (1 - getRisk());
    }

    @Override
    public String toString() {
        return "Building{" +
                "area=" + area +
                ", profit=" + profit +
                ", risk=" + risk +
                ", name='" + name + '\'' +
                ", price=" + price +
                "}\n";
    }

    private double area;
    private double profit, risk;
}
