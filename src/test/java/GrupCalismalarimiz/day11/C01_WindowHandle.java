package GrupCalismalarimiz.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WindowHandle {
    /*
    Yeni bir class olusturun: WindowHandle
    Amazon anasayfa adresine gidin.
    Sayfa’nin window handle degerini String bir degiskene atayin
    Sayfa title’nin “Amazon” icerdigini test edin
    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    Sayfa title’nin “Walmart” icerdigini test edin
    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        String amazonWindowHandle = driver.getWindowHandle();
        //Sayfa title’nin “Amazon” icerdigini test edin
        String amazonTitle = driver.getTitle();
        String expectedAmazonTitle = "Amazon";
        Assert.assertTrue(amazonTitle.contains(expectedAmazonTitle));
        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        Thread.sleep(3000);
        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin.
        String techproTitle = driver.getTitle();
        String expectedTechproTitle = "TECHPROEDUCATION";
        Assert.assertFalse(techproTitle.contains(expectedTechproTitle));
        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com/");
        Thread.sleep(3000);
        //Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        String expectedURL = "https://www.amazon.com/";
        Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}

