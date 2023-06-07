package TechProPractices.day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    // https://www.bestbuy.com/ sayfasına gidin
    // sayfa Title'ini alın "Best" içerdigini test edin
    // BestBuy logosunun görüntülendigini test edin
    // Canada logosunun görüntülendigini test edin

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
        // https://www.bestbuy.com/ sayfasına gidin
        driver.get("https://www.bestbuy.com/");
        //Sayfa Title'ini alın "Best" içerdigini test edin
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Best"));
        // BestBuy logosunun görüntülendigini test edin
        WebElement logoBestBuy = driver.findElement(By.xpath("(//div/img)[1]"));
        Assert.assertTrue(logoBestBuy.isDisplayed());
        // Canada logosunun görüntülendigini test edin
        WebElement logoCanada = driver.findElement(By.xpath("(//img)[2]"));
        Assert.assertTrue(logoCanada.isDisplayed());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
