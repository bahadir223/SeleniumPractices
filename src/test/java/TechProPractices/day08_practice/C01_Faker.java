package TechProPractices.day08_practice;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_Faker extends TestBase {
    // 'https://www.facebook.com' sayfasina gidiniz
    // yeni hesap olustur butonuna basin
    // isim kutusunu locate ediniz
    // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun


    @Test
    public void test01() {
        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")));
        //yeni hesap olustur butonuna basin
        driver.findElement(By.cssSelector("[class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // isim kutusunu locate ediniz
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        //geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker = new Faker();
        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun

        String email = faker.internet().emailAddress();

        Actions actions = new Actions(driver);

        actions.click(isim).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Mart").
                sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

    }
}
