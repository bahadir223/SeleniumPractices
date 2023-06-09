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

public class C29 {
       /*
    ödev 2:
    ●https://www.amazon.com/ adresine gidin.
    -Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    oldugunu test edin
    -Test 2
    1.Kategori menusunden Books secenegini secin
    2.Arama kutusuna Java yazin ve aratin
    3.Bulunan sonuc sayisini yazdirin
    4.Sonucun Java kelimesini icerdigini test edin
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);

    }

    WebElement kategori;
    Select select;

    @Test
    public void test01() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        kategori = driver.findElement(By.xpath("//*[@name='url']"));
        select = new Select(kategori);
        int kategoriBoyutu = select.getOptions().size();
        Assert.assertNotEquals(45, kategoriBoyutu);

    }

    @Test
    public void test02() throws InterruptedException {
        kategori = driver.findElement(By.xpath("//*[@name='url']"));
        select = new Select(kategori);

        //Kategori menusunden Books secenegini secin
        select.selectByIndex(5);
        //Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String sonucYazi = sonucYazisi.getText();
        String[] arr = sonucYazi.split(" ");
        System.out.println("Sonuc = " + arr[3]);
        //Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonucYazi.contains("Java"));

    }
}
