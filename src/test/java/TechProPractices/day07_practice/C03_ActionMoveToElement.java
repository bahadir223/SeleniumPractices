package TechProPractices.day07_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class C03_ActionMoveToElement extends TestBase {

    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz


    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com ");
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dilSecenekMenu = driver.findElement(By.cssSelector("[class='icp-nav-link-inner']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dilSecenekMenu).perform();
        bekle(2);
        //Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[@class='icp-mkt-change-lnk'])[1]")).click();
        bekle(2);
        //United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.cssSelector("select[id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        bekle(2);
        /*
        menünün kapanıp go to website' in görünmesi icin sayfada herhangi bir yere tıklamamız gerekir.
         */
        actions.moveToElement(driver.findElement(By.xpath("//*[text()='Turkey (Türkiye)']"))).click().perform();
        bekle(2);
        // Go to website butonuna tiklayiniz
        driver.findElement(By.cssSelector("[id='icp-save-button']")).click();
        bekle(3);
        //acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        /*
        şimdi go to website dediğimiz anda bizim istemimiz dışında kendisi yeni bir sekme açtığı için,,,,
        biz bu açılan pencereleri sekmeleri bir List'e atacağız.....
         */
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Elektronik"));
    }
}
