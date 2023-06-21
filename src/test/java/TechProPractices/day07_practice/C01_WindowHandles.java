package TechProPractices.day07_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C01_WindowHandles extends TestBase {

    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'Oppo' yazıp aratın
    // ilk ürüne tıklayın
    // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
    // ilk sayfaya donun ve Title'ını yazdırın


    @Test
    public void test01() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        bekle(2);
        //arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.id("searchData")).sendKeys("Oppo", Keys.ENTER);
        //ilk ürüne tıklayın
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//h3)[4]")).click();
        bekle(3);
        /*
        ilk ürüne tıkladığımız zaman İSTEMİMİZ DIŞINDA KENDİ KENDİNE YENİ BİR SEKMEYE YÖNELDİĞİ İÇİN
        BİZİM BU AÇILAN PENCERELERİN HANDLE DEĞERLERİNİ BİR LİST'E ATIP İNDEXLERİYLE İŞLEM YAPMAMIZ GEREKİR...
        PENCERELERİN HANDLE DEĞERLERİ insanın id si gibi düşün. unique yani. String Her pencerenin kendine özel
         */
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        //ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        Assert.assertTrue(driver.getTitle().contains("Türkiye"));
        //ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(pencereler.get(0));
        System.out.println("Ilk sayfa Basligi = " + driver.getTitle());
    }
}
