package GrupCalismalarimiz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C24 {
    /*
    a.Verilen web sayfasına gidin.
    https://the-internet.herokuapp.com/checkboxes
    b.Checkbox1 ve checkbox2 elementlerini locate edin.
    c.Checkbox1 seçili değilse onay kutusunu tıklayın
    d.Checkbox2 seçili değilse onay kutusunu tıklayın
     */

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    /*
    b.Checkbox1 ve checkbox2 elementlerini locate edin.
    c.Checkbox1 seçili değilse onay kutusunu tıklayın
    d.Checkbox2 seçili değilse onay kutusunu tıklayın
    */
/*
    @Test
    public void test1() {
        driver.findElement();
    }*/
}
