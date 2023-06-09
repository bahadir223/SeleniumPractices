package GrupCalismalarimiz.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01 {

     /*
    -Amazon sayfasına gidelim
    -Arama Kutusundaki Dropdown menuyu yazdıralım
    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
            başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
            Not: Select Class'ı kullanalım

     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    WebElement ddm;
    Select select;

    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");
        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        select = new Select(ddm);
        List<WebElement> secenekler = select.getOptions();
        secenekler.forEach(w -> System.out.println(w.getText()));
        // -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //  başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        for (int i = 1; i < 6; i++) {
            ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
            select = new Select(ddm);
            select.selectByIndex(i);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
            System.out.println(driver.getTitle());
            bekle(3);
            driver.navigate().back();

        }


    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com/");
        ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        select = new Select(ddm);
        List<WebElement> secenekler = select.getOptions();
        for (int i = 0; i < secenekler.size(); i++) {
            ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
            select = new Select(ddm);
            select.selectByIndex(i);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
            driver.navigate().back();

        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
