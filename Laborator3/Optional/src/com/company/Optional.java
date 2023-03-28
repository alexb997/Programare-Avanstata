package com.company;

public class Optional {

    public static void main(String[] args) {
        Building h1 = new Building("House 1", 27, 9);
        Building h2 = new Building("House 2", 27, 9);
        Building h3 = new Building("House 3", 64, 16);

        Vehicle c1 = new Vehicle("Car 1", 8, 4);
        Vehicle c2 = new Vehicle("Car 2", 8, 4);

        Jewel ring = new Jewel("Gold Diamond Ring", 2);

        AssetManager manager = new AssetManager();
        manager.add(h1, h2, h3);
        manager.add(c1, c2);
        manager.add(ring);

        //System.out.println("Assets sorted by the profit: " + manager.getAssets());

        int maxValue = 20;
        Portofolio solution = manager.createPortofolio(new GreedyAlgorithm(), maxValue);
        System.out.println("The best portofolio: " + solution + "\n\n");

        Portofolio solution2 = manager.createPortofolio(new RandomAlgorithm(), maxValue);
        System.out.println("The best portofolio: " + solution2);
    }
}
