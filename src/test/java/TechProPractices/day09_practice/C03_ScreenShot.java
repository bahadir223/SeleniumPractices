package TechProPractices.day09_practice;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class C03_ScreenShot extends TestBase {
    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc yazısını yazdiriniz
    // ilk urunun fotografını cekin


    @Test
    public void test01() throws IOException {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        }

        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Oppo" + Keys.ENTER);

        // sonuc yazısını yazdiriniz
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println("Sonuc Yazisi => " + sonucYazisi.getText());
        //ilk urunun fotografını cekin
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class=' prd-link '])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_dd_MM_yyyy").format(new Date());
        String dosyaYolu = "src/test/java/WebElementSS/screenShot" + tarih + ".jpg";
        FileUtils.copyFile(ilkUrun.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }
}
