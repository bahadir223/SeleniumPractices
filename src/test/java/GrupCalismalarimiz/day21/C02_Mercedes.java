package GrupCalismalarimiz.day21;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class C02_Mercedes extends TestBase {
    //sayfaya gidin cerezi kapatin
    //https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE


    @Test
    public void test01() {
       // driver.get("https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE");
       // bekle(3);
       // WebElement element = driver.findElement(By.xpath("//cmm-cookie-banner[@class='hydrated']"));
       // WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", element);
       // WebElement targetElement = shadowRoot.findElement(By.tagName("button"));
       // targetElement.click();

        // https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE sayfasına git çerezleri kabul et
        driver.get("https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE");

        SearchContext searchContext = driver.findElement(By.xpath("//cmm-cookie-banner[@class='hydrated']")).getShadowRoot();
        searchContext.findElement(By.className("button")).click();

    }

    /*
           //https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE
       //driver.get("https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE");
       //bekle(2);
       //driver.findElement(By.className("button button--accept-all wb-button hydrated")).click();

        // https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE sayfasına git çerezleri kabul et
       driver.get("https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE");

       //SearchContext searchContext = driver.findElement(By.xpath("//cmm-cookie-banner[@class='hydrated']")).getShadowRoot();
       //searchContext.findElement(By.className("button")).click();

        WebElement element = driver.findElement(By.xpath("//cmm-cookie-banner[@class='hydrated']"));
        WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", element);
        WebElement targetElement = shadowRoot.findElement(By.tagName("button"));
     */
}
