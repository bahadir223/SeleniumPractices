package GrupCalismalarimiz.day23;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_Task10_Odev extends TestBase {
    //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
    //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
    //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
    //Bütün Height bilgilerini yazdırınız
    //Otel uzunluklarının hepsini toplayınız
    //Bir method ile satır ve sutun bilgilerini çağıralım


    @Test
    public void test01() {
        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
        System.out.println(driver.findElement(By.xpath("(//table)[2]")).getText());
        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        List<WebElement> heightList = driver.findElements(By.xpath("(//table)[2]//td[3]"));
        int satirNumarasi = 0;
        for (int i = 0; i < heightList.size(); i++) {
            if (heightList.get(i).getText().equals("601m")) {
                satirNumarasi = i;
            }
        }
        System.out.println("************** ");
        System.out.println(driver.findElement(By.xpath("(//table)[2]//tr[" + (satirNumarasi + 1) + "]")).getText());

        System.out.println("************** ");
        //Bütün Height bilgilerini yazdırınız
        for (int i = 0; i < heightList.size(); i++) {
            System.out.println(heightList.get(i).getText());
        }

        //Otel uzunluklarının hepsini toplayınız
        int toplam = 0;
        for (int i = 0; i < heightList.size(); i++) {
            String height = heightList.get(i).getText().replaceAll("m", "");
            toplam = toplam + Integer.valueOf(height);
        }
        System.out.println("Otel uzunluklari toplami = " + toplam + " Metre");

        //Bir method ile satır ve sutun bilgilerini çağıralım

        satirSutunGetir(4, 4);

    }

    private void satirSutunGetir(int satir, int sutun) {
        WebElement veri = driver.findElement(By.xpath("(//table)[2]//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.print(satir + ".satir " + sutun + ".sütun verisi = " + veri.getText());


    }
}
