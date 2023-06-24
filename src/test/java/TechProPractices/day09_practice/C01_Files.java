package TechProPractices.day09_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {

    @Test
    public void test01() {
        // masaustunde bir text dosyası olusturunuz


        // masaustunde text dosyasının olup olmadıgını test ediniz

        //     ""C:\Users\bahad\OneDrive\Masaüstü\örnek.txt""

        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Desktop\\Batch151.txt")));


        // dinamik hale getirelim

        //     "C:\Users\bahad              \Desktop\Batch151.txt"

        String farkliKisim = System.getProperty("user.home");
        System.out.println("Her bilgisayarda farklı olan , user.home => " + farkliKisim);
        String ortakKisim = "\\OneDrive\\Masaüstü\\örnek.txt";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
