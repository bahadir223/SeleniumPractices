package KendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_DynamicElements {
    /*
    Selenium Dinamik Elementler nedir ve nasıl bulunur?
    Dinamik elementler, sayfayı her yenilediğinizde locate'leri değişen elementlerdir.
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void test01() {
        //açılan sitedeki Click Me button'una tıklayınız.
        //buradaki püf nokta şu; Click Me button'unun locate'ini id ile alırsak her defasında değiştiği
        //icin program hata verecektir, o yüzden dinamik şekilde almamız gerekir. Nasıl?
        WebElement clickMeButton = driver.findElement(By.xpath("(//div/button)[3]"));
        clickMeButton.click();

    }
}
