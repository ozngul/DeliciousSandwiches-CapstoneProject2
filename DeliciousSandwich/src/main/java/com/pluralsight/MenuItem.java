package com.pluralsight;

// Abstract base class for all menu items (e.g., Drink, Chips, Sandwich).
// Implements the Pricable interface to ensure all items have a getPrice() method.
public abstract class MenuItem implements Pricable {
    // Common name field for all menu items (e.g., "small cola drink", "Ruffles chips")
    protected String name;

    // Constructor: Initializes the menu item with a name
    public MenuItem(String name) {
        this.name = name;
    }

    // Getter for the item name
    public String getName() {
        return name;
    }

    // Abstract method to get the price of the item.
    // Each subclass must provide its own implementation since pricing varies.
    public abstract double getPrice();
}
