package KendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ActionsClass {
    /*
    Selenium'da Cift Tiklama, Sag tiklama nasil yapilir?
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void test01() throws InterruptedException {
        //radiobutton elementlerini locate edin
    }
}
