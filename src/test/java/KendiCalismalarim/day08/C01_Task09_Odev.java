package KendiCalismalarim.day08;

import Utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutPut/extentReports/extentReport.html" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter); // --> HTML formatında raporlamayı başlatacak.

        //Raporda gözükmesini istediğimiz bilgiler icin
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Bahadir");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("Extend Test", "Test Raporu");

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        extentTest.info("https://www.selenium.dev/downloads/ adresine gidildi");

        //Sayfanın resmini alalım
        String tarih2 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu2 = "src/test/java/TumSayfaResmiSS/screenShot" + tarih2 + ".jpg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu2));
        extentTest.info("https://www.selenium.dev/downloads/ sayfasının resmi alındı.");
        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser = driver.findElement(By.xpath("(//*[@type='button'])[87]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", browser);
        extentTest.info("Browsers bölümü görünene kadar sayfa aşağı indirildi.");
        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("(//*[@type='button'])[87]")).click();
        WebElement chromeDoc = driver.findElement(By.cssSelector("[href='https://chromedriver.chromium.org/']"));
        js.executeScript("arguments[0].scrollIntoView(true);", chromeDoc);
        chromeDoc.click();
        extentTest.info("Chrome driver bölümündeki documentation linkine tıklıandı");

    }
}
