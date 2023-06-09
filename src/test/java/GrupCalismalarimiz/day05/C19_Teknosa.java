package GrupCalismalarimiz.day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C19_Teknosa {
    /*
        // "https://teknosa.com/" adresine gidiniz
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        // "https://medunna.com/" adresine gidiniz
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        // teknosa adresine geri donunuz
        // Sayfayı yenileyiniz
        // medunna adresine ilerleyiniz
        // Sayfayı yenileyiniz
        // pencereyi kapat
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://teknosa.com/");
        //driver.findElement(By.xpath("span[class='ins-web-opt-in-reminder-close-button']")).click();
        driver.findElement(By.linkText("Kabul Et")).click();
        String baslik = driver.getTitle();
        String URL = driver.getCurrentUrl();
        System.out.println("Teknosa'nın Basligi  = " + baslik);
        System.out.println("Teknosa'nın URL  = " + URL);
        Assert.assertTrue(baslik.contains("Teknoloji"));
        Assert.assertTrue(URL.contains("teknoloji"));
        Thread.sleep(3000);
        driver.get("https://medunna.com/");
        String baslikMedunna = driver.getTitle();
        String URLMedunna = driver.getCurrentUrl();
        System.out.println("Medunna'nın Basligi  = " + baslik);
        System.out.println("Medunna'nın URL  = " + URL);
        Assert.assertTrue(baslik.contains("MEDUNNA"));
        Assert.assertTrue(URL.contains("medunna"));

        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

/*
    @After
    public void tearDown() throws Exception {
        driver.close();
    }*/
}
