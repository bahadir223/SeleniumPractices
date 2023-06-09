package GrupCalismalarimiz.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Utils {
    public static WebDriver myDriver ;

    public static void setProperty() {
        System.setProperty("chromedriver", "src/Resources/drivers/chromedriver.exe");
        myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

}
