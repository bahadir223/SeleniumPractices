package TechProPractices.day07_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;

public class C01_WindowHandles extends TestBase {

    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'Oppo' yazıp aratın
    // ilk ürüne tıklayın
    // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
    // ilk sayfaya donun ve Title'ını yazdırın


    @Test
    public void test01() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        bekle(2);
        //arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.id("searchData")).sendKeys("Oppo", Keys.ENTER);
        //ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='lazy cardImage'])[1]")).click();
        bekle(3);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        //ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        Assert.assertTrue(driver.getTitle().contains("Türkiye"));
        //ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        System.out.println("Ilk sayfa Basligi = " + driver.getTitle());
    }
}
