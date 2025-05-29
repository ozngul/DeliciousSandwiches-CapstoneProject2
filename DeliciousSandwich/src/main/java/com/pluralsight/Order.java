package com.pluralsight;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();
    private LocalDateTime orderTime;

    public Order() {
        this.orderTime = LocalDateTime.now();
    }

    // Add methods
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Sandwich s : sandwiches) {
            total += s.getPrice();
        }
        for (Drink d : drinks) {
            total += d.getPrice();
        }
        for (Chips c : chips) {
            total += c.getPrice();
        }
        return total;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== DELI-cious Order Receipt =====\n");

        // Tarih ve saat
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sb.append("Order Time: ").append(orderTime.format(formatter)).append("\n");
        sb.append("------------------------------------\n");

        if (sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty()) {
            sb.append("Your order is empty.\n");
        } else {
            if (!sandwiches.isEmpty()) {
                sb.append("\n--- Sandwiches ---\n");
                for (Sandwich s : sandwiches) {
                    sb.append(s.toString()).append("\n");
                }
            }

            if (!drinks.isEmpty()) {
                sb.append("\n--- Drinks ---\n");
                for (Drink d : drinks) {
                    sb.append(d.toString()).append("\n");
                }
            }

            if (!chips.isEmpty()) {
                sb.append("\n--- Chips ---\n");
                for (Chips c : chips) {
                    sb.append(c.toString()).append("\n");
                }
            }

            sb.append("\n------------------------------------\n");
            sb.append(String.format("Total: $%.2f\n", getTotalPrice()));
        }

        sb.append("====================================\n");
        return sb.toString();
    }


    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return orderTime.format(formatter);
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }
}
