package GrupCalismalarimiz.day23;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.LinkedList;
import java.util.List;

public class C03_SoftAssert extends TestBase {
    /*
    Yeni bir Class Olusturun : C03_SoftAssert
    1. “http://zero.webappsecurity.com/” Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password” yazin
    5. Sign in tusuna basin
    6. Online banking menusu icinde Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
    edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
    (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
    (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
    (krone)","New Zealand (dollar)","Sweden (krona)","Singapore
    (dollar)","Thailand (baht)"
     */

    SoftAssert softAssert;

    @Test
    public void test01() {
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.cssSelector("[id='signin_button']")).click();
        //3. Login kutusuna “username” yazin
        //4. Password kutusuna “password” yazin
        driver.findElement(By.cssSelector("[id='user_login']"))
                .sendKeys("username", Keys.TAB, "password", Keys.TAB, Keys.TAB, Keys.ENTER);
        driver.navigate().back();
        //Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//strong)[2]")).click();
        driver.findElement(By.cssSelector("[id='pay_bills_link']")).click();
        //“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.cssSelector("[href='#ui-tabs-3']")).click();
        //“Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.cssSelector("select[id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");
        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        softAssert = new SoftAssert();
        softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Eurozone (euro)");
        //    soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //    edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //    (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //    (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //    (krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //    (dollar)","Thailand (baht)"

        List<String> expectedUlkeler = new LinkedList<>();
        expectedUlkeler.add("Select One");
        expectedUlkeler.add("Australia (dollar)");
        expectedUlkeler.add("Canada (dollar)");
        expectedUlkeler.add("Switzerland (franc)");
        expectedUlkeler.add("China (yuan)");
        expectedUlkeler.add("Denmark (krone)");
        expectedUlkeler.add("Eurozone (euro)");
        expectedUlkeler.add("Great Britain (pound)");
        expectedUlkeler.add("Hong Kong (dollar)");
        expectedUlkeler.add("Japan (yen)");
        expectedUlkeler.add("Mexico (peso)");
        expectedUlkeler.add("Norway (krone)");
        expectedUlkeler.add("New Zealand (dollar)");
        expectedUlkeler.add("Sweden (krona)");
        expectedUlkeler.add("Singapore (dollar)");
        expectedUlkeler.add("Thailand (baht)");

        List<WebElement> ulkeler = select.getOptions();
        System.out.println("ulkeler size = " + ulkeler.size());
        System.out.println("expectedUlkeler size = " + expectedUlkeler.size());

        for (int i = 0; i < expectedUlkeler.size(); i++) {
            softAssert.assertTrue(expectedUlkeler.get(i).equals(ulkeler.get(i).getText()));
        }

        //    int idx = 0;
        //    for (int i = 0; i < 1; i++) {
        //        for (int j = 0; j < expectedUlkeler.size(); j++) {
        //            softAssert.assertTrue(expectedUlkeler.get(j).equals(ulkeler.get(idx).getText()));
        //            idx++;
        //        }
        //    }

        softAssert.assertAll();
    }
}

