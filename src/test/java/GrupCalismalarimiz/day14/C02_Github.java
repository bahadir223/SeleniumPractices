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
        actions.clickAndHold(ekran).moveByOffset(100, 100)  // 100 birim sağa, 100 birim aşağı
                .moveByOffset(-100, 0)
                .moveByOffset(0, -100)
                .moveByOffset(-100, 0)
                .moveByOffset(0, -100)
                .moveByOffset(100, 0).moveByOffset(40, 50).
                moveByOffset(50, 60).
                moveByOffset(60, 10).
                moveByOffset(70, 15).
                moveByOffset(80, 20).
                moveByOffset(90, 30).release().perform();


        bekle(6);

//        - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();
//        - Sayfayi kapatiniz

    }
}
