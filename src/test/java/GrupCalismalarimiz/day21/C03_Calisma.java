package GrupCalismalarimiz.day21;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class C03_Calisma extends TestBase {

    @Test
    public void test01() {
        //https://fiddle.luigi-project.io/#/home/wc1
        driver.get("https://fiddle.luigi-project.io/#/home/wc1");
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        /*
        shadowRoot neden kullanıyoruz??? ben locate aldığım halde eğer hiç locate çıkmıyorsayani 0 geliyorsa
        diyeceğiz ki bu işte bir iş var. sonra sayfada almak istediğimiz yere gidip üst taraflarına çıkacağız ve
        shadowRoot ariyacağız. sonra shadowRoot ün bir üstünde veya iki üstünde id numarası gibi bir şey oalcak
        onu tagName ile alacağız ilk olarak. sonra .getShadowRoot() diyerek bir searchContext'e atiyorsun.
        sonra SearchContext arayüzünden oluşturduğun variable'i kullanarak almak istediğimiz locate' i .findElement
        diyerek cssSelector!!! ile........ normal alacağız. yine 0 çıkacak. sorun yok......
        Bu şekilde normalde locate ettiğimiz halde alamadığımız locate'leri alacağızz........
         */
        SearchContext shadowRoot = driver.findElement(By.tagName("luigi-wc-2f77632f6c6973742e6a73")).getShadowRoot();
        shadowRoot.findElement(By.cssSelector("[type='text']")).sendKeys("deneme");
        WebElement privacy = driver.findElement(By.xpath("(//*[@class='fd-link svelte-1i4l3qp'])[1]"));
        bekle(2);
        privacy.click();
    }
}
