package GrupCalismalarimiz.day14;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Github extends TestBase {
    @Test
    public void test01() {

        //        - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

//        - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz

        /*
        moveByOffset :
        fare işaretçisini belirtilen x ve y koordinatlarına göre belirtilen ofset değeri kadar hareket ettirir.
         */
        WebElement ekran = driver.findElement(By.className("signature-pad--body"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(ekran)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .release()
                .perform();


        bekle(6);

//        - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();
//        - Sayfayi kapatiniz

    }
}
