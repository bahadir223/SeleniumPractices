package GrupCalismalarimiz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_GetMethods {
    /*
    Yeni bir package olusturalim : day01
    Yeni bir class olusturalim : C03_GetMethods
    Amazon sayfasina gidelim. https://www.amazon.com/
    Sayfa basligini(title) yazdirin
    Sayfa basliginin “Amazon” icerdigini test edin
    Sayfa adresini(url) yazdirin
    Sayfa url’inin “amazon” icerdigini test edin.
    Sayfa handle degerini yazdirin
    Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
    Sayfayi kapatin.
*/
    public static void main(String[] args) {
        //Amazon sayfasina gidelim. https://www.amazon.com/
        System.setProperty("chromedriver", "src/Resources/drivers/chromedriver.exe");
        WebDriver myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        myDriver.get("https://www.amazon.com/");

        //Sayfa basligini(title) yazdirin
        System.out.println("Amazon Sayfa Basligi : " + myDriver.getTitle());

        //Sayfa basliginin “Amazon” icerdigini test edin
        String baslik = myDriver.getTitle();
        String arananKelime = "Amazon";
        if (baslik.contains(arananKelime)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED" + baslik);
        }

        //Sayfa adresini(url) yazdirin
        System.out.println("Amazon URL: " + myDriver.getCurrentUrl());

        //Sayfa url’inin “amazon” icerdigini test edin.
        String url = myDriver.getCurrentUrl();
        String arananURL = "amazon";
        if (url.contains(arananURL)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED" + url);
        }

        //Sayfa handle degerini yazdirin.
        System.out.println("Sayfa Handle Degeri : " + myDriver.getWindowHandle());

        //Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin.
        if (myDriver.getPageSource().contains("Gateway")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        myDriver.close();


    }
}
