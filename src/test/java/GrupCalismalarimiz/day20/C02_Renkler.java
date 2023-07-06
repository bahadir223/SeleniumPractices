package GrupCalismalarimiz.day20;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Renkler extends TestBase {

    @Test
    public void test01() {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);
        WebElement button = driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
        // Actions actions = new Actions(driver);
        // actions.clickAndHold(button).sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
        //*******************ikinci yol***********************************\\
        Actions actions = new Actions(driver).clickAndHold(button);
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(60, 0);
        }
        actions.release().build().perform();
        bekle(5);
        //-Sarı olduğunu test edelim
        String actual = "left: 100%;";
        String expected = button.getAttribute("style");
        System.out.println("expected = " + expected);
        Assert.assertEquals(expected, actual);
    }
}
