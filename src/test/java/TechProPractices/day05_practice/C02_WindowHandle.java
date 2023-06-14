package TechProPractices.day05_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class C02_WindowHandle extends TestBase {
    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim
    @Test
    public void test01() {
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        bekle(2);
        String amazonWindowHandle = driver.getWindowHandle();
        //url'in 'amazon' icerdigini test edelim
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains("amazon"));
        //yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        bekle(2);
        String bestBuyWindowHandle = driver.getWindowHandle();
        //title'in 'Best Buy' icerdigini test edelim
        String bestBuyTitle = driver.getTitle();
        Assert.assertTrue(bestBuyTitle.contains("Best Buy"));
        //ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        bekle(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        bekle(2);
        //arama sonuclarının 'Java' icerdigini test edelim
        String aramaSonuc = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertFalse(aramaSonuc.contains("Java"));
        //ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestBuyWindowHandle);
        //logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//img)[1]"));
        Assert.assertTrue(logo.isDisplayed());
        bekle(2);
    }
}
