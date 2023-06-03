package TechProPractices.day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromedriver", "src/Resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // pencereyi kapatiniz

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // arama motorunda nutella yazip aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);

        // Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edin
        List<WebElement> butonlar = driver.findElements(By.xpath("(//*[@class='nav-a  '])[position()>=2 and position()<=3]"));
/*
        for (WebElement w : butonlar) {
            butonlar = driver.findElements(By.xpath("(//*[@class='nav-a  '])[position()>=2 and position()<=3]"));
            w.click();
            Thread.sleep(3000);
            driver.navigate().back();

        }*/
        for (int i = 0; i <butonlar.size() ; i++) {
            butonlar = driver.findElements(By.xpath("(//*[@class='nav-a  '])[position()>=2 and position()<=3]"));
            butonlar.get(i).click();
            Thread.sleep(3000);
            driver.navigate().back();
        }

        driver.close();

    }
}
