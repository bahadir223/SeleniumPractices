package GrupCalismalarimiz.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

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

        //gidis tarihine 15.06.2023 sec
        driver.findElement(By.xpath("(//*[@class='fa fa-calendar'])[1]")).click();
        driver.findElement(By.xpath("(//*[@data-month='5'])[4]")).click();


        //donus tarihini 18.06.2023 olarak isaretle
        driver.findElement(By.xpath("(//*[@class='fa fa-calendar'])[2]")).click();
        driver.findElement(By.xpath("(//*[@data-month='5'])[4]")).click();

        //Listele'ye tıkla
        driver.findElement(By.id("btnIndexSearchJourneys")).click();

    }
}
