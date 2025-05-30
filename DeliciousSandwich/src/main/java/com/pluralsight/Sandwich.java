package com.pluralsight;

import java.util.*;

// Represents a customizable sandwich item that extends MenuItem
public class Sandwich extends MenuItem {
    private String size;          // Sandwich size: "4", "8", or "12" inches
    private String breadType;     // Type of bread (e.g., white, wheat, rye, wrap)
    private boolean toasted;      // Whether the sandwich is toasted

    // Meats and extra meat tracking
    private List<String> meats = new ArrayList<>();
    private Map<String, Integer> extraMeatCount = new HashMap<>();

    // Cheeses and extra cheese tracking
    private List<String> cheeses = new ArrayList<>();
    private Map<String, Integer> extraCheeseCount = new HashMap<>();

    // Regular toppings and sauces
    private List<String> regularToppings = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();

    // Constructor sets name from parent class and initializes fields
    public Sandwich(String size, String breadType, boolean toasted) {
        super(size + "\" " + breadType + " sandwich" + (toasted ? " [Toasted]" : ""));
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
    }

    // Methods to add ingredients
    public void addMeat(String meat) {
        meats.add(meat);
    }

    public void addExtraMeat(String meat) {
        // Track how many extra portions of each meat
        extraMeatCount.put(meat, extraMeatCount.getOrDefault(meat, 0) + 1);
    }

    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    public void addExtraCheese(String cheese) {
        // Track how many extra portions of each cheese
        extraCheeseCount.put(cheese, extraCheeseCount.getOrDefault(cheese, 0) + 1);
    }

    public void addRegularTopping(String topping) {
        regularToppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    // Calculates the total price based on size and ingredients
    @Override
    public double getPrice() {
        double price = 0;

        // Base sandwich price based on size
        switch (size) {
            case "4": price += 5.50; break;
            case "8": price += 7.00; break;
            case "12": price += 8.50; break;
        }

        // Price of meats + extra meat
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

        // Price of cheeses + extra cheese
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

        // Regular toppings and sauces are free
        return price;
    }

    // Returns a detailed summary of the sandwich
    @Override
    public String toString() {
        return name + "\n" +
                "Meats: " + meats + "\n" +
                "Extra Meats: " + extraMeatCount + "\n" +
                "Cheeses: " + cheeses + "\n" +
                "Extra Cheeses: " + extraCheeseCount + "\n" +
                "Toppings: " + regularToppings + "\n" +
                "Sauces: " + sauces + "\n" +
                "Total: $" + String.format("%.2f", getPrice());
    }
}
