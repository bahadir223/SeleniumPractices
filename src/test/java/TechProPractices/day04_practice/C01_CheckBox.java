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

public class C01_CheckBox {
    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edin


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
        //checkbox elementlerini locate edin
        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        WebElement checkbox3 = driver.findElement(By.xpath("(//*[@type='checkbox'])[3]"));
        //checkbox1 ve checkbox3  secili degil ise secin
        if (!checkbox1.isSelected() && !checkbox3.isSelected()) {
            checkbox1.click();
            Thread.sleep(3000);
            checkbox3.click();
            Thread.sleep(3000);
        }

        //checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkbox1.isSelected() && checkbox3.isSelected());
        //checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkbox2.isSelected());


    }
}
