package GrupCalismalarimiz.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    /*
    1	www.kitapyurdu.com sitesine git
    2	Arama motorunda bir ürün ara
    3	Arama sonuçlarının java ile ilgili olduğunu doğrula
    4	En üstteki ürünün başlığına tıkla
    5	Seçilen ürünün sayfasının açıldığını doğrula
    6	Sepete ekle butonuna tıkla
    7	Sepetinizde butonun göründüğünü doğrula
    8	Sağ üst köşedeki Sepetim butonuna tıkla
    9	Açılan menüdeki sepete git butonuna tıkla
    10	Sepetim sayfasının açıldığını doğrula
    11	Seçilen ürünün sepette olduğunu doğrula
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.kitapyurdu.com");
    }

    @Test
    public void test01() {
        //Arama motorunda Java ara,
        driver.findElement(By.xpath("//*[@id='search-input']")).sendKeys("Java", Keys.ENTER);
        //Arama sonuçlarının java ile ilgili olduğunu doğrula
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(sonucYazisi.getText().contains("Java"));
        bekle(3);
        //En üstteki ürünün başlığına tıkla
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='name'])[1]"));
        String expectedTitle = ilkUrun.getText();
        ilkUrun.click();
        bekle(3);
        String actualTitle = driver.getTitle();
        //Seçilen ürünün sayfasının açıldığını doğrula
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //Sepete ekle butonuna tıkla
        driver.findElement(By.xpath("//*[@id='button-cart']")).click();
        bekle(3);
        //Sepetinizde butonun göründüğünü doğrula
        WebElement sepetinizde = driver.findElement(By.xpath("(//*[text()='Sepetinizde'])[2]"));
        Assert.assertTrue(sepetinizde.isDisplayed());
        //Sağ üst köşedeki Sepetim butonuna tıkla
        WebElement sepetim = driver.findElement(By.xpath("(//h4)[1]"));
        sepetim.click();
        bekle(3);
        //Açılan menüdeki sepete git butonuna tıkla
        driver.findElement(By.xpath("//*[@id='js-cart']")).click();
        bekle(3);
        //Sepetim sayfasının açıldığını doğrula
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals("Sepetim", actualTitle2);
        //Seçilen ürünün sepette olduğunu doğrula
        WebElement secilenUrun = driver.findElement(By.xpath("//*[text()='Yeni Başlayanlar için Java (Eğitim Videolu) ']"));
        Assert.assertTrue(secilenUrun.isDisplayed());
        // Sepetteki ürünü seç
        driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
        bekle(2);
        // Sepetteki ürünü silmek için "x" butonuna tıkla.
        driver.findElement(By.cssSelector("i[title='Kaldır']")).click();
        bekle(2);
        // Sepetteki ürünün silindiğini doğrula.
        WebElement sepCikariliyor = driver.findElement(By.xpath("//*[@id='swal2-title']"));
        Assert.assertTrue(sepCikariliyor.isDisplayed());

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
