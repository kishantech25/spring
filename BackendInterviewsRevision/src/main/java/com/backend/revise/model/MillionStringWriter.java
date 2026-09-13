package com.backend.revise.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MillionStringWriter {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int STRING_LENGTH = 10;
    private static final int TOTAL_STRINGS = 1_000_000;
    private static final int BATCH_SIZE = 5000; // Flushes to disk periodically for memory efficiency

    public static void main(String[] args) {
        String filePath = "C:/Users/KISHANTECH/Spring/sample.txt";
        System.out.println("Starting generation of 1 million random strings...");

        long startTime = System.currentTimeMillis();

        // Use try-with-resources to safely close the writer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            Random random = new Random();
            StringBuilder batchBuilder = new StringBuilder(BATCH_SIZE * (STRING_LENGTH + 1));

            for (int i = 0; i < TOTAL_STRINGS; i++) {
                // Generate a random string of fixed length
                for (int j = 0; j < STRING_LENGTH; j++) {
                    int index = random.nextInt(CHARACTERS.length());
                    batchBuilder.append(CHARACTERS.charAt(index));
                }
                batchBuilder.append("  ");

                // Write in batches to optimize memory and I/O speed
                if (i % BATCH_SIZE == 0) {
                    writer.write(batchBuilder.toString());
                    batchBuilder.setLength(0); // Clear the buffer
                }
            }

            // Write any remaining strings in the buffer
            if (batchBuilder.length() > 0) {
                writer.write(batchBuilder.toString());
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Successfully updated/created " + filePath + " in " + (endTime - startTime) + " ms.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
