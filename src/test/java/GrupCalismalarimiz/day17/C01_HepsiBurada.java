package GrupCalismalarimiz.day17;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_HepsiBurada extends TestBase {
    //hepsiburada.com'a git
    //Ekrandaki Spor,Outdoor'un üzerine gelip aşağıda açılan Kamp Kampçılık Malzemelerinin altındaki Kamp Sandalyesine tıkla
    //Sağ yukarıdaki Sıralama butonundan Çok Satanlara tıkla.
    //Açılan sandalyelerden soldan 2 üstten 2. ye relative locater kullanarak tıkla.
    //Tıklayınca Yeni sekme açılacak. Ürün başlığı ile fiyatını bir variable'a ata.
    //Sepete ekle.
    //Ürün sepetinizde yazısının çıktığını doğrula.
    //Alışverişe devam et'e tıkla.
    //Marka'dan Ege'yi seç, Fiyat aralığı 200 -500 gir, arama butonuna tıkla.
    //Sıralama'dan yüksek puanlıları seçip son çıkan ürüne tıkla.
    //Sepete ekle.
    //Ürün sepetinizde yazısının çıktığını doğrula.
    //Sepete Git'e tıkla.
    //Alışverişi tamamla butonuna tıkla.
    //Yeni adres ekle'ye tıkla.
    //Açılan sayfadan ad soyad telefon adres bilgileriniz i gir. Şehir , ilçe , mahalle seç. Adres gir. Bu adrese bir
    //ad verini doldur. Adresi Kaydet' e tıkla.


    @Test
    public void test01() {
        //hepsiburada.com'a git
        driver.get("https://www.hepsiburada.com/");
        bekle(2);
        WebElement cerezKabulEt = driver.findElement(By.cssSelector("[id='onetrust-accept-btn-handler']"));
        cerezKabulEt.click();
        /*
        //mouse ile giriş yap' ın üstüne gidip aşağıda açılan menüden giriş yap butonuna tıkla.
        WebElement girisYap = driver.findElement(By.cssSelector("[data-test-id='account']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(girisYap).perform();
        bekle(2);
        driver.findElement(By.cssSelector("[id='login']")).click();
        //e posta = yusufaltunok@hotmail.com yazıp Giriş Yap'a tıkla.
        driver.findElement(By.xpath("(//*[@id='txtUserName'])[1]"))
                .sendKeys("bahadir.223@hotmail.com", Keys.ENTER);
        ////Şifre = Yusuf1977 ENTER'a bas.
        WebElement password = driver.findElement(By.xpath("(//*[@id='txtPassword'])[1]"));

        password.sendKeys("Bahadir.123");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        password.sendKeys(Keys.TAB, Keys.ENTER);
        */

        //Ekrandaki Spor,Outdoor'un üzerine gelip aşağıda açılan Kamp Kampçılık Malzemelerinin altındaki Kamp Sandalyesine tıkla
        WebElement spor = driver.findElement(By.xpath("(//*[@class='sf-MenuItems-UHHCg2qrE5_YBqDV_7AC'])[6]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(spor).perform();
        bekle(2);
        driver.findElement(By.cssSelector("[class='sf-ChildMenuItems-OIXGN6gTcuAXz_dkh8Yv item-3130']")).click();
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        //Sağ yukarıdaki Sıralama dan Çok Satanlara tıkla.
        driver.findElement(By.cssSelector("[class='sorting-area']")).click();
        driver.findElement(By.xpath("(//*[@class='horizontalSortingBar-PkoDOH7UsCwBrQaQx9bn'])[3]")).click();
        //Açılan sandalyelerden soldan 2 üstten 2. ye relative locater kullanarak tıkla.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement ikinciUrun = driver.findElement(By.xpath("(//h3)[2]"));
        driver.findElement(with(By.tagName("h3")).below(ikinciUrun)).click();
        //ürüne tıklayınca istemimiz dışında yeni bir sekme açıldığı için bunları bir list'e atayıp çağırmamız gerek
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        //Ürün başlığı ile fiyatını bir variable'a ata.
        String sandalyeBaslik = driver.findElement(By.xpath("(//h1)[1]")).getText();
        //String sandalyeFiyat1=driver.findElement(By.cssSelector("[data-bind='markupText:'currentPriceBeforePoint'']")).getText();
        //String sandalyeFiyat2=driver.findElement(By.cssSelector("[data-bind='markupText:'currentPriceAfterPoint'']")).getText();
        System.out.println("Sandalye Adı = " + sandalyeBaslik);
        String sandalyeFiyat = driver.findElement(By.cssSelector("[id='offering-price']")).getText();
        System.out.println("Sandalye Fiyatı= " + sandalyeFiyat);
        //Sepete ekle.
        driver.findElement(By.cssSelector("[id='addToCart']")).click();
        bekle(2);
        //driver.switchTo().frame(0);
        bekle(2);
        //Ürün sepetinizde yazısının çıktığını doğrula.
        WebElement urunSepetinizde = driver.findElement(By.cssSelector("[class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']"));
        Assert.assertEquals("Ürün sepetinizde", urunSepetinizde.getText());


    }
}
