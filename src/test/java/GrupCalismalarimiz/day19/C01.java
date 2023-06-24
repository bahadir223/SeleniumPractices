package GrupCalismalarimiz.day19;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01 extends TestBase {

    @Test
    public void test01() {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);
        WebElement birinci = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
        //rengi kırmızı yapmak için ikinci ve üçüncü slidebar' en basa çekmek gerekiyor
        WebElement ikinci = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(ikinci).moveByOffset(-170, 0).release().perform();
        bekle(3);
        WebElement ucuncu = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        actions.moveToElement(ucuncu).click().perform();
        actions.clickAndHold(ucuncu).moveByOffset(+1500, 0).release().perform();
        bekle(2);
        /*
        //rengi sarı yapmak için ikinci slidebar'ı en sona çekmek gerekiyor
        ikinci = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        actions.clickAndHold(ikinci).moveByOffset(300, 0).release().perform();
        //-Sarı olduğunu test edelim
         */

    }
}
