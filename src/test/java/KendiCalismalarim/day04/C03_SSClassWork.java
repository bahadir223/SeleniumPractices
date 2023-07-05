package KendiCalismalarim.day04;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class C03_SSClassWork extends TestBase {
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        String techProWindowHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='eicon-close']")));
        driver.findElement(By.cssSelector("[class='eicon-close']")).click();
        bekle(1);

        //sayfanın resmini alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/TumSayfaResmiSS/screenShot" + tarih + ".jpg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        bekle(2);

        //Arama bölümünde java aratalım
        driver.findElement(By.cssSelector("[role='search']")).sendKeys("java", Keys.ENTER);
        bekle(2);

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        String weDosyaYolu = "src/test/java/WebElementSS/screenShot" + tarih + ".jpg";

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //sayfanın resmini alalım
        String tarih2 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu2 = "src/test/java/TumSayfaResmiSS/screenShot" + tarih2 + ".jpg";
        TakesScreenshot ts2 = (TakesScreenshot) driver;
        FileUtils.copyFile(ts2.getScreenshotAs(OutputType.FILE), new File(dosyaYolu2));
        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi2 = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String weDosyaYolu2 = "src/test/java/WebElementSS/screenShot" + tarih + ".jpg";


        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        driver.switchTo().window(techProWindowHandle);
        String tarih3 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu3 = "src/test/java/TumSayfaResmiSS/screenShot" + tarih3 + ".jpg";
        TakesScreenshot ts3 = (TakesScreenshot) driver;
        FileUtils.copyFile(ts3.getScreenshotAs(OutputType.FILE), new File(dosyaYolu3));
    }


}
