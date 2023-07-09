package GrupCalismalarimiz.day23;

import Utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class C01_Task09_Odev extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim
    //Silindiğini doğrulayalım
    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Test
    public void test01() throws IOException {
        extentReports = new ExtentReports();
        String raporTarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String raporDosyaYolu = "testOutPut/extentReports/extentReport.html" + raporTarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(raporDosyaYolu);
        extentReports.attachReporter(extentHtmlReporter); // --> HTML formatında raporlamayı başlatacak.

        //Raporda gözükmesini istediğimiz bilgiler icin
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Bahadir");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("Extend Test", "Test Raporu");

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        extentTest.info("https://www.selenium.dev/downloads/ --> sitesine gidildi");

        //Sayfanın resmini alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/screenshot/screenshot" + tarih + ".jpg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        bekle(2);
        extentTest.info("sayfanin resmini alindi");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browsers = driver.findElement(By.xpath("(//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", browsers);
        bekle(2);
        extentTest.info("Browsers gorunene kadar sayfayi indirildi");

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        js.executeScript("arguments[0].click();", browsers);
        bekle(2);
        WebElement documentation = driver.findElement(By.cssSelector("[href='https://chromedriver.chromium.org/']"));
        extentTest.info("documentation webelemntine tiklandi");

        bekle(4);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        //Documentation webelementinin resmini alalım
        String tarih2 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu2 = "src/test/java/screenshot/screenshot" + tarih2 + ".jpg";
        FileUtils.copyFile(documentation.getScreenshotAs(OutputType.FILE), new File(dosyaYolu2));
        extentTest.info("Documentation webelementinin resmini alindi ve tiklandi");

        js.executeScript("arguments[0].click();", documentation);
        bekle(2);

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//*[@href='/downloads'])[4]")).click();

        WebElement gorunurOlanaKadar = driver.findElement(By.cssSelector("[class='Rn3Z1b C9DxTc ']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(gorunurOlanaKadar));
        extentTest.info("downloand'a tiklandi");

        //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath("//*[text()='ChromeDriver 114.0.5735.90']")).click();
        extentTest.info("Açılan pencerede chromedriver'i indirildi");

        //Driver'in indiğini doğrulayalım
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        WebElement chromeDriver = driver.findElement(By.cssSelector("[href='/114.0.5735.90/chromedriver_linux64.zip']"));
        chromeDriver.click();

        String indirilenDosyaYolu = "C:\\Users\\sevde\\Downloads\\chromedriver_linux64.zip";
        bekle(5);
        Assert.assertTrue(Files.exists(Paths.get(indirilenDosyaYolu)));
        extentTest.info("Driver'in indiğini doğrulandi");

        //İndirmiş olduğumuz dosyayı silelim
        Files.delete(Paths.get(indirilenDosyaYolu));
        extentTest.info("İndirilen dosyayı silindi");

        //Silindiğini doğrulayalım
        Assert.assertFalse(Files.exists(Paths.get(indirilenDosyaYolu)));
        extentTest.info("dosyanin silindigi dogrulandi");

        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)
        extentTest.pass("test sonlandirildi");
        extentReports.flush();


    }
}
