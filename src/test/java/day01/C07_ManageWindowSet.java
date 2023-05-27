package day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ManageWindowSet {
    /*
      /*ODEV-->4
    Yeni bir Class olusturalim.C07_ManageWindowSet
    Amazon soyfasina gidelim. https://www.amazon.com/
    Sayfanin konumunu ve boyutlarini yazdirin
    Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
    Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
    8. Sayfayi kapatin
     */
    public static void main(String[] args) {
        System.setProperty("chromedriver", "src/Resources/drivers/chromedriver.exe");
        WebDriver myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //    Amazon soyfasina gidelim. https://www.amazon.com/
        myDriver.get("https://www.amazon.com/");

        //    Sayfanin konumunu ve boyutlarini yazdirin
        Point actualPosition= myDriver.manage().window().getPosition();
        Dimension actualSize = myDriver.manage().window().getSize();

        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        myDriver.manage().window().setPosition(new Point(400,400));
        myDriver.manage().window().setSize(new Dimension(1000,700));

        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin.

         myDriver.manage().window().getPosition();
         myDriver.manage().window().getSize();

        System.out.println("Degistirdigim poziyon : "+actualPosition);
        System.out.println("Degistirdigim Boyut:"+actualSize);

        if (actualPosition.equals(myDriver.manage().window().getPosition())){
            System.out.println("Test PASSED");

        }else System.out.println("Test FAILED");


    }

}
