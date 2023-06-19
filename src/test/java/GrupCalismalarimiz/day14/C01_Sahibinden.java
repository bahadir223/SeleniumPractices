package GrupCalismalarimiz.day14;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Sahibinden extends TestBase {
    @Test
    public void test() {

        //sahibinden.com adersine git
        driver.get("https://sahibinden.com");

        //Acılısta gelen cerezi reddet
        driver.findElement(By.cssSelector("[id='onetrust-reject-all-handler']")).click();

        //koctas videosuna tıkla
        //ilk iframe'e gecis yap
        WebElement ilkIframe = driver.findElement(By.cssSelector("[id='google_ads_iframe_/32607536/mainpage_masthead_0']"));
        driver.switchTo().frame(ilkIframe);

        WebElement ikinciIframe = driver.findElement(By.cssSelector("[class='you-video']"));
        driver.switchTo().frame(ikinciIframe);

        driver.findElement(By.xpath("//*[text()='koctas.com.tr ile her evde moda!']")).click();

        //youtubeda videoyu pause tusuna basarak durdur
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.findElement(By.cssSelector("[class='ytp-play-button ytp-button']")).click();

        //sahibinden.com sıtesine geri don
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        //Vasıta  altındakı otomobil secenegine tıkla
        driver.get("https://www.sahibinden.com/kategori/otomobil");
        WebElement otomobil = driver.findElement(By.xpath("//a[@href='/kategori/otomobil']"));
        otomobil.sendKeys(Keys.CONTROL, Keys.ENTER);
        Actions action = new Actions(driver);


        //sahibinden.com logosunun gorunusr oldugunu dogrula
        //BMW ye tıkla
        //sıralama butonuna tıkla ve urunlerı en yuksek fiyata gore sırala
        //10. araca tıkla (class=searchResultTıtleValue)
        //fıyatı al ve 13.900.000 TL oldugunu dogrula

    }

    @Test
    public void test02() {
        //sahibinden otomobil sahibine gidin
        driver.get("https://www.sahibinden.com/kategori/otomobil");

        //Acılısta gelen cerezi reddet
        driver.findElement(By.cssSelector("[id='onetrust-reject-all-handler']")).click();
    }
}
