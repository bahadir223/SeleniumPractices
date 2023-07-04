package KendiCalismalarim.day03;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Files_Exists_File_Download extends TestBase {

    //https://the-internet.herokuapp.com/upload adresine gidelim
    //Dosya Sec butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.
    //Upload butonuna basalim.
    //"File Uploaded!" textinin goruntulendigini test edelim


    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //upload görünene kadar bekleyelim.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("file-submit")));
        //Dosya Sec butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:/Users/bahad/OneDrive/Masaüstü/plan.txt";
        dosyaSec.sendKeys(dosyaYolu);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit"));
        //"File Uploaded!" textinin goruntulendigini test edelim
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
