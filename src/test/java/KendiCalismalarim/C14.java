package KendiCalismalarim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C14 {
     /*
          https://www.amazon.com/ adresine gidin
          Browseri tam sayfa yapin
          Sayfayi “refresh” yapin
          Sayfa basliginin “Spend less” ifadesi icerdigini test edin
          Gift Cards sekmesine basin
          Birthday butonuna basin
          Best Seller bolumunden ilk urunu tiklayin
          Gift card details’den 25 $’i secin
          Urun ucretinin 25$ oldugunu test edin
          Sayfayi kapatin
         */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //https://www.amazon.com/ adresine gidin
        //Browseri tam sayfa yapin
        driver.get("https://www.amazon.com/ ");

        Thread.sleep(2000);
        //Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String sayfaBasligi = driver.getTitle();
        if (sayfaBasligi.contains("Spend less")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + sayfaBasligi);
        }

        //Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();
        Thread.sleep(2000);

        //Birthday butonuna basin
        driver.findElement(By.xpath("(//*[text()='Birthday'])[1]")).click();
        Thread.sleep(2000);

        //Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[text()='Amazon.com eGift Card'])[1]")).click();
        Thread.sleep(2000);

        //Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//*[@id='gc-mini-picker-amount-1'])[1]")).click();
        Thread.sleep(2000);

        //Urun ucretinin 25$ oldugunu test edin
        WebElement ucret = driver.findElement(By.xpath("(//*[text()='$25.00'])[2]"));
        if (ucret.getText().equals("$25.00")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + ucret);
        }
        driver.close();
    }
}
