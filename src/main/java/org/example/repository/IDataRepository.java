package org.example.repository;

import java.util.List;

public interface IDataRepository {
    void saveData(String filename, List<String> lines);
    List<String> loadData(String filename);
}