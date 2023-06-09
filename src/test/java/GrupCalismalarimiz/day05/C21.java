package GrupCalismalarimiz.day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C21 {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Delete Account' button
    10. Verify that 'ACCOUNT DELETED!' is visible
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://automationexercise.com/";
        if (actualURL.equals(expectedURL)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + actualURL);
        }

        //Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //Verify 'Login to your account' is visible
        boolean b1 = driver.findElement(By.xpath("(//h2)[1]")).isDisplayed();
        System.out.println(b1);

        //Enter correct email address and password

        driver.findElement(By.cssSelector("input[data-qa='login-email']")).
                sendKeys("ali1@gmail.com", Keys.TAB, "12345", Keys.TAB, Keys.ENTER);

        //Verify that 'Logged in as username' is visible
        System.out.println(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        //Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();

        //Verify that 'ACCOUNT DELETED!' is visible
        System.out.println(driver.findElement(By.cssSelector("h2[class='title text-center']")).isDisplayed());

        driver.close();


    }
}
