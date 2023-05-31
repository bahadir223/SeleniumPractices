package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AmazonUrunler {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");

        //iphone aratiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //cikan sonuc yazisini konsola yazdiriniz.
        List<WebElement> sonucYazisiList = driver.findElements(By.className("sg-col-inner"));
        String yazi = sonucYazisiList.get(0).getText();

        //cikan urunlerden ilk 5 tanesine tiklayip basliklarini yazdiriniz.
    }
}
