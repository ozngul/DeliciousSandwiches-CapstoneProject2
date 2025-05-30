package com.pluralsight;

// This interface defines a contract for any item that has a price.
// Any class that implements Pricable must provide its own implementation of getPrice().
public interface Pricable {
    double getPrice();  // Method to return the price of an item
}
