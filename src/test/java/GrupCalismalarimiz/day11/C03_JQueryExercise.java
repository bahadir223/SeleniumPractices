package GrupCalismalarimiz.day11;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C03_JQueryExercise extends TestBase {
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
    // ikinci emojiye tıklayın
    // İkinci emoji öğelerini yazdırınız
    // Parent iframe e geri donun
    // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
    // Apply button a basiniz

    @Test
    public void test01() {

        //https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //ikinci emojiye tıklayın
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[2]")));

        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        bekle(3);
        //İkinci emoji öğelerini yazdırınız
        WebElement image = driver.findElement(By.xpath("//*[@class='mdl-tabs__panel is-active']"));
        System.out.println(image.getText());
        //Parent iframe e geri donun
        driver.switchTo().parentFrame();
        //Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.cssSelector("[id='text']"))
                .sendKeys("Bahadir", Keys.TAB, "Gülücük",
                        Keys.TAB, "YUSUF", Keys.TAB, "MEHTAP",
                        Keys.TAB, "SEVDE", Keys.TAB, "MURAT",
                        Keys.TAB, "YAŞAR", Keys.TAB, "ALİ",
                        Keys.TAB, "KEMAL", Keys.TAB, "GÖKHAN",
                        Keys.TAB, "gülücük",Keys.TAB);
        bekle(3);
        driver.findElement(By.cssSelector("[id='send']")).click();
    }
}
