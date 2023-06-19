package GrupCalismalarimiz.day15;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01 extends TestBase {
    //    Test01
    //1- amazon gidin
    //2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    //3. dropdown menude 40 eleman olduğunu doğrulayın
    //    Test02
    //1. dropdown menuden elektronik bölümü seçin
    //2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
    //4. ikinci ürüne relative locater kullanarak tıklayin
    //5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
    //    Test03
    //1. yeni bir sekme açarak amazon anasayfaya gidin
    //2. dropdown’dan bebek bölümüne secin
    //3. bebek puset aratıp bulundan sonuç sayısını yazdırın
    //4. sonuç yazsının puset içerdiğini test edin
    //5-üçüncü ürüne relative locater kullanarak tıklayin
    //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    //    Test 4
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın


    @Test
    public void test01() {
        //amazon gidin
        driver.get("https://amazon.com");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        List<WebElement> menuler = select.getOptions();
        for (int i = 0; i < menuler.size(); i++) {
            System.out.println(menuler.get(i).getText());

        }

        //dropdown menude 40 eleman olmadığını doğrulayın.
        Assert.assertNotEquals(40, menuler.size());

    }

    @Test
    public void test02() {
        //amazon gidin
        driver.get("https://amazon.com");
        //dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Electronics");
        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        String sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        //1-24 of over 6,000 results for "iphone"
        String[] arr = sonucYazisi.split(" ");
        System.out.println("Sonuc = " + arr[3]);
        //Sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucYazisi.contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        WebElement ikinciUrun = driver.findElement(with(By.tagName("div")).toRightOf(birinciUrun));
        ikinciUrun.click();

        //ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        WebElement fiyat = driver.findElement(By.cssSelector("[class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay'] "));
        String title = driver.getTitle();
        driver.findElement(By.xpath("//*[@id='submit.add-to-cart']")).click();
    }
}
