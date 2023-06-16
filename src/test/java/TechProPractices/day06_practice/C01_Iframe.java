package TechProPractices.day06_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Iframe extends TestBase {
    @Test
    public void iframe() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN);

        //video iframe'in icinde oldugu icin iframe'e gecis yapmamiz gerekiyor önce...
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[1]")));

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement ilkPlayTusu = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        ilkPlayTusu.click();
        bekle(3);
        // videoyu durdurunuz
        WebElement playAndStop = driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']"));
        playAndStop.click();
        bekle(1);
        // videoyu tam ekran yapınız
        WebElement kucultmeBuyutme = driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']"));
        kucultmeBuyutme.click();
        bekle(2);
        // videoyu calıstırınız
        playAndStop.click();
        bekle(2);
        // videoyu kucultunuz
        kucultmeBuyutme.click();
        bekle(2);
        // videoyu durdurunuz
        playAndStop.click();
        bekle(2);
        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());
        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        //actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP);
        driver.switchTo().defaultContent();
        WebElement jQueryYazisi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(jQueryYazisi.isDisplayed());
    }
}
