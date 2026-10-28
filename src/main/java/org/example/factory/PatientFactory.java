package org.example.factory;

import org.example.model.EmergencyPatient;
import org.example.model.Patient;
import org.example.model.StandardPatient;

public class PatientFactory {
    public static Patient createPatient(String type, String id, String name, String surname, int triageScore) {
        if (type == null) {
            throw new IllegalArgumentException("Hasta türü boş olamaz!");
        }

        String normalizedType = type.trim().toUpperCase();

        // 1, ACİL veya EMERGENCY yazılırsa Acil Hasta oluşturur
        if ("1".equals(normalizedType) || "EMERGENCY".equals(normalizedType) || "ACIL".equals(normalizedType) || "ACİL".equals(normalizedType)) {
            return new EmergencyPatient(id, name, surname, triageScore);
        }
        // 2, STANDART veya STANDARD yazılırsa Standart Hasta oluşturur
        else if ("2".equals(normalizedType) || "STANDARD".equals(normalizedType) || "STANDART".equals(normalizedType)) {
            return new StandardPatient(id, name, surname, triageScore);
        }

        throw new IllegalArgumentException("Geçersiz hasta türü: " + type);
    }
}