package GrupCalismalarimiz.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C23 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //"https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //Username kutusuna "standard_user" yazdirin
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        //Password kutusuna "secret_sauce" yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        //Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        System.out.println(ilkUrun.getText());

        ilkUrun.click();

        //Add to Cart butonuna basin
        WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();

        //Alisveris sepetine tiklayin
        WebElement alisverisSepeti = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        alisverisSepeti.click();

        //Sectiginiz urunun basarili olarak sepete eklendigini control  edin

        WebElement sepettekiUrun = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));

        String actualUrun = sepettekiUrun.getText();


        String expectedUrun = "";


        if (actualUrun.contains(expectedUrun)) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Fail");
        }
        //Sayfayi kapatin
        driver.close();
    }

}
