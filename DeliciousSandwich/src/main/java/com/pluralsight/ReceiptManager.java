package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class ReceiptManager {
    public static void saveReceipt(Order order) {
        String folderPath = "receipts";
        File folder = new File(folderPath);

        // Klasör yoksa hata mesajı ver ve çık
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Error: 'receipts' folder does not exist. Please create it manually.");
            return;
        }

        String fileName = folderPath + "/" + order.getFormattedTimestamp() + ".txt";

        try (
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter writer = new BufferedWriter(fw)
        ) {
            writer.write(order.getSummary());
            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
