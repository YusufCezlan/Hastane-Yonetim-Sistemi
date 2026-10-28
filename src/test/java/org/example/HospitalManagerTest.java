package org.example;

import org.example.factory.PatientFactory;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.service.HospitalManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalManagerTest {

    private HospitalManager hospitalManager;

    @BeforeEach
    void setUp() {
        hospitalManager = new HospitalManager();
    }

    @Test
    void testAddDoctor() {
        Doctor doctor = new Doctor("D1", "Ahmet", "Yılmaz", "Dahiliye");
        hospitalManager.addDoctor(doctor);
        assertEquals(1, hospitalManager.getDoctors().size());
    }

    @Test
    void testAddPatient() {
        Patient patient = PatientFactory.createPatient("ACIL", "P1", "Ali", "Kaya", 80);
        hospitalManager.addPatient(patient);
        assertEquals(1, hospitalManager.getPatients().size());
    }

    @Test
    void testEmergencyPatientPriority() {
        Patient standard = PatientFactory.createPatient("STANDART", "P1", "Ayşe", "Demir", 0);
        Patient emergency = PatientFactory.createPatient("ACIL", "P2", "Mehmet", "Şahin", 90);

        hospitalManager.addPatient(standard);
        hospitalManager.addPatient(emergency);

        // Acil hasta yüksek triyaj puanı nedeniyle listede ilk sırada olmalı
        assertEquals("Mehmet", hospitalManager.getPatients().get(0).getName());
    }

    @Test
    void testScheduleNextPatient() {
        Doctor doctor = new Doctor("D1", "Can", "Öztürk", "Cerrahi");
        Patient patient = PatientFactory.createPatient("ACIL", "P1", "Fatma", "Aydın", 50);

        hospitalManager.addDoctor(doctor);
        hospitalManager.addPatient(patient);

        String result = hospitalManager.scheduleNextPatient();
        assertTrue(result.contains("ATAMA BAŞARILI"));
        assertFalse(doctor.isAvailable());
    }
}