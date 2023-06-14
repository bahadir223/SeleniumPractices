package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {
    /*
    TestBase class'indan object olusturmanin önüne gecmek icin bu class'i abstract yapabiliriz.
    TestBase testBase = new TestBase(); yani bu şekilde object olusturmanin onune gecmis oluruz.
    Bu class'a extends yaptigimiz test class'larindan ulasabiliriz.
     */
    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    //HARD WAIT (Bekleme Methodu)
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //acceptAlert methodu
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //dismissAlert methodu
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //gettextAlert methodu
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    //sendKeysAlert methodu
    public void sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown Value
    public void selectValue(WebElement ddm, String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    //DropDown Value'nin index'li hali. Kendim oluşturdum.
    public void selectValue2(WebElement ddm, int idx) {
        Select select = new Select(ddm);
        select.selectByIndex(idx);
    }
}
