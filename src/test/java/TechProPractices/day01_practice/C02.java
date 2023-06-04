package TechProPractices.day01_practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromedriver", "src/Resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // arama motorunda nutella yazip aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);

        //Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edin.
        try{
            List<WebElement> linkler = driver.findElements(By.xpath("(//*[@class='nav-a  '])" +
                    "[position()>=2 and position()<=3]"));
        }catch (StaleElementReferenceException e){
            List<WebElement> linkler = driver.findElements(By.xpath("(//*[@class='nav-a  '])" +
                    "[position()>=2 and position()<=3]"));
            for (WebElement w : linkler) {

                linkler = driver.findElements(By.xpath("(//*[@class='nav-a  '])" +
                        "[position()>=2 and position()<=3]"));
                w.click();
                if (driver.getTitle().contains("Amazon")) {
                    System.out.println("Test PASSED");
                } else {
                    System.out.println("Test FAILED");
                }
                Thread.sleep(3000);
                driver.navigate().back();
        }


        //   FORİ İLE position()>= kullanarak .... ÇALIŞTI.
        /*
        for (int i = 0; i < linkler.size(); i++) {
            linkler = driver.findElements(By.xpath("(//*[@class='nav-a  '])" +
                    "[position()>=2 and position()<=3]"));
            linkler.get(i).click();
            if (driver.getTitle().contains("Amazon")) {
                System.out.println("Test PASSED");
            } else {
                System.out.println("Test FAILED");
            }
            Thread.sleep(3000);
            driver.navigate().back();
        }*/


        //FOREACH ile position()>= kullanarak .... ÇALIŞMADI.
/*
        try {
            for (WebElement w : linkler) {

                linkler = driver.findElements(By.xpath("(//*[@class='nav-a  '])" +
                        "[position()>=2 and position()<=3]"));
                w.click();
                if (driver.getTitle().contains("Amazon")) {
                    System.out.println("Test PASSED");
                } else {
                    System.out.println("Test FAILED");
                }
                Thread.sleep(3000);
                driver.navigate().back();


            }
        }*/ /*catch (StaleElementReferenceException e) {

            }
*/

            // | (OR) yapısı kullanılarak FORİ ile. ÇALIŞTI...
        /*
        List<WebElement> butonlar = driver.
                findElements(By.xpath("//*[@class='nav-a  '][2]|//*[@class='nav-a  '][3]"));
        for (int i = 0; i < butonlar.size() ; i++) {
            butonlar = driver.
                    findElements(By.xpath("//*[@class='nav-a  '][2]|//*[@class='nav-a  '][3]"));
            butonlar.get(i).click();
            Thread.sleep(3000);
            driver.navigate().back();
        }*/

            driver.close();

        }
    }
}
