package GrupCalismalarimiz.day12;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class C01 extends TestBase {

    //  ...Exercise2...
    //  1-driver olusturalim
    //  2-java class'imiza chromedriver.exe'yi tanitalim
    //  3-driver'in tum ekrani kaplamasini saglayalim
    //  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
    //    söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
    //  5-"sahibinden.com" adresine gidelim
    //  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
    //  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
    //  8-Ardindan "hepsiburada.com" adresine gidelim
    //  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini
    //    kontrol edelim
    //  10-Bi onceki web sayfamiza geri donelim
    //  11-sayfayi yenileyelim
    //  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
    //  13-En son adim olarak butun sayfalarimizi kapatmis olalim


    @Test
    public void test01() {
        //"sahibinden.com" adresine gidelim
        driver.get("http://www.sahibinden.com/");
        bekle(3);
        //bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String actualTitle = driver.getTitle();
        String actualURL = driver.getCurrentUrl();
        //title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualTitle.contains("Oto"));
        Assert.assertFalse(actualURL.contains("Oto"));
        //Ardindan "hepsiburada.com" adresine gidelim
        driver.get("https://www.hepsiburada.com/");
        bekle(3);
        //bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String actualTitle2 = driver.getTitle();
        Assert.assertTrue(actualTitle2.contains("Sitesi"));
        //Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        bekle(2);
        //sayfayi yenileyelim
        driver.navigate().refresh();
        bekle(2);
        //Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();
        bekle(2);
        driver.close();
        //En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();


    }
}
