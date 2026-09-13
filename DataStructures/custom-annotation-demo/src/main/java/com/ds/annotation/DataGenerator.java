package com.ds.annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataGenerator {

    public static void main(String[] args) {

        String fileName = "1000.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            // Header
            writer.write("ID|NAME|EMAIL|AGE|CITY|SALARY");
            writer.newLine();

            // Generate 1000 records
            for (int i = 1; i <= 1000; i++) {

                int age = 20 + (i % 40);
                int salary = 30000 + (i * 100);

                String record =
                        i + "|"
                                + "User" + i + "|"
                                + "user" + i + "@example.com|"
                                + age + "|"
                                + "Bangalore|"
                                + salary;

                writer.write(record);
                writer.newLine();
            }

            System.out.println("1000.txt generated successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}