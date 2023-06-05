package KendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C22 {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Products' button
    5. Hover over first product and click 'Add to cart'
    6. Click 'Continue Shopping' button
    7. Hover over second product and click 'Add to cart'
    8. Click 'View Cart' button
    9. Verify both products are added to Cart
    10. Verify their prices, quantity and total price
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //Verify that home page is visible successfully
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://automationexercise.com/";

        if(actualURL.equals(expectedURL)){
            System.out.println("Test PASS");
        }else{
            System.out.println("Test FAILED " +actualURL );
        }

        //Click 'Products' button
        driver.findElement(By.cssSelector("a[href='/products']")).click();

        //Hover over first product and click 'Add to cart'
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]")).click();

        //Click 'Continue Shopping' button
        driver.findElement(By.linkText("Continue Shopping")).click();
/*
        WebElement reklam = driver.findElement(By.id("//*[@id='dismiss-button']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='none';", reklam);*/




    }
}
