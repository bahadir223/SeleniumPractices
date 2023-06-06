package GrupCalismalarimiz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C13 {
    /*
     /*ODEV!!!!!
        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        // Add Element butonuna 100 defa basınız
        // 100 defa basıldığını test ediniz
        // 90 defa delete butonuna basınız
        // 90 defa basıldığını doğrulayınız
        // Sayfayı kapatınız
         */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add Element']"));
        for (int i = 0; i < 100; i++) {
            addButton.click();
        }

        /*
        driver.findElement  ==>  tek bir elementi hedeflemek için kullanılır.
        driver.findElements ==>  verilen bir locator ifadesine uygun olarak, sayfa üzerindeki tüm eşleşen elementleri bulur
                                 ve bu elementleri bir liste olarak döndürür.
         */

        // Add Element butonuna 100 defa basıldığını test ediniz
        List<WebElement> deleteButton = driver.findElements(By.xpath("//*[text()='Delete']"));//yani text'i delete olanları bir liste attık
        int deleteButtonSayisi = deleteButton.size();
        System.out.println(deleteButtonSayisi);

        if (deleteButtonSayisi == 100) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + deleteButtonSayisi);
        }
        Thread.sleep(2000);

        // 90 defa delete butonuna basınız
        for (int i = 0; i < 90; i++) {
            deleteButton.get(i).click();
        }
        Thread.sleep(2000);

        // 90 defa delete butonuna basıldığını doğrulayınız
        int kalanDeleteButtonSayisi = driver.findElements(By.xpath("//*[text()='Delete']")).size();
        if (kalanDeleteButtonSayisi == 10) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + deleteButtonSayisi);
        }

        driver.close();
    }
}

