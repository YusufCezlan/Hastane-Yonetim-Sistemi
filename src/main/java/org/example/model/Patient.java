package org.example.model;

public abstract class Patient extends Person {
    private int triageScore;

    public Patient(String id, String name, String surname, int triageScore) {
        super(id, name, surname);
        this.triageScore = triageScore;
    }

    public int getTriageScore() { return triageScore; }
    public void setTriageScore(int triageScore) { this.triageScore = triageScore; }

    public abstract int calculatePriority();
}