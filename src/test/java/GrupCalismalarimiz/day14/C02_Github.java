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
        WebElement ekran = driver.findElement(By.className("signature-pad--body"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ekran).clickAndHold(ekran).moveByOffset(100, 100)  // 100 birim sağa, 100 birim aşağı
                .moveByOffset(-100, 0)   // 100 birim sola
                .moveByOffset(0, -100)   // 100 birim yukarı
                .moveByOffset(-100, 0)   // 100 birim sola
                .moveByOffset(0, -100)   // 100 birim yukarı
                .moveByOffset(100, 0).perform();

//        - Çizimden sonra clear butonuna basınız
        driver.findElement(By.className("button clear")).click();
//        - Sayfayi kapatiniz

    }
}
