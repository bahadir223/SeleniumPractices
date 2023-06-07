package TechProPractices.day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {
    // https://www.amazon.com/ adresine gidin
    // arama motorunda nutella yazip aratınız
    // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın

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
        // https://www.amazon.com/ adresine gidin, arama motorunda nutella yazip aratınız
        driver.get("https://www.amazon.com/ ");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);
        //sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın
        List<WebElement> urunler = driver.findElements(By.xpath("//h2//span"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler = driver.findElements(By.xpath("//h2//span"));
            urunler.get(i).click();
            System.out.println(driver.getTitle());
            Thread.sleep(3000);
            driver.navigate().back();

        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

}
