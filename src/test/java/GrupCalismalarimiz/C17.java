package GrupCalismalarimiz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class C17 {
    /*
        Class Work: Relative Locators
    1.) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
    2.) Berlin’i 3 farkli relative locator ile locate edin
    3 ) Relative locator’larin dogru calistigini test edin
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //Berlin’i 3 farkli relative locator ile locate edin
        WebElement NYC = driver.findElement(By.id("pid3_thumb"));
        WebElement BayArea = driver.findElement(By.id("pid8_thumb"));
        WebElement Sailor = driver.findElement(By.id("pid11_thumb"));

        WebElement berlin = driver.findElement(with(By.tagName("img")).above(NYC));
        System.out.println("BERLIN = " + berlin.getText());

        /*
        WebElement berlin2 = driver.findElement(with(By.tagName("img")).toLeftOf(BayArea));
        System.out.println("BERLIN = " + berlin2.getText());
        WebElement berlin3 = driver.findElement(with(By.tagName("img")).above(Sailor));
        System.out.println("BERLIN = " + berlin3.getText());*/
    }
}
