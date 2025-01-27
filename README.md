Kurulum:
Java 11 veya üzeri bir JDK.
Intellij IDEA Community Edition Version : 2020.3.4 ya da üzeri bir versiyon.

Projeyi çalıştırmadan önce gerekli bağımlılıkların yüklenmesi gerekmektedir. Bağımlılıklar:
Selenium 4.26.0---> Web otomasyonu için kullanıldı.
WebDriverManager 5.7.0-->tarayıcı sürücülerini otomatik olarak indirip yapılandırmak için kullanıldı.
Cucumber 7.20.1-->Cucumber, davranış odaklı testler yapmak için kullanıldı. Ayrıyeten Intellij Plugin'lerine Cucumber for Java'nın yüklenmesi gerekmektedir.
TestNG 7.10.2--> Testleri organize etmek ve test sonuçlarını yönetmek için kullanıldı.
Cucumber-TestNG 7.15.0--> XMl dosyası üzerinden testlerin koşulabilmesi için gerekli Cucumber-TestNG entegrasyonu için kullanıldı.
Log4j ve SLF4J--> testleri izlemek,önemli olayları konsola bastırmak ve debuglamak için loglama mekanizmaları sağlanması amacıyla  kullanıldı.
Apache POI-->Apache POI, Excel ve diğer veri işleme dosyalarını yönetmek için kullanıldı.
--Not:Pom.xml dosyası üzerinden gerekli bağımlılıkların kurulduğundan emin olunmalıdır.


Testlerin Çalıştırılması:
1-\Insurance_Test_Case\src\test\java\CreateReportsAndRunTestsWithCucumberOptions klasörünün altındaki Runner klasından testi çalıştırabilirsiniz.

2-TestNg.xml dosyası üzerinden testleri çalıştırabilirsiniz.

3-Feature dosyası içerisinde "Scenario:" kısmının solunda yer alan Run Test seçeneği ile testi çalıştırabilirsiniz.

Test Raporlarının Görüntülenmesi:

Test bittiğinde target klasöründeki cucumber-reports.html dosyasına giderek oradaki Chrome simgesine basılarak test koşum raporunu(html),step detaylarını  gözlemleyebilirsiniz.
