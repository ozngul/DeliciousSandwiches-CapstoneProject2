package com.pluralsight;

import java.util.*;

public class Sandwich {
    private String size; // "4", "8", or "12"
    private String breadType; // white, wheat, rye, wrap
    private boolean toasted;

    private List<String> meats = new ArrayList<>();
    private Map<String, Integer> extraMeatCount = new HashMap<>();

    private List<String> cheeses = new ArrayList<>();
    private Map<String, Integer> extraCheeseCount = new HashMap<>();

    private List<String> regularToppings = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();

    // Constructor
    public Sandwich(String size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
    }

    // Add methods
    public void addMeat(String meat) {
        meats.add(meat);
    }

    public void addExtraMeat(String meat) {
        extraMeatCount.put(meat, extraMeatCount.getOrDefault(meat, 0) + 1);
    }

    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    public void addExtraCheese(String cheese) {
        extraCheeseCount.put(cheese, extraCheeseCount.getOrDefault(cheese, 0) + 1);
    }

    public void addRegularTopping(String topping) {
        regularToppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    public double getPrice() {
        double price = 0;

        // Base sandwich price
        switch (size) {
            case "4":
                price += 5.50;
                break;
            case "8":
                price += 7.00;
                break;
            case "12":
                price += 8.50;
                break;
        }

        // Meat pricing
        for (String meat : meats) {
            switch (size) {
                case "4": price += 1.00; break;
                case "8": price += 2.00; break;
                case "12": price += 3.00; break;
            }

            int extra = extraMeatCount.getOrDefault(meat, 0);
            switch (size) {
                case "4": price += extra * 0.50; break;
                case "8": price += extra * 1.00; break;
                case "12": price += extra * 1.50; break;
            }
        }

        // Cheese pricing
        for (String cheese : cheeses) {
            switch (size) {
                case "4": price += 0.75; break;
                case "8": price += 1.50; break;
                case "12": price += 2.25; break;
            }

            int extra = extraCheeseCount.getOrDefault(cheese, 0);
            switch (size) {
                case "4": price += extra * 0.30; break;
                case "8": price += extra * 0.60; break;
                case "12": price += extra * 0.90; break;
            }
        }

        return price;
    }

    @Override
    public String toString() {
        return size + "\" " + breadType + " sandwich" + (toasted ? " [Toasted]" : "") + "\n" +
                "Meats: " + meats + "\n" +
                "Extra Meats: " + extraMeatCount + "\n" +
                "Cheeses: " + cheeses + "\n" +
                "Extra Cheeses: " + extraCheeseCount + "\n" +
                "Toppings: " + regularToppings + "\n" +
                "Sauces: " + sauces + "\n" +
                "Total: $" + String.format("%.2f", getPrice());
    }
}
