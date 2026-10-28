# Hastane Planlama Sistemi

Bu proje, Nesneye Yönelik Programlama (OOP) ilkeleri, Tasarım Kalıpları (Design Patterns) ve SOLID prensiplerine uygun olarak Java dili ile geliştirilmiş bir konsol uygulamasıdır. Sistem; acil ve standart hastaların triyaj puanlarına göre önceliklendirilmesini, uygun doktorlara atanarak çizelgelenmesini ve verilerin dosya sisteminde kalıcı olarak saklanmasını sağlar.

---

## 🛠️ Teknolojiler ve Araçlar
- Dil: Java (JDK 17+)
- Derleme / Bağımlılık Yönetimi: Maven
- Test Çerçevesi: JUnit 5
- Geliştirme Ortamı: IntelliJ IDEA

---

## 🏗️ Proje Mimarisi ve Paket Yapısı
```
src/main/java/org/example/
├── model/
│   ├── Person.java            (Abstract Base Class)
│   ├── Doctor.java            (Person'dan türetilmiş sınıf)
│   ├── Patient.java           (Abstract Class - Person'dan türetilmiş)
│   ├── EmergencyPatient.java  (Patient'tan türetilmiş acil hasta)
│   └── StandardPatient.java   (Patient'tan türetilmiş standart hasta)
├── factory/
│   └── PatientFactory.java    (Factory Pattern - Hasta nesnesi üretimi)
├── repository/
│   ├── IDataRepository.java   (Interface - DIP prensibi)
│   └── FileStorage.java       (SRP prensibi - Dosya kayıt işlemleri)
├── service/
│   └── HospitalManager.java   (Singleton Pattern - İş mantığı yönetimi)
└── Main.java                  (Konsol Arayüzü ve Giriş Noktası)

src/test/java/org/example/
└── HospitalManagerTest.java   (Birim Testleri)
```
---

## 📐 OOP, SOLID ve Tasarım Kalıpları Uygulamaları

### Tasarım Kalıpları (Design Patterns)
- Singleton Pattern: HospitalManager sınıfı tüm sistemde tek bir nesne örneği (instance) üzerinden çalışarak veri tutarlılığını garanti eder.
- Factory Method Pattern: PatientFactory sınıfı, girilen tipe göre (1/EMERGENCY veya 2/STANDARD) ilgili hasta nesnesini dinamik olarak üretir.

### SOLID Prensipleri
- Single Responsibility Principle (SRP): Dosya kayıt/okuma işlemleri FileStorage sınıfında; iş mantığı ise HospitalManager sınıfında yürütülür.
- Open/Closed Principle (OCP): Yeni bir hasta tipi eklemek gerektiğinde mevcut kodlar değiştirilmeden Patient sınıfı genişletilebilir.
- Liskov Substitution Principle (LSP): EmergencyPatient ve StandardPatient nesneleri, üst sınıfları olan Patient referansı ile sorunsuz bir şekilde yönetilebilir.
- Dependency Inversion Principle (DIP): HospitalManager, somut dosya sınıfı yerine IDataRepository arayüzüne (interface) bağımlıdır.

### OOP İlkeleri
- Kalıtım (Inheritance): Doctor ve Patient sınıfları Person sınıfından; EmergencyPatient ve StandardPatient sınıfları ise Patient sınıfından türetilmiştir.
- Çok Biçimlilik (Polymorphism): calculatePriority() metodu acil ve standart hastalar için farklı öncelik hesaplama mantıkları çalıştırır.
- Soyutlama (Abstraction): Person ve Patient sınıfları abstract olarak tanımlanarak doğrudan nesne oluşturulması engellenmiştir.
- Kapsülleme (Encapsulation): Tüm alanlar private erişim belirteci ile korunmuş, veri erişimi getter/setter metodları ile sınırlandırılmıştır.

---

## 🚀 Kurulum ve Çalıştırma

1. Projeyi Klonlayın: git clone <github-repo-url>
2. IDE'de Açın: Projeyi IntelliJ IDEA üzerinde Maven projesi olarak açın.
3. Uygulamayı Çalıştırın: src/main/java/org/example/Main.java dosyasını çalıştırarak konsol arayüzünü başlatın.
4. Testleri Çalıştırın: src/test/java/org/example/HospitalManagerTest.java dosyasını çalıştırarak 8 birim testinin tamamının geçtiğini doğrulayın.

---

## 💻 Kullanım Seçenekleri

1. Hasta Ekle: 1 (Acil) veya 2 (Standart) seçimi ile sisteme hasta kaydedin.
2. Bekleyen Hastaları Listele: Öncelik puanına göre sıralanmış hasta kuyruğunu görüntüleyin.
3. Doktorları Listele: Sistemdeki doktor listesini inceleyin.
4. Sıradaki Hastayı Çizelgele: Sıradaki hastayı uygun doktora atayın.
5. Verileri Kaydet ve Çık: Tüm kayıtları hastane_verileri.txt dosyasına yazarak programdan çıkın.

---

## 👨‍💻 Geliştirici Bilgileri

- Öğrenci Numarası: 1250505031
- Ad Soyad: Zekeriya Yusuf Cezlan
- Ders: Nesneye Yönelik Programlama (OOP)
