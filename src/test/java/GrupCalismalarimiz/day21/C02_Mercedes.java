package GrupCalismalarimiz.day21;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;


public class C02_Mercedes extends TestBase {
    //sayfaya gidin cerezi kapatin
    //https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE

       /*
        shadowRoot neden kullanıyoruz??? ben locate aldığım halde eğer hiç locate çıkmıyorsa yani 0 geliyorsa
        diyeceğiz ki bu işte bir iş var. sonra sayfada almak istediğimiz yere gidip üst taraflarına çıkacağız ve
        shadowRoot ariyacağız. sonra shadowRoot ün bir üstünde veya iki üstünde id numarası gibi bir şey oalcak
        onu tagName ile alacağız ilk olarak. sonra .getShadowRoot() diyerek bir searchContext'e atiyorsun.
        sonra SearchContext arayüzünden oluşturduğun variable'i kullanarak almak istediğimiz locate' i .findElement
        diyerek cssSelector!!! ile........ normal alacağız. yine 0 çıkacak. sorun yok......
        Bu şekilde normalde locate ettiğimiz halde alamadığımız locate'leri alacağızz........
         */


    @Test
    public void test01() {
        driver.get("https://www.mercedes-benz.com.tr/");
        SearchContext shadowRoot = driver.findElement(By.tagName("cmm-cookie-banner")).getShadowRoot();
        shadowRoot.findElement(By.cssSelector("[class='button button--accept-all wb-button hydrated']")).click();
        SearchContext shadowRoot2 = driver.findElement(By.tagName("owc-stage")).getShadowRoot();
        shadowRoot2.findElement(By.cssSelector("[target=\"_self\"]")).click();


    }


}
