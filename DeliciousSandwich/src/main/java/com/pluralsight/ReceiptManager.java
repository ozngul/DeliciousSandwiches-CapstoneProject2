package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;

public class ReceiptManager {
    public static void saveReceipt(Order order) {
        String folderPath = "receipts";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs(); // klasör yoksa oluştur
        }

        String timestamp = order.getFormattedTimestamp(); // Order sınıfında var
        String fileName = folderPath + "/" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(order.getSummary());
            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
