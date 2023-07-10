package KendiCalismalarim.day08;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C01_SsgOdev extends TestBase {
    /*
    Test Görevi:
        https://www.kitapyurdu.com/ adresine gidiniz.
        Anasayfanın açıldığını sayfa URL'si ile doğrulayınız.
        Anasayfanın açıldığını sayfa başlığı ile doğrulayınız. (Kitapyurdu, Kitapla buluşmanın en kolay yolu)
        Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
        Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
        "Üye Ol" butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
        En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
        En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
        Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.
        quit() ve close() metotları arasındaki farkı inceleyelim.
     */

    @Test
    public void getMetotlariTesti() {
        // Web sitesine gidilir
        driver.get("https://www.kitapyurdu.com/");

        // URL ile doğrulama yapılır
        String expectedUrl = "https://www.kitapyurdu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // Site başlığı ile doğrulama yapılır
        String expectedTitle = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Anasayfada bazı başlıkların bulunduğunun doğrulanması
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Haftanın Yayınevi"));
        Assert.assertTrue(pageSource.contains("En Çok Satılanlar"));
        Assert.assertTrue(pageSource.contains("Ayın Yayınevleri"));

        // Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunun doğrulanması
        WebElement girisYapButonu = driver.findElement(By.xpath("//div[@class='menu-top-button login']"));
        String girisYapButonuText = girisYapButonu.getText();
        Assert.assertEquals("Giriş Yap", girisYapButonuText);

        // "Üye Ol" butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunun doğrulanması
        WebElement uyeOlButonu = driver.findElement(By.linkText("Üye Ol"));
        String uyeOlButonuHref = uyeOlButonu.getAttribute("href");
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register", uyeOlButonuHref);

        // En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunun doğrulanması
        List<WebElement> yazarIsimleriListesi = driver.findElements(By.xpath("//span[@class='author line-clamp-2']"));
        for (WebElement yazarIsmi : yazarIsimleriListesi) {
            Assert.assertEquals("span", yazarIsmi.getTagName());
        }

        // En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunun doğrulanması
        for (WebElement yazarIsmi : yazarIsimleriListesi) {
            Assert.assertEquals("Arial, Helvetica, sans-serif", yazarIsmi.getCssValue("font-family"));
        }

        // Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunun doğrulanması
        WebElement urunResmi = driver.findElement(By.xpath("//img[@alt='Kurtuluş Günü']"));
        int resimGenisligi = urunResmi.getSize().getWidth();
        int resimYuksekligi = urunResmi.getSize().getHeight();
        Assert.assertEquals(120, resimGenisligi);
        Assert.assertEquals(174, resimYuksekligi);

        WebElement googlePlay = driver.findElement(By.xpath("//a[@class='footer-sprite google-play-button']"));
        googlePlay.click();

        bekle(3);

        switchToWindow(1);

        bekle(3);
    }
}
