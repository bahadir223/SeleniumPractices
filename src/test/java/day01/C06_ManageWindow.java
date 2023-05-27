package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ManageWindow {

    public static void main(String[] args) throws InterruptedException {
        /*
        /*ODEV-->3
    1.Yeni bir Class olusturalim.C06_ManageWindow
    2.Amazon soyfasina gidelim. https://www.amazon.com/
    3.Sayfanin konumunu ve boyutlarini yazdirin
    4.Sayfayi simge durumuna getirin
    5.simge durumunda 3 saniye bekleyip sayfayi maximize yapin
    6.Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
    7.Sayfayi fullscreen yapin
    8.Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
    9.Sayfayi kapatin
     */

        System.setProperty("chromedriver", "src/Resources/drivers/chromedriver.exe");
        WebDriver myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Amazon soyfasina gidelim. https://www.amazon.com/
        myDriver.navigate().to("https://www.amazon.com/");

        //3.Sayfanin konumunu ve boyutlarini yazdirin.
        System.out.println("Sayfanin Konumu: " + myDriver.manage().window().getPosition());
        System.out.println("Sayfanin Boyutu: " + myDriver.manage().window().getSize());

        //4.Sayfayi simge durumuna getirin
        myDriver.manage().window().minimize();

        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);

        //sayfayi maximize yapin
        myDriver.manage().window().maximize();

        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Sayfanin yeni konumu maximize: " + myDriver.manage().window().getPosition());
        System.out.println("Sayafanin yeni boyutlari maximize:  " + myDriver.manage().window().getSize());

        //Sayfayi fullscreen yapin
        myDriver.manage().window().fullscreen();

        //Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Sayfanin yeni konumu fullscreen : " + myDriver.manage().window().getPosition());
        System.out.println("Sayafanin yeni boyutlari fullscreen : " + myDriver.manage().window().getSize());

        //Sayfayi kapatin
        myDriver.close();


    }
}
