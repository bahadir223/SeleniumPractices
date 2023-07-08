package TechProPractices.day12_practice;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Webtables extends TestBase {
    @Test
    public void test01() {

        girisYap();

        //Input olarak verilen satir sayisi ve sütun sayisina sahip cell'deki text'i dinamik olarak yazdiriniz.

        int satir = 3;
        int sutun = 3;

        //WebElement arananCell = driver.findElement(By.xpath("//tbody//tr[3]//td[3]"));


        //DINAMIK SEKILDE
        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println("Aranan Cell = " + arananCell.getText());
        //Aranan Cell = kristalhotel@gmail.com

    }

    public void girisYap() {

        // https://www.hotelmycamp.com adresine gidin
        driver.get("https://www.hotelmycamp.com");

        //güvenlik kismi
        WebElement gelismisKismi = driver.findElement(By.xpath("//button[@id='details-button']"));
        gelismisKismi.click();

        //güvenli degil kismi
        WebElement siteyeGit = driver.findElement(By.xpath("//a[@id='proceed-link']"));
        siteyeGit.click();


        // Log in butonuna tıklayın
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        // Username: manager
        // Password: Manager1!

        //username kutucugunun locate'i
        WebElement username = driver.findElement(By.xpath("//input[@id='UserName']"));

        //kutucuklari doldurmak icin action objesi kullanacagiz
        Actions actions = new Actions(driver);
        actions.click(username).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
