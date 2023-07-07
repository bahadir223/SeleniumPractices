package TechProPractices.day11_practice;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C01_WebTables extends TestBase {
    // girisYap methodu olusturun
    // https://www.hotelmycamp.com adresine gidin
    // Log in butonuna tıklayın
    // Username: manager
    // Password: Manager1!

    // sutun sayısını yazdırın
    // tum body'i yazdirin
    // body'de bulunan satır sayısını yazdırın
    // body'de bulunan satırları yazdırın
    // 4.satırdaki elementleri yazdırın

    @Test
    public void test01() {
        girisYap();
    }

    private void girisYap() {
        // https://www.hotelmycamp.com adresine gidin
        driver.get("https://www.hotelmycamp.com");
        WebElement gelismis = driver.findElement(By.cssSelector("[id=\"details-button\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", gelismis);
        WebElement asagidakiLink = driver.findElement(By.cssSelector("[id=\"proceed-link\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", asagidakiLink);
        js.executeScript("arguments[0].click();", asagidakiLink);
        bekle(2);
        // Log in butonuna tıklayın
        driver.findElement(By.id("navLogon")).click();
        // Username: manager   ,,,,   Password: Manager1!
        WebElement asagidakiLogIn = driver.findElement(By.id("btnSubmit"));
        js.executeScript("arguments[0].scrollIntoView(true);", asagidakiLogIn);
        WebElement userName = driver.findElement(By.cssSelector("[id='UserName']"));
        userName.sendKeys("manager", Keys.TAB, "Manager1!", Keys.ENTER);

        // sutun sayısını yazdırın
        List<WebElement> sutunlar = driver.findElements(By.xpath("//thead//th"));
        System.out.println("sutun sayisi  => " + sutunlar.size());

        // tum body'i yazdirin
        System.out.println("********* Tüm body **********");
        System.out.println(driver.findElement(By.xpath("//tbody")).getText());
        System.out.println();
        // body'de bulunan satır sayısını yazdırın
        List<WebElement> satirlar = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Body'de Bulunan satir sayisi =  " + satirlar.size());
        // body'de bulunan satırları yazdırın
        for (int i = 0; i < satirlar.size(); i++) {
            satirlar = driver.findElements(By.xpath("//tbody//tr"));
            System.out.println(satirlar.get(i).getText());
        }
        System.out.println();
        // 4.satırdaki elementleri yazdırın
        System.out.println("********** 4.satırdaki elementler **********");

        List<WebElement> dorduncuSatir = driver.findElements(By.xpath("(//tbody//tr)[4]"));
        for (int i = 0; i < dorduncuSatir.size(); i++) {
            dorduncuSatir = driver.findElements(By.xpath("(//tbody//tr)[4]"));
            System.out.println(dorduncuSatir.get(i).getText());

        }

    }
}
