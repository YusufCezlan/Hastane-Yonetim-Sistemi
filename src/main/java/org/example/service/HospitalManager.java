package org.example.service;

import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.repository.FileStorage;
import org.example.repository.IDataRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HospitalManager {
    private static HospitalManager instance;

    private List<Doctor> doctors;
    private List<Patient> patients;
    private IDataRepository repository;

    private HospitalManager() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        this.repository = new FileStorage();
    }

    public static synchronized HospitalManager getInstance() {
        if (instance == null) {
            instance = new HospitalManager();
        }
        return instance;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        patients.sort(Comparator.comparingInt(Patient::calculatePriority).reversed());
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public String scheduleNextPatient() {
        if (patients.isEmpty()) return "Bekleyen hasta bulunmamaktadır.";

        Doctor availableDoctor = doctors.stream()
                .filter(Doctor::isAvailable)
                .findFirst()
                .orElse(null);

        if (availableDoctor == null) {
            return "Şu anda uygun doktor bulunmamaktadır!";
        }

        Patient nextPatient = patients.remove(0);
        availableDoctor.setAvailable(false);

        return "ATAMA BAŞARILI: " + nextPatient.getFullName() +
                " -> " + availableDoctor.getFullName() + " (" + availableDoctor.getSpecialty() + ")";
    }

    public void persistAllData() {
        List<String> data = new ArrayList<>();
        for (Patient p : patients) {
            data.add("PATIENT;" + p.getClass().getSimpleName() + ";" + p.getId() + ";" + p.getName() + ";" + p.getSurname() + ";" + p.getTriageScore());
        }
        repository.saveData("hastane_verileri.txt", data);
    }
}