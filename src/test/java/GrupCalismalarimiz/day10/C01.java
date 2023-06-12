package GrupCalismalarimiz.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    /*
    https://demoqa.com/ adresıne gıt
    Elemets sekmesını locate et ve tıkla
    Elements altında WEbTables ı locate edıp tıkla
    cıkan ekranda Add butonu tıkla ve regıstratıon formu nu doldur
    fırst:name=username1
    lastname=lastname1
    emaıl =abc @ gmaıl.com
    age=30
    salary=10000
    department =ad bılgılerını doldur ve submıt et
    eklendıgını  maıl yoluyla dogrula
    edıt ı locate et maasını 15000 olarak guncelle
    submıt et
    15000 oldugunu dogrula
    sılme tusunu locate et ve fırstname ı Alden olanı sıl
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/");
    }

    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(3000);
        /*
        Elemets sekmesi aşağıda kaldığı için scroll ile sayfayı aşağı kaydırdık
         */
        // JavascriptExecutor örneği al
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Sayfayı 500 piksel aşağı kaydır
        js.executeScript("window.scrollBy(0,500)");
        bekle(3);
        //Elemets sekmesını locate et ve tıkla
        driver.findElement(By.xpath("(//*[@class='avatar mx-auto white'])[1]")).click();
        bekle(3);
        //Elements altında WEbTables ı locate edıp tıkla
        js.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.xpath("(//*[@class='text'])[4]")).click();
        bekle(3);
        //cıkan ekranda Add butonu tıkla ve regıstratıon formu nu doldur

        driver.findElement(By.id("addNewRecordButton")).click();
        bekle(3);
        driver.findElement(By.cssSelector("[id='firstName']"))
                .sendKeys("username", Keys.TAB, "lastname1", Keys.TAB, "abc@gmail.com", Keys.TAB
                        , "30", Keys.TAB, "10000", Keys.TAB, "IT", Keys.ENTER);

        js.executeScript("window.scrollBy(0,200)");
        //eklendıgını  maıl yoluyla dogrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='abc@gmail.com']")).isDisplayed());
        //edıt ı locate et ve tıkla daha sonra maasını 15000 olarak guncelle
        driver.findElement(By.id("edit-record-4")).click();
        bekle(2);
        WebElement salary = driver.findElement(By.cssSelector("[id='salary']"));
        salary.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        salary.sendKeys("15000", Keys.ENTER);
        //Maasşın 15000 oldugunu dogrula
        WebElement salaryDogrulama = driver.findElement(By.xpath("//*[text()='15000']"));
        Assert.assertEquals("15000", salaryDogrulama.getText());
        //sılme tusunu locate et ve fırstname ı Alden olanı sıl
        driver.findElement(By.id("delete-record-2")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
