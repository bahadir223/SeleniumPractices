package TechProPractices.day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class C01_DropDown {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Books" secenegini secin
        WebElement menu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(menu);
        select.selectByIndex(5);
        // arama cubuguna "Java" aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        // arama sonuclarinin Java icerdigini test edin
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String sonucYazisi = sonuc.getText();
        String[] arr = sonucYazisi.split(" ");
        Assert.assertTrue(arr[6].contains("Java"));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
