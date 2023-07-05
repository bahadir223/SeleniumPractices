package KendiCalismalarim.day06;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class C01_EkranGoruntusuPratik extends TestBase {
    //trendyol'a gidin.
    //tüm ekran görüntüsü al
    //apple'e bas
    //sonuç listeleniyor yazısının ekran görüntüsünü al
    //en baştaki ürüne tıkla
    //ürünün resmini ekran görüntüsü al


    @Test
    public void test01() throws IOException {
        //trendyol'a gidin.
        driver.get("https://www.trendyol.com/");
        driver.findElement(By.cssSelector("[id=\"onetrust-accept-btn-handler\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='logo']")));
        //tüm ekran görüntüsü al
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/TumSayfaResmiSS/screenShot" + tarih + ".jpg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        //apple'e bas
        bekle(2);
        driver.findElement(By.cssSelector("[src='https://cdn.dsmcdn.com/mnresize/200/200/marketing/datascience/automation/2023/1/26/Apple_202301262111.jpg']")).click();
        //sonuç listeleniyor yazısının ekran görüntüsünü al
        WebElement sonucListeleniyor = driver.findElement(By.cssSelector("[class='srch-ttl-cntnr-wrppr']"));
        String tarih2 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu2 = "src/test/java/WebElementSS/screenShot" + tarih2 + ".jpg";
        FileUtils.copyFile(sonucListeleniyor.getScreenshotAs(OutputType.FILE), new File(dosyaYolu2));
        //en baştaki ürüne tıkla
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@class='prdct-desc-cntnr-name hasRatings'])[1]")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        //ürünün resminin ekran görüntüsünü al
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement ilkFoto = driver.findElement(By.cssSelector("[class='base-product-image']"));
        String tarih3 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu3 = "src/test/java/WebElementSS/screenShot" + tarih3 + ".jpg";
        FileUtils.copyFile(ilkFoto.getScreenshotAs(OutputType.FILE), new File(dosyaYolu3));


    }
}
