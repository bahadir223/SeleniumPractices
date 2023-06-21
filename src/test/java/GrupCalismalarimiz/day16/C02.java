package GrupCalismalarimiz.day16;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02 extends TestBase {

    @Test
    public void test01() {
        // https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver ");

        //      Change Text to Seleniun Driver butonuna basalım
        driver.findElement(By.id("populate-text")).click();

        WebElement seleniumYazisi = driver.findElement(By.cssSelector("[id='h2']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(seleniumYazisi));

        //Selenium Webdriver yazısının görünür olduğunu doğrulayalım.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Selenium Webdriver']")).isDisplayed());
    }

    @Test
    public void test02() {

        // https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver ");

        //Display button after 10 seconds buttonuna basın
        driver.findElement(By.id("display-other-button")).click();

        WebElement enableButton = driver.findElement(By.xpath("(//button)[6]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(enableButton));

        //Enabled butonunun görnür olduğunu doğrulayalım.
        Assert.assertTrue(enableButton.isDisplayed());

        //Enabled butona tıklayıp butonun gittiğini doğrulayalım.
        enableButton.click();
        wait.until(ExpectedConditions.invisibilityOf(enableButton));
        Assert.assertFalse(enableButton.isDisplayed());

    }

    @Test
    public void test03() {
        // https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver ");

        //Enable button after 10 seconds butonuna basalım.
        driver.findElement(By.id("enable-button")).click();

        //Button erişilebilirliğini kontrol edelim.
        WebElement button = driver.findElement(By.cssSelector("[id='disable']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        Assert.assertTrue(button.isEnabled());
    }

    @Test
    public void test04() {

        // https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver ");

        //Check checkbox after 10 seconds butonuna basalım.
        driver.findElement(By.xpath("(//button)[9]")).click();

        WebElement check = driver.findElement(By.cssSelector("[id='ch']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeSelected(check));

        Assert.assertTrue(check.isSelected());


    }
}
