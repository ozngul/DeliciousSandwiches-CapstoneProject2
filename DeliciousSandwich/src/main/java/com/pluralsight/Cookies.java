package com.pluralsight;

public class Cookies extends MenuItem{
    public Cookies(String type) {
        super(type + " cookies");
    }
    @Override
    public double getPrice() {
        return 1.00;
    }

    // Returns a string representation of the chips item,
    // showing its name and price formatted to two decimal places.
    // Example: "Doritos chips - $1.50"
    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", getPrice());
    }
}

