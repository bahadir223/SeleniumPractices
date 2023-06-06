package GrupCalismalarimiz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C26 {
    /*
    /*
    *** Aşağıdaki Task'i Junit framework'u ile yapınız
    - Before methodu ile drive'i olusturup ayarlamalari yapiniz
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
    - After methodu ile sayfayı kapatalım
    */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testEbay() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("(//*[@class='hl-cat-nav__js-tab'])[1]")).click();
        List<WebElement> img = driver.findElements(By.xpath("//*[contains(@width,'225')]" +
                "|//*[contains(@height,'225')]"));

        for (int i = 0; i < img.size(); i++) {
            img = driver.findElements(By.xpath("//*[contains(@width,'225')]" +
                    "|//*[contains(@height,'225')]"));
            img.get(i).click();
            Thread.sleep(3000);
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }

    }
}
