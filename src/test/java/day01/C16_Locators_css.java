package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C16_Locators_css {
    /*
    Home Work: Log in Test Using Css
    1.) Bir class oluşturun : Locators_css
    2.) Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a.  Verilen web sayfasına gidin. https://www.heroku.com/home Log in
    b.  Locate email textbox
    c.  Locate password textbox ve
    d.  Locate signin button
    . Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
    . Username : testtechproed@gmail.com
    i.Password : Test1234!
    NOT: cssSelector kullanarak elementleri locate ediniz (
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //http://a.testaddressbook.com/
        driver.get("https://www.heroku.com/home");

        /*
        a.  Log in
        b.  Locate email textbox
        c.  Locate password textbox ve
        d.  Locate signin button*/
        driver.findElement(By.cssSelector("a[href='https://id.heroku.com']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("testtechproed@gmail.com",
                Keys.TAB, "Test1234!", Keys.TAB, Keys.ENTER);

        Thread.sleep(3000);
        driver.close();


    }
}
