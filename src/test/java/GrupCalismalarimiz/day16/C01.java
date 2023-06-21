package GrupCalismalarimiz.day16;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01 extends TestBase {

    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Bize Ulaşın' düğmesine tıklayın
    //5. "İLETİŞİME GEÇİN"in görünür olduğunu doğrulayın
    //6. Adı, e-postayı, konuyu ve mesajı girin
    //7. Dosya yükleyin
    //8. 'Gönder' düğmesini tıklayın
    //9. Tamam düğmesine tıklayın
    //10. Başarı mesajını doğrulayın 'Başarı! Bilgileriniz başarıyla gönderildi.' görünür
    //11. 'Ana Sayfa' düğmesine tıklayın ve ana sayfaya başarıyla geldiğini doğrulayın


    @Test
    public void test01() {
        //'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/", actualURL);
        //'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();
        //"İLETİŞİME GEÇİN"in görünür olduğunu doğrulayın
        WebElement contactUs = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(contactUs.isDisplayed());
        //Adı, e-postayı, konuyu ve mesajı girin
        WebElement name = driver.findElement(By.xpath("(//*[@type='text'])[1]"));
        name.sendKeys("bahadir", Keys.TAB, "bahadirg@gmail.com"
                , Keys.TAB, "konumuz", Keys.TAB, "Mesajımız");

        String dosyaYolu = "C:\\Users\\bahad\\OneDrive\\Masaüstü\\seleniumDeneme.txt";
        //Dosya Sec butonuna basalim
        WebElement dosyaSec = driver.findElement(By.cssSelector("[type='file']"));
        dosyaSec.sendKeys(dosyaYolu);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        bekle(2);
        //'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[@type=\"submit\"])[1]")).click();
        bekle(2);
        //Tamam düğmesine tıklayın
        driver.switchTo().alert().accept();
        //Başarı mesajını doğrulayın 'Başarı! Bilgileriniz başarıyla gönderildi.' görünür
        WebElement basariylaDogrulandi = driver.findElement(By.cssSelector("[class='status alert alert-success']"));
        Assert.assertTrue(basariylaDogrulandi.isDisplayed());
        //'Ana Sayfa' düğmesine tıklayın ve ana sayfaya başarıyla geldiğini doğrulayın
        WebElement home = driver.findElement(By.cssSelector("[class='btn btn-success']"));
        home.sendKeys(Keys.CONTROL, Keys.ENTER);

        /*
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[8]")));
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[11]")));
        driver.findElement(By.cssSelector("[id=\"dismiss-button\"]")).click();
        */


    }
}
