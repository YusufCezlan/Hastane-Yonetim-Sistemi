package org.example.model;

public class StandardPatient extends Patient {

    public StandardPatient(String id, String name, String surname, int triageScore) {
        super(id, name, surname, triageScore);
    }

    @Override
    public int calculatePriority() {
        return getTriageScore();
    }

    @Override
    public String toString() {
        return "[STANDART HASTA] " + getFullName() + " | Öncelik Puanı: " + calculatePriority();
    }
}