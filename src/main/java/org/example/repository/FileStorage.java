package org.example.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage implements IDataRepository {

    @Override
    public void saveData(String filename, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Dosya kaydetme hatası: " + e.getMessage());
        }
    }

    @Override
    public List<String> loadData(String filename) {
        List<String> lines = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return lines;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
        return lines;
    }
}