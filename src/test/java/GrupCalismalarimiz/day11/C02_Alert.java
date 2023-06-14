package GrupCalismalarimiz.day11;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class C02_Alert extends TestBase {
    @Test
    public void test01() {

        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        bekle(3);

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
        bekle(2);

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        String alert = driver.switchTo().alert().getText();
        System.out.println(alert);
        driver.switchTo().alert().accept();
        bekle(2);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        bekle(2);

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        bekle(2);

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@id='Textbox']")).click();
        bekle(2);

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Bahadır Günüvar");
        bekle(3);
        driver.switchTo().alert().accept();
        //-Çıkan mesajı konsola yazdırınız
        String cikanMesaj = driver.findElement(By.cssSelector("[id='demo1']")).getText();
        System.out.println(cikanMesaj);
        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        String beklenenMesaj = "Hello Bahadır Günüvar How are you today";
        Assert.assertEquals(beklenenMesaj, cikanMesaj);
    }


}
