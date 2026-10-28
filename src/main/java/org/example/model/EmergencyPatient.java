package org.example.model;

public class EmergencyPatient extends Patient {

    public EmergencyPatient(String id, String name, String surname, int triageScore) {
        super(id, name, surname, triageScore);
    }

    @Override
    public int calculatePriority() {
        return 50 + (getTriageScore() * 5);
    }

    @Override
    public String toString() {
        return "[ACİL HASTA] " + getFullName() + " | Öncelik Puanı: " + calculatePriority();
    }
}