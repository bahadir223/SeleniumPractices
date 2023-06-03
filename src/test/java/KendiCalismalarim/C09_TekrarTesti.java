package KendiCalismalarim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_TekrarTesti {
    /*
    /*ODEV-->6
    Yeni bir class olusturun (TekrarTesti)
    Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
    Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
    Daha sonra Amazon sayfasina gidin https://www.amazon.com/
    Youtube sayfasina geri donun
    Sayfayi yenileyin
    Amazon sayfasina donun
    Sayfayi tamsayfa yapin
    Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru başlığı(Actual Title) yazdırın.
    Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
    Sayfayi kapatin
     */

    public static void main(String[] args) {
        System.setProperty("chromedriver", "src/Resources/drivers/chromedriver.exe");
        WebDriver myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Youtube web sayfasına gidin
        myDriver.get("https://www.youtube.com");
        //sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify)
        String baslik = myDriver.getTitle();
        if (baslik.equals("youtube")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + baslik);
        }
        //Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
        String currentURL = myDriver.getCurrentUrl();
        if (currentURL.contains("youtube")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + currentURL);
        }
        //Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        myDriver.get("https://www.amazon.com/");
        //    Youtube sayfasina geri donun
        myDriver.navigate().back();
        //Sayfayi yenileyin
        myDriver.navigate().refresh();
        //Amazon sayfasina donun
        myDriver.navigate().forward();
        //Sayfayi tamsayfa yapin
        myDriver.manage().window().fullscreen();
        //Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru başlığı(Actual Title) yazdırın.
        String baslikAmazon = myDriver.getTitle();
        if (baslikAmazon.contains("Amazon")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + baslikAmazon);
        }
        //Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        String amazonUrl = myDriver.getCurrentUrl();
        if (amazonUrl.equals("https://www.amazon.com/")) {
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -->"+ amazonUrl);
        //Sayfayi kapatin
        myDriver.close();
    }
}




