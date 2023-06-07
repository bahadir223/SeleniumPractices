package TechProPractices.day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    // https://www.techproeducation.com/ sayfasina gidin
    // Title ve Url'ini alın ve yazdırın
    // Title'in "Techpro" kelimesini içerip içermedigini test edin
    // Url'in "techproeducation" kelimesini içerip içermedigini test edin
    // https://www.amazon.com/ sayfasına gidin
    // Title'ini alın ve yazdırın
    // Title'in "more" kelimesini içerip içermedigini test edin
    // techproeducation.com'a geri dönün
    // sayfayı yenileyin
    // amazon.com'a tekrar gelin

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
        // https://www.techproeducation.com/ sayfasina gidin, Title ve Url'ini alın ve yazdırın
        driver.get("https://www.techproeducation.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//reklamı kapattık
        String actualTitleTechPro = driver.getTitle();
        String actualURL = driver.getCurrentUrl();
        System.out.println("TechPro Baslik = " + actualTitleTechPro);
        System.out.println("TechPro URL = " + actualURL);
        // Title'in "Techpro" kelimesini içerip içermedigini test edin
        Assert.assertTrue(actualTitleTechPro.contains("Techpro"));
        // Url'in "techproeducation" kelimesini içerip içermedigini test edin
        Assert.assertTrue(actualURL.contains("techproeducation"));
        //https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com/");
        //Title'ini alın ve yazdırın, Title'in "more" kelimesini içerip içermedigini test edin
        String actualTitleAmazon=driver.getTitle();
        System.out.println("Amazon Baslik = " + actualTitleAmazon);
        Assert.assertTrue(actualTitleAmazon.contains("more"));
        Thread.sleep(3000);
        // techproeducation.com'a geri dönün,sayfayı yenileyin,amazon.com'a tekrar gelin
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.navigate().forward();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
