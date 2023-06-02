package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C15 {
    /*
1. Tarayıcıyı başlatın
2. 'http://automationexercise.com' URL'sine gidin
3. Ana sayfanın başarıyla göründüğünü doğrulayın
4. 'Kaydol / Giriş Yap' düğmesine tıklayın
5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
6. Adı ve e-posta adresini girin
7. 'Kaydol' düğmesini tıklayın
8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
9.  Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
10. 'Bültenimize kaydolun!' onay kutusunu seçin.
11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
13. 'Hesap Oluştur düğmesini' tıklayın
14. 'HESAP OLUŞTURULDU!' görünür
15. 'Devam Et' düğmesini tıklayın
16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
17. 'Hesabı Sil' düğmesini tıklayın
18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
 */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //Ana sayfanın başarıyla göründüğünü doğrulayın
        String URL = driver.getCurrentUrl();
        String beklenenURL = "https://automationexercise.com/";
        if (URL.equals(beklenenURL)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + URL);
        }

        //'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        boolean newUserSignupgorunurMu = driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();
        System.out.println("Yeni kullanıcı kaydını doğrulayın görünüyor mu ? " + newUserSignupgorunurMu);

        //Adı ve e-posta adresini girin
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("bahadir");
        driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("bahadirrr@gmail.com");

        //'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Signup']")).click();

        //'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        boolean hesapbilgileriGorunurMu = driver.findElement(By.xpath("(//h2)[1]")).isDisplayed();
        System.out.println("Hesap bilgilerini girin görünüyor mu ? " + hesapbilgileriGorunurMu);

        //Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        WebElement unvan = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        unvan.click();
        unvan.sendKeys(Keys.TAB, "BAHADIR GUNUVAR", Keys.TAB, "BAHADIR123", Keys.TAB, "9",
                Keys.TAB, "January", Keys.TAB, "2000");

        //'Bültenimize kaydolun!' onay kutusunu seçin.
        //'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();
        driver.findElement(By.xpath("//*[@id='optin']")).click();

        //Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        WebElement firstName = driver.findElement(By.xpath("//*[@id='first_name']"));
        firstName.sendKeys("yusuf ", Keys.TAB, " murat", Keys.TAB, "techpro", Keys.TAB, "Yenimahalle",
                Keys.TAB, "United States", Keys.TAB, "USA", Keys.TAB, "Florida", Keys.TAB, "Washington",
                Keys.TAB, "007", Keys.TAB, "911", Keys.TAB, Keys.ENTER);

        driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

        //'HESAP OLUŞTURULDU!' görünür
        System.out.println("Hesap Oluşturuldu Görünüyor mu?" + driver.findElement(By.xpath("//h2[1]")).isDisplayed());

        //'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        System.out.println("Kullanıcı adı olarak oturum açıldı mı" + driver.findElement(By.xpath("//*[text()='BAHADIR GUNUVAR']")).isDisplayed());

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        //18. 'HESAP SİLİNDİ!' görünür
        System.out.println("Hesap Silindi mi? " + driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());

        //ve 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Continue']")).click();



        driver.close();

    }

}
