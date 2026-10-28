package org.example;

import org.example.factory.PatientFactory;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.service.HospitalManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalManager manager = HospitalManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        manager.addDoctor(new Doctor("D1", "Ahmet", "Yılmaz", "Genel Cerrahi"));
        manager.addDoctor(new Doctor("D2", "Ayşe", "Kaya", "Acil Tıp"));

        while (true) {
            System.out.println("\n--- HASTANE PLANLAMA SİSTEMİ ---");
            System.out.println("1. Hasta Ekle (Acil / Standart)");
            System.out.println("2. Bekleyen Hastaları Listele (Öncelik Sıralı)");
            System.out.println("3. Doktorları Listele");
            System.out.println("4. Sıradaki Hastayı Doktora Atayarak Çizelgele");
            System.out.println("5. Verileri Kaydet ve Çık");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Hasta Tipi (EMERGENCY / STANDARD): ");
                String type = scanner.nextLine().toUpperCase();
                System.out.print("TC / ID: ");
                String id = scanner.nextLine();
                System.out.print("Ad: ");
                String name = scanner.nextLine();
                System.out.print("Soyad: ");
                String surname = scanner.nextLine();
                System.out.print("Triyaj / Aciliyet Puanı (1-10): ");
                int score = scanner.nextInt();

                Patient patient = PatientFactory.createPatient(type, id, name, surname, score);
                manager.addPatient(patient);
                System.out.println("Hasta başarıyla kuyruğa eklendi.");

            } else if (choice == 2) {
                System.out.println("\n--- BEKLEYEN HASTA LİSTESİ ---");
                for (Patient p : manager.getPatients()) {
                    System.out.println(p);
                }
            } else if (choice == 3) {
                System.out.println("\n--- DOKTOR LİSTESİ ---");
                for (Doctor d : manager.getDoctors()) {
                    System.out.println(d);
                }
            } else if (choice == 4) {
                String result = manager.scheduleNextPatient();
                System.out.println(result);
            } else if (choice == 5) {
                manager.persistAllData();
                System.out.println("Veriler 'hastane_verileri.txt' dosyasına yazıldı. Çıkılıyor...");
                break;
            }
        }
        scanner.close();
    }
}