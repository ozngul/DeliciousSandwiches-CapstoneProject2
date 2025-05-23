package com.pluralsight;

public class Drink {
    private String size;
    private String flavor;

    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: return 0;
        }
    }
}
