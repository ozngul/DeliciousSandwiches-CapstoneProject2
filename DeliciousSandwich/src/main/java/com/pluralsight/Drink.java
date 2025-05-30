package com.pluralsight;

// The Drink class represents a drink item in the menu.
// It extends the MenuItem abstract class and adds size-based pricing.
public class Drink extends MenuItem {
    private String size; // Size of the drink: small, medium, or large

    // Constructor: Initializes the drink with a size and flavor.
    // Passes the full name (e.g., "small cola drink") to the parent MenuItem class.
    public Drink(String size, String flavor) {

        super(size + " " + flavor + " drink");
        this.size = size;
    }

    // Returns the price based on the size of the drink.
    @Override
    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: return 0.00; // Fallback in case of invalid size
        }
    }

    // Returns a string representation of the drink,
    // including its name and price formatted to two decimal places.
    // Example: "small cola drink - $2.00"
    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", getPrice());
    }
}
