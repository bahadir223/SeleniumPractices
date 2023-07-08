package TechProPractices.day12_practice;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShot extends TestBase {
    // https://www.amazon.com/ adresine gidin
    // arama kutusuna Nutella yazip aratın
    // ilk ürüne tıklayın
    // tüm sayfanın fotografını cekin


    @Test
    public void test01() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/ ");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/TumSayfaResmiSS/screenShot" + tarih + ".jpg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }
}
