package com.pluralsight;

public class Drink {
    private String size;   // Small, Medium, Large
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: return 0.00;
        }
    }

    @Override
    public String toString() {
        return size + " " + flavor + " drink - $" + String.format("%.2f", getPrice());
    }
}
