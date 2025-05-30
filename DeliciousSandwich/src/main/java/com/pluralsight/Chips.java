package com.pluralsight;

// The Chips class represents a chips item in the menu.
// It inherits from the abstract class MenuItem.
public class Chips extends MenuItem {

    // Constructor: Takes the type of chips (e.g., "Doritos") and
    // passes the full name (e.g., "Doritos chips") to the parent MenuItem constructor.
    public Chips(String type) {
        super(type + " chips");
    }

    // Returns the fixed price of any chips item: $1.50
    @Override
    public double getPrice() {
        return 1.50;
    }

    // Returns a string representation of the chips item,
    // showing its name and price formatted to two decimal places.
    // Example: "Doritos chips - $1.50"
    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", getPrice());
    }
}
