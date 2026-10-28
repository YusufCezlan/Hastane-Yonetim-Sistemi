package org.example.model;

public class Doctor extends Person {
    private String specialty;
    private boolean isAvailable;

    public Doctor(String id, String name, String surname, String specialty) {
        super(id, name, surname);
        this.specialty = specialty;
        this.isAvailable = true;
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        return "Dr. " + getFullName() + " [" + specialty + "] - Durum: " + (isAvailable ? "Müsait" : "Meşgul");
    }
}