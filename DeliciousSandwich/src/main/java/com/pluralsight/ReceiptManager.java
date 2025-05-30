package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

// This class is responsible for saving order receipts to text files.
public class ReceiptManager {

    // Saves the summary of an order to a text file in the 'receipts' folder.
    public static void saveReceipt(Order order) {
        String folderPath = "receipts";
        File folder = new File(folderPath);

        // Check if the 'receipts' folder exists; if not, display error and stop.
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Error: 'receipts' folder does not exist. Please create it manually.");
            return;
        }

        // Generate the file name using the timestamp of the order.
        String fileName = folderPath + "/" + order.getFormattedTimestamp() + ".txt";

        // Try-with-resources block ensures the file is closed properly.
        try (
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter writer = new BufferedWriter(fw)
        ) {
            writer.write(order.getSummary());  // Write the full order summary to the file
            System.out.println("Receipt saved to: " + fileName);  // Confirm success
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());  // Handle file I/O errors
        }
    }
}
