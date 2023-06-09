package TechProPractices.day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    Select select;

    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/ ");
        //dropdown'dan "Baby" secenegini secin
        WebElement menu = driver.findElement(By.cssSelector("select[name='url']"));
        select = new Select(menu);
        select.selectByIndex(3);
        //sectiginiz option'i yazdirin
        System.out.println(select.getFirstSelectedOption().getText());
        //dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> secenekler = select.getOptions();
        Assert.assertEquals(28, secenekler.size());
        //dropdown'daki optionların tamamını yazdırın
        for (int i = 0; i < secenekler.size(); i++) {
            System.out.println(secenekler.get(i).getText());

        }
    }
}
