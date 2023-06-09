package GrupCalismalarimiz.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C30 {
     /*
    ödev 3:
    1.http://zero.webappsecurity.com/ Adresine gidin
    2.Sign in butonuna basin
    3.Login kutusuna “username” yazin
    4.Password kutusuna “password.” yazin
    5.Sign in tusuna basin(not: navigate.Back yapınız)
    6.Pay Bills sayfasina gidin
    7.“Purchase Foreign Currency” tusuna basin
    8.“Currency” drop down menusunden Eurozone’u secin
    9.“amount” kutusuna bir sayi girin
    10.“US Dollars” in secilmedigini test edin
    11.“Selected currency” butonunu secin
    12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/");
        //Sign in butonuna basin
        driver.findElement(By.xpath("//button")).click();
        //3.Login kutusuna “username” yazin , Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username", Keys.TAB, "password", Keys.ENTER);
        //Sign in tusuna basin(not: navigate.Back yapınız)
        bekle(3);
        driver.navigate().back();
        //Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//li//strong)[2]")).click();
        bekle(3);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        bekle(3);
        //“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//a)[17]")).click();
        bekle(3);
        //“Currency” drop down menusunden Eurozone’u secin, amount kutusuna bir sayi girin
        WebElement ulkeler = driver.findElement(By.xpath("(//select)[3]"));
        ulkeler.sendKeys("Eurozone", Keys.TAB, "650");
        bekle(3);

        //“US Dollars” in secilmedigini test edin.
        WebElement usDollars = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertTrue(!usDollars.isSelected());
        //“Selected currency” butonunu secin.
        usDollars.sendKeys(Keys.RIGHT, Keys.TAB, Keys.ENTER, Keys.TAB, Keys.ENTER);

        bekle(3);
        // “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement yazi = driver.findElement(By.xpath("[id='alert_content']"));
        Assert.assertTrue(yazi.isDisplayed());


    }


    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    WebDriver driver;
     @Before
     public void setUp() throws Exception {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         driver.get("http://zero.webappsecurity.com/");
     }

    @Test
    public void test01() throws InterruptedException {
         //2.Sign in butonuna basin
        driver.findElement(By.xpath("//button")).click();

        //3.Login kutusuna "username" yazin
       // 4.Password kutusuna "password." yazin
        //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();
        //6.Online Bankingé tiklayip Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//strong)[2]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

       // 7."Purchase Foreign Currency" tusuna basin
        driver.findElement(By.xpath("(//a)[17]")).click();

        //8."Currency" drop down menusunden Eurozone'u secin
        //9."amount" kutusuna bir sayi girin
        WebElement ddm =driver.findElement(By.xpath("(//select)[3]"));
        Select select = new Select(ddm);
        ddm.sendKeys("Eurozone (euro)",Keys.TAB,"208");

        //10."US Dollars" in secilmedigini test edin
       WebElement usDolarButon=driver.findElement(By.cssSelector("input[id='pc_inDollars_true']"));
        Assert.assertTrue(!usDolarButon.isSelected());
        //Assert.assertFalse(usDolarButon.isSelected());


        //11."Selected currency" butonunu secin
       // 12."Calculate Costs" butonuna basin sonra "purchase" butonuna basin
        //"Foreign currency cash was successfully purchased." yazisinin ciktigini kontrol edin
        usDolarButon.sendKeys(Keys.ARROW_RIGHT,Keys.TAB,Keys.ENTER,Keys.TAB,Keys.ENTER);//!!!!!!!

        WebElement dogrulama= driver.findElement(By.xpath("//*[@id='alert_content']"));
        Assert.assertEquals("Foreign currency cash was successfully purchased.",dogrulama.getText());


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
     */
}
