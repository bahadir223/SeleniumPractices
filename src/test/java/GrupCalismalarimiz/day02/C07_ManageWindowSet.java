package GrupCalismalarimiz.day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Amazon Sayfasinin Konumu : " + driver.manage().window().getPosition());
        System.out.println("Amazon Sayfasinin Boyutlari : " + driver.manage().window().getSize());

        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(148, 148));
        driver.manage().window().setSize(new Dimension(800, 600));
        Thread.sleep(3000);

        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        Dimension newSize = driver.manage().window().getSize();
        Point newPosition = driver.manage().window().getPosition();

        if (newPosition.getX() == 148 && newPosition.getY() == 148) {
            System.out.println("KONUM TESTI PASSED");
        } else System.out.println("KONUM TESTI FAIL" + newPosition);

        if (newSize.getHeight() == 600 & newSize.getWidth() == 800) {
            System.out.println("BOYUT TESTI PASSED");
        } else {
            System.out.println("BOYUT TESTI FAIL" + newSize);
        }
        //8. Sayfayi kapatin
        driver.close();
    }
}



