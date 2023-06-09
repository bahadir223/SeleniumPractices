package GrupCalismalarimiz.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C12_heroku_com {
    /*
    //https://id.heroku.com/login sayfasina gidin
//Bir mail adersi giriniz
//Bir password giriniz
//Login butonuna tiklayiniz
//"There was a problem with your login." texti gorunur ise
//"kayit yapilamadi" yazdiriniz
//eger yazi gorunur degilse "kayit yapildi" yazdiriniz
//sayfayı kapatiniz
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");

        //Bir mail adersi giriniz
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("ali.123@gmail.com", Keys.TAB);
        Thread.sleep(3000);

        //Bir password giriniz
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12345", Keys.TAB);
        Thread.sleep(3000);

        //Login butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(3000);

        //"There was a problem with your login." texti gorunur ise
        //"kayit yapilamadi" yazdiriniz
        //eger yazi gorunur degilse "kayit yapildi" yazdiriniz.
        if (driver.findElement(By.xpath("//*[text() = 'There was a problem with your login.']")).isDisplayed()) {
            System.out.println("kayit yapilamadi");
        } else {
            System.out.println("kayit yapildi");
        }
        driver.close();


    }
}
