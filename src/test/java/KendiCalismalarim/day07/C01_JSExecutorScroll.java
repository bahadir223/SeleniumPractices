package KendiCalismalarim.day07;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_JSExecutorScroll extends TestBase {
    @Test
    public void test01() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='eicon-close']")));
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("(//*[@class='elementor-icon-list-text'])[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFree);
        bekle(2);
        tumSayfaResmi();


        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUS = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        js.executeScript("arguments[0].scrollIntoView(true);", whyUS);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFree);
        bekle(2);
        tumSayfaResmi();

        //Sayfayı en alta scroll yapalım
        WebElement subscribe = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", subscribe);

        //Sayfayi en üste scroll yapalım

    }
}
