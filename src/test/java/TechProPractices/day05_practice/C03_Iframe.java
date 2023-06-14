package TechProPractices.day05_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class C03_Iframe extends TestBase {

    // https://html.com/tags/iframe sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // Videoyu calistirdiginizi test ediniz
    // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        /*
        scroll'ü aşağıya indirme şu şekilde de yapılabilirdi:
        // JavascriptExecutor örneği al
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Sayfayı 500 piksel aşağı kaydır
        js.executeScript("window.scrollBy(0,500)");

         */

        //Videoyu izlemek icin Play tusuna basiniz, ekranı full screen yapın sonra normal boyuta getirin
        //bunun icin önce iframe'e geciş yapmamız lazım çünkü video, iframe nin icinde...
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[1]")));
        driver.findElement(By.cssSelector("[class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        //ekranı tam boyut yap.

        //Videoyu calistirdiginizi test ediniz
        //videoyu açtıktan sonra sağ altta youtube yazısı çıkıyor.onun locate'ini aldık...bu şekilde test ettik
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']")).isDisplayed());

        //'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[2]")).isDisplayed());

    }
}
