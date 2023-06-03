package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YouTubePosition {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //https://www.youtube.com/ ' gidin
        driver.get("https://www.youtube.com/");

        List<WebElement> linkler = driver.findElements
                (By.xpath("(//*[@class='style-scope yt-chip-cloud-chip-renderer'])" +
                        "[position()>=1 and position()<=10]"));

        for (WebElement w : linkler) {
            linkler = driver.findElements
                    (By.xpath("(//*[@class='style-scope yt-chip-cloud-chip-renderer'])" +
                            "[position()>=1 and position()<=10]"));
            System.out.println(w.getText());
            w.click();
            Thread.sleep(3000);

        }
    }
}
