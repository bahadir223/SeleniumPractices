package GrupCalismalarimiz.day22;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class C01_HesapMakinesi extends TestBase {
    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim

    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım

    //Sonucu konsola yazdırıp Sonucun doğrulamasını yapalım


    @Test
    public void test01() {

            //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

            //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
            Random random = new Random();

            int sayi1 = 0;
            int sayi2 = 0;

            for (int i = 0; i < 2; i++) {
                int sayi = random.nextInt(10);
                if (i == 0) {
                    if (sayi == 0) {
                        sayi = random.nextInt(9) + 1;
                        driver.findElement(By.xpath("//*[text()=" + sayi + "]")).click();
                    }
                    sayi1 = sayi;
                }
                driver.findElement(By.xpath("//*[text()=" + sayi + "]")).click();
                sayi2 = sayi;
            }
            String ilkSayi = sayi1 + "" + sayi2;
            double ilkSonSayi = Integer.parseInt(ilkSayi);
            System.out.println(ilkSonSayi);

            //operatore bas
            List<WebElement> operatorler = driver.findElements(By.cssSelector("[class='operator btn btn-outline-success']"));

            int operatorSize = random.nextInt(operatorler.size());
            WebElement operator = operatorler.get(operatorSize);
            operator.click();

            int sayi3 = 0;
            int sayi4 = 0;

            for (int i = 0; i < 2; i++) {
                int sayi = random.nextInt(10);
                if (i == 0) {
                    if (sayi == 0) {
                        sayi = random.nextInt(9) + 1;
                        driver.findElement(By.xpath("//*[text()=" + sayi + "]")).click();
                    }
                    sayi3 = sayi;
                }
                driver.findElement(By.xpath("//*[text()=" + sayi + "]")).click();
                sayi4 = sayi;
            }
            String ikinciSayi = sayi3 + "" + sayi4;
            double ikinciSonSayi = Integer.parseInt(ikinciSayi);
            System.out.println(ikinciSonSayi);

            //çıkan sonucu bul
            double expectedResult = 0;
            System.out.println("opr : "+operator.getText());
            switch (operator.getText()) {
                case "+":
                    expectedResult = ilkSonSayi + ikinciSonSayi;
                    break;
                case "-":
                    expectedResult = ilkSonSayi - ikinciSonSayi;
                    break;
                case "x":
                    expectedResult = ilkSonSayi * ikinciSonSayi;
                    break;
                case "÷":
                    expectedResult = ilkSonSayi / ikinciSonSayi;
                    break;
                default:
                    System.out.println("Gecersiz operator kullandiniz.");
                    break;
            }

            System.out.println("expectedResult : " + expectedResult);

            //eşittire bas
            driver.findElement(By.xpath("//*[text()='=']")).click();


            //Sonucu konsola yazdırıp

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[id='spinner']")));
            WebElement sonuc = driver.findElement(By.cssSelector("[class='screen']"));

            double actualResult = Double.valueOf(sonuc.getText());
            System.out.println( "actualResult : " +actualResult);


            //Sonucun doğrulamasını yapalım
            Assert.assertTrue(actualResult==expectedResult);

    }
}
