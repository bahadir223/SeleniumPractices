package TechProPractices.day09_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDownload extends TestBase {
    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() throws IOException {
        //'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();
        bekle(3);
        //dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
        String dosyaYolu = "C:\\Users\\bahad\\Downloads\\some-file.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        Files.delete(Paths.get(dosyaYolu));
    }
}
