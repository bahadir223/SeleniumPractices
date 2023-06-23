package GrupCalismalarimiz.day17;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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
    //Marka'dan 2.yi seç, Fiyat aralığı 200 -500 gir, arama butonuna tıkla.
    //Sıralama'dan yüksek puanlıları seçip ilk çıkan ürüne tıkla.
    //Sepete ekle.
    //Ürün sepetinizde yazısının çıktığını doğrula.
    //Sepete Git'e tıkla.
    //Alışverişi tamamla butonuna tıkla.


    @Test
    public void test01() {
        //hepsiburada.com'a git
        driver.get("https://www.hepsiburada.com/");
        bekle(2);
        WebElement cerezKabulEt = driver.findElement(By.cssSelector("[id='onetrust-accept-btn-handler']"));
        cerezKabulEt.click();

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
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']")));
        //Ürün sepetinizde yazısının çıktığını doğrula.
        WebElement urunSepetinizde = driver.findElement(By.cssSelector("[class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']"));
        Assert.assertEquals("Ürün sepetinizde", urunSepetinizde.getText());
        bekle(1);
        //Alışverişe devam et'e tıkla.
        driver.findElement(By.cssSelector("[class='checkoutui-ProductOnBasketHeader-zdTSacusLu4Cu0LDpmnB']")).click();
        //Marka'dan 2. seç,ikincinin seçildiğini doğrula.
        driver.findElement(By.xpath("(//*[@type='checkbox'])[11]")).click();
        bekle(2);
        driver.navigate().refresh();
        WebElement marka = driver.findElement(By.cssSelector("[class='appliedVerticalFilter-pSOYt8wpwv9fUK7bNUjk']"));
        Assert.assertTrue(marka.isDisplayed());

        //Fiyat aralığı 200 -500 gir, arama butonuna tıkla.
        driver.findElement(By.xpath("//*[text()='ürün listeleniyor']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.cssSelector("[placeholder='En az']")).sendKeys("200", Keys.TAB, "500", Keys.TAB, Keys.ENTER);
        bekle(2);
        driver.navigate().refresh();
        bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Fiyat aralığını 200-500 seçildiğini test et.
        Assert.assertTrue
                (driver.findElement(By.xpath("(//*[@class='appliedVerticalFilter-rxdhhFDFaJiRVL0RqUW_'])[1]")).isDisplayed());
        //Sıralama'dan yüksek puanlıları seçip ilk çıkan ürüne tıkla.
        driver.findElement(By.cssSelector("[class='sorting-area']")).click();
        driver.findElement(By.xpath("(//*[@class='horizontalSortingBar-PkoDOH7UsCwBrQaQx9bn'])[6]")).click();
        bekle(2);
        driver.findElement(By.xpath("(//h3)[1]")).click();
        //Sepete ekle.
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
        bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("[id='addToCart']")).click();
        //ürün sepetinizde'yi görene kadar bekledik.
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']")));

        //Ürün sepetinizde yazısının çıktığını doğrula.
        WebElement urunSepetinizde1 = driver.findElement(By.cssSelector("[class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']"));
        Assert.assertEquals("Ürün sepetinizde", urunSepetinizde1.getText());

        //Sepete Git'e tıkla.
        driver.findElement(By.xpath("(//*[@type='button'])[6]")).click();

        //Alışverişi tamamla butonuna tıkla.
        driver.findElement(By.id("continue_step_btn")).click();

    }
}
