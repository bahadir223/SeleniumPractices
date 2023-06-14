package TechProPractices.day05_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
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
        //Videoyu izlemek icin Play tusuna basiniz
        //bunun icin önce iframe'e geciş yapmamız lazım çünkü video, iframe nin icinde...
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[1]")));
        driver.findElement(By.cssSelector("[class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        //Videoyu calistirdiginizi test ediniz

        //'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[2]")).isDisplayed());

    }
}
