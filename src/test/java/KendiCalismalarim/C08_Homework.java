package KendiCalismalarim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Homework {
    /*
    /*ODEV-->5
    Yeni bir class olusturalim (Homework)
    ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
    oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
    Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
    yazdirin.
    https://www.walmart.com/ sayfasina gidin.
    Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
    Tekrar “facebook” sayfasina donun
    Sayfayi yenileyin
    Sayfayi tam sayfa (maximize) yapin  9.Browser’i kapatin
     */
    public static void main(String[] args) {

        System.setProperty("chromedriver", "src/Resources/drivers/chromedriver.exe");
        WebDriver myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //facebook sayfasina gidin
        myDriver.get("https://www.facebook.com");

        // sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        String baslik = myDriver.getTitle();
        if (baslik.equals("facebook")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED" + baslik);
        }

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String URL = myDriver.getCurrentUrl();
        if (URL.contains("facebook")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED" + URL);
        }
        //https://www.walmart.com/ sayfasina gidin.
        myDriver.get("https://www.walmart.com/");

        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String baslik2 = myDriver.getTitle();
        if (baslik2.contains("Walmart.com")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED" + baslik2);
        }
        //Tekrar “facebook” sayfasina donun
        myDriver.navigate().back();
        //Sayfayi yenileyin
        myDriver.navigate().refresh();
        //Sayfayi tam sayfa (maximize) yapin
        myDriver.manage().window().maximize();
        //Browser’i kapatin
        myDriver.close();
    }

}
