package com.pluralsight;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// The Order class holds all items selected by the customer in one order
public class Order {
    // Lists to store sandwiches, drinks, and chips added to the order
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();
    private List<Cookies> cookies = new ArrayList<>();

    // Timestamp of when the order was created
    private LocalDateTime orderTime;

    // Constructor: sets the order time to the current date and time
    public Order() {
        this.orderTime = LocalDateTime.now();
    }

    // Methods to add items to the order
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }
    public void addCookies(Cookies cookie) {
        cookies.add(cookie);
    }

    // Calculates the total price of all items in the order
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
        for (Cookies c : cookies) {
            total += c.getPrice();
        }
        return total;
    }

    // Builds and returns a full summary (receipt) of the order
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== DeliciousSandwich Order Receipt =====\n");

        // Formats and adds the order date/time
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
            }if (!cookies.isEmpty()) {
                sb.append("\n--- Cookies ---\n");
                for (Cookies c : cookies) {
                    sb.append(c.toString()).append("\n");
                }
            }

            sb.append("\n------------------------------------\n");
            sb.append(String.format("Total: $%.2f\n", getTotalPrice()));
        }

        sb.append("====================================\n");
        return sb.toString();
    }

    // Returns a timestamp formatted for use in filenames, etc.
    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return orderTime.format(formatter);
    }

    // Getters for order time and lists of items
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
