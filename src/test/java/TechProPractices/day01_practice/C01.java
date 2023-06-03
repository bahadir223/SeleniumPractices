package TechProPractices.day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromedriver", "src/Resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // ilk kutucuga 20 giriniz
        // ikinci kutucuga 30 giriniz
        // calculate'e tıklayınız
        // sonucu yazdırınız
        // sayfayi kapatiniz

        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        driver.findElement(By.id("number1")).sendKeys("20", Keys.TAB, Keys.TAB, "30", Keys.TAB, Keys.ENTER);
        Thread.sleep(3000);
        System.out.println("Sonuc : " + driver.findElement(By.xpath("//span")).getText());
        driver.close();
    }
}
