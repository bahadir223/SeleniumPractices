package TechProPractices.day04_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButton {
    // https://demo.guru99.com/test/radio.html adresine gidin
    // radiobutton elementlerini locate edin
    // option2'yi secin
    // option2 elementlerinin secili oldugunu Test edin
    // option1 elementlerinin secili olmadıgını test edin
    // option3 elementlerinin secili olmadıgını test edin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.guru99.com/test/radio.html");
    }

    @Test
    public void test01() throws InterruptedException {
        //radiobutton elementlerini locate edin
        WebElement radioButton1 = driver.findElement(By.xpath("(//input)[1]"));
        WebElement radioButton2 = driver.findElement(By.xpath("(//input)[2]"));
        WebElement radioButton3 = driver.findElement(By.xpath("(//input)[3]"));
        Thread.sleep(3000);
        //option2'yi secin
        radioButton2.click();
        // option2 elementlerinin secili oldugunu Test edin
        // option1 elementlerinin secili olmadıgını test edin
        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertTrue(radioButton2.isSelected());
        Assert.assertFalse(radioButton1.isSelected());
        Assert.assertFalse(radioButton3.isSelected());
    }
}
