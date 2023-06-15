package GrupCalismalarimiz.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class C02_MetroTurizm {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

    @Test
    public void test() {
        //1)   metroturizm sitesine git
        driver.get("https://www.metroturizm.com.tr/");
        //Sayfa acildiginda Gidiş Dönüş radio button'a tikla.
        driver.findElement(By.xpath("//*[@for='radio02']")).click();

        //nereden ddm ye gel 2 indexli olani sec

        WebElement ddm = driver.findElement(By.xpath("(//select)[1]"));
        Select select = new Select(ddm);
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());

        //nereye ddm den 14 indexli olani (ANKARA) yi sec
        WebElement ddmNereye = driver.findElement(By.xpath("(//select)[2]"));
        Select selectNereye = new Select(ddmNereye);
        selectNereye.selectByIndex(14);

        //gidis tarihine o günün tarihi sec
        driver.findElement(By.xpath("(//*[@class='fa fa-calendar'])[1]")).click();
        WebElement secilengidisTarih = driver.findElement(By.xpath("//*[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']"));
        secilengidisTarih.click();
        //System.out.println(driver.findElement(By.cssSelector("[id='inpSearchJourneyBusReturnDate']")).getText());
        /*
        int kacinciGun = LocalDate.now().getDayOfMonth();
        Assert.assertEquals(kacinciGun, Integer.parseInt(secilengidisTarih.getText()));
        System.out.println(Integer.parseInt(secilengidisTarih.getText()));
        */
        //donus tarihini o günün tarihi sec
        driver.findElement(By.xpath("(//*[@class='fa fa-calendar'])[2]")).click();
        WebElement secilenDonusTarih = driver.findElement(By.xpath("//*[@class=\"  ui-datepicker-today\"]"));
        secilenDonusTarih.click();
        //Assert.assertEquals(LocalDate.now(), secilenDonusTarih.getText());
        //System.out.println("bu hangisi = " + secilenDonusTarih.getText());

        //Listele'ye tıkla
        driver.findElement(By.id("btnIndexSearchJourneys")).click();

        //Gidiş seferleri için en üstteki 3 butonun çalıştığını kontrol et


        List<WebElement> secButonlari;
        for (int i = 0; i < 4; i++) {
            secButonlari = driver.findElements(By.xpath("//*[@class='btn btn-select ngSelectJourney']"));
            secButonlari.get(i).click();
            bekle(2);
            WebElement koltukSecYazisi = driver.findElement(By.xpath("(//*[text()='Lütfen bir koltuk seçiniz'])[1]"));
            //System.out.println((i + 1) + " .Sefer icin  " + koltukSecYazisi.getText());
            Assert.assertTrue(koltukSecYazisi.isDisplayed());
            bekle(2);
            //driver.findElement(By.xpath("(//*[text()='Kaldır'])[i+1]")).click();

        }

        List<WebElement> bosKoltuklar = driver.findElements(By.xpath("//*[@ng-if='!col.isSold']"));
        for (int i = 0; i < 1; i++) {
            bosKoltuklar = driver.findElements(By.xpath("//*[@ng-if='!col.isSold']"));
            bosKoltuklar.get(i).click();
            bekle(2);
            System.out.println("Gidiş Seçilen koltuk No = " + bosKoltuklar.get(i).getText());
        }
        bekle(2);
        /*
        //ekranda açılan alert penceresini kapat.
        driver.switchTo().alert().accept(); burayı yoruma aldık çünkü 1 yolcu için alert mesajı gelmeyecek.
        */
        //Dönüş seferi seç butonuna tıkla.
        driver.findElement(By.xpath("(//*[@id='btnChooseReturnJourney'])[1]")).click();

        //En üstteki sefere tıkla.
        driver.findElement(By.xpath("(//*[@class='btn btn-select ngSelectJourneyReturn'])[1]")).click();
        bekle(2);
        //1 tane boş koltuk seç
        /*
        //*[@ng-click="selectSeat(col,'true','true','false')"]  ==> Boş koltukların listinin tutulduğu locate
         */
        List<WebElement> bosKoltuklarim;
        for (int i = 0; i < 1; i++) {
            bosKoltuklarim = driver.findElements(By.xpath("//*[@ng-click=\"selectSeat(col,'true','true','false')\"]"));
            bosKoltuklarim.get(i).click();
            System.out.println("Dönüş Seçilen koltuk No = " + bosKoltuklarim.get(i).getText());
            bekle(2);

        }
        bekle(3);
        //ödeme sayfasına geç'e tıkla.
        driver.findElement(By.xpath("(//*[@id='btnDoPaymentPage'])[2]")).click();
        String kalkisTarihi = driver.findElement(By.cssSelector("span[id='spanBoarding']")).getText();
        System.out.println("buraya yaz!!!!"+kalkisTarihi);
        /*
        String[] arr = kalkisTarihi.split(" ");
        String[] arr2 =arr[0].split(".");
        Assert.assertEquals(Integer.parseInt(arr2[0]),LocalDate.now().getDayOfMonth());
        */
    }

    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
