package GrupCalismalarimiz.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C27 {
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    //Before methodunda http://www.google.com adresine gidin
    //Üç farklı test methodu ile;
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    //After method'u ile başlıkları yazdırınız
    //AfterClass ile browser'ı kapatınız


    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com ");
    }

    @Test
    public void test01() {
        driver.findElement(By.id("APjFqb")).sendKeys("The God Father", Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonuc = sonucYazisi.getText();
        String[] arr = sonuc.split(" ");
        System.out.println("The God Father Sonuc Sayisi = " + arr[1]);


    }

    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.id("APjFqb")).sendKeys("Lord of the Rings", Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().refresh();
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonuc = sonucYazisi.getText();
        String[] arr = sonuc.split(" ");
        System.out.println("Lord of the Rings Sonuc Sayisi = " + arr[1]);
    }

    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.id("APjFqb")).sendKeys("Kill Bill", Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().refresh();
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonuc = sonucYazisi.getText();
        String[] arr = sonuc.split(" ");
        System.out.println("Kill Bill Sonuc Sayisi = " + arr[1]);

    }

    @After
    public void tearDown() throws Exception {
        List<WebElement> basliklar = driver.findElements(By.xpath("//h1|//h2|//h3|//h4|//h5|//h6"));
        for (int i = 0; i < basliklar.size(); i++) {
            basliklar = driver.findElements(By.xpath("//h1|//h2|//h3|//h4|//h5|//h6"));
            System.out.println(basliklar.get(i).getText());
        }
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
