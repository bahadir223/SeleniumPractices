package KendiCalismalarim.day02;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.nio.file.Paths;

public class C01_DownloadFile extends TestBase {
    /*
    Selenium ile web sayfasında dosya indirme işlemi nasıl yapılır?
     */

    @Test
    public void test01() {
        //https://demoqa.com/upload-download adresine gidin.
        driver.get("https://demoqa.com/upload-download");
        //download button'una tiklayin.
        driver.findElement(By.id("downloadButton")).click();
        bekle(5);

    }
}
