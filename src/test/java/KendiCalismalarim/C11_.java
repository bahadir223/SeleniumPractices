package KendiCalismalarim;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_ {
    /*
     //ODEV!!!!!!!!
    //Techproeducation sayfasına gidelim
    //Çıkan reklamı locate edip kapatalım
    //Arama bölümünde qa aratalım
    //Sayfa başlığının qa içerdiğini doğrulayalım
    //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
    //Carrer Opportunities In QA linkine tıklayalım
    //Başlığın Opportunities içerdiğini test edelim
    //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //Çıkan reklamı locate edip kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Arama bölümünde qa aratalım
        driver.findElement(By.id("elementor-search-form-9f26725")).sendKeys("qa", Keys.ENTER);

        //Sayfa başlığının qa içerdiğini doğrulayalım
        String actualTitle = driver.getTitle();
        String expectedTitle = ("qa");
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + actualTitle);
        }

        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        WebElement career = driver.findElement(By.xpath("(//*[@class='elementor-post__thumbnail__link'])[1]"));
        boolean gorunurMu = career.isDisplayed();
        System.out.println(gorunurMu);
        boolean erisilirMi = career.isEnabled();
        System.out.println(erisilirMi);


        //Carrer Opportunities In QA linkine tıklayalım
        career.click();

        //Başlığın Opportunities içerdiğini test edelim
        String baslik = driver.getTitle();
        System.out.println(baslik);

        String beklenenBaslik = "Opportunities";
        if (baslik.contains(beklenenBaslik)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + baslik);
        }

        //Tekrar anasayfaya dönelim
        driver.navigate().back();
        driver.navigate().back();

        //ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        String URL = driver.getCurrentUrl();
        String currentURL = "https://techproeducation.com/";
        if (URL.equals(currentURL)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + URL);
        }
    }

}

