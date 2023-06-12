package KendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C01_ActionsClass {
    /*
    Selenium'da Cift Tiklama, Sag tiklama nasil yapilir? Örnek ile inceleyelim.
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
    public void test01() {
        bekle(2);
        //açılan sitedeki Double Click Me button'una tıklayınız.
        WebElement doubleClickMeButton = driver.findElement(By.id("doubleClickBtn"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickMeButton).perform();
        //You have done a double click yazısının göründüğünü doğrulayınız.
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(doubleClickMessage.isDisplayed());
        bekle(2);
        //Right Click Me button'una tıklayınız.
        WebElement rightClickMeButton = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClickMeButton).perform();
        //You have done a right click yazısının göründüğünü doğrulayınız.
        WebElement rightClickMessage = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(rightClickMessage.isDisplayed());


    }


    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
