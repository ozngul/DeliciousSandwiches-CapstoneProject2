package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public double getTotalPrice() {
        // to be implemented
        return 0;
    }

    public String getOrderSummary() {
        // to be implemented
        return "";
    }
}
