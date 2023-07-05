package KendiCalismalarim.day04;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class C01_ScreenShot_TumSayfa extends TestBase {
    //Techproeducation sayfasına gidelim
    //Çıkan reklamı kapatalım
    //Ve ekran görüntüsünü alalım


    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //Çıkan reklamı kapatalım
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='eicon-close']")));
        driver.findElement(By.cssSelector("[class='eicon-close']")).click();
        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/TumSayfaResmiSS/screenShot" + tarih + ".jpg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }
}
