package GrupCalismalarimiz.day09;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
;

public class C02 {
    /*
    //obilet.com sitesine git
    //ucak sekmesine tikla
    //nereden ddm ye gel  Antalya HavaLimani (AYT) olani sec
    //nereye ddm den 3 indexli olani sec
    //secilenin Izmir oldugunu dogrula
    //gidis tarihine 10.06.2023 sec
    //donus tarihini 15.06.2023 olarak isaretle
    //yolcu sayisini  ddm den 1 yetiskin bir ogrenci bir cocuk sec aktarmasiz checkbox  secili degilse isaretle
    //ucak bileti bul
    //acilan sayfadan sirala sekmesine tikla
    //fiyata gore sirala
    //en ustteki bilete tikla
    //secilen  gidis ucusu yazisini dogrula (edited)
*/
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void test01() {
        //obilet.com sitesine git
        driver.get("https://www.metroturizm.com.tr/");

        WebElement nereden = driver.findElement(By.xpath("(//*[@role='button'])[1]"));
        nereden.sendKeys(Keys.ENTER,"ELEŞKİRT",Keys.TAB,Keys.ENTER,"BURSA");

    }
}

