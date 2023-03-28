package com.company;

public class Vehicle extends Item implements Asset {
    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }

    public double getProfit() {
        return profit;
    }

    public Vehicle(String name, double performance, double price, double risk){
        this.setName(name);
        this.performance = performance;
        this.setPrice(price);
        this.computeProfit();

        if(evalRisk(risk)){
            this.risk = risk;
        }
        else{
            this.risk = 0;
        }
    }
    public Vehicle(String name, double performance, double price){
        this.setName(name);
        this.performance = performance;
        this.setPrice(price);
        this.computeProfit();
        this.risk = 0;
    }

    public double getRisk(){
        return risk;
    }
    public void computeProfit(){
        profit = performance / this.getPrice() * (1 - getRisk());;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "performance=" + performance +
                ", profit=" + profit +
                ", risk=" + risk +
                ", name='" + name + '\'' +
                ", price=" + price +
                "}\n";
    }

    private double performance;
    private double profit, risk;
}

