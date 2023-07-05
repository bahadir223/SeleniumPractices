package KendiCalismalarim.day04;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {
    //Capitals.xlsx ' deki 1. Satır ve 1. sütun daki bilgileri yazdıralım

    @Test
    public void test01() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String birSatirBirSutun = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println("birSatirBirSutun = " + birSatirBirSutun);
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        String birSatirIkiSutun = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
        System.out.println("birSatirIkiSutun = " + birSatirIkiSutun);
        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String ucSatirBirSutun = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("ucSatirBirSutun = " + ucSatirBirSutun);
        Assert.assertEquals("France", ucSatirBirSutun);
        //Kullanılan satır sayısın bulun
        int kullanilanSatirSay = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("kullanilanSatirSay = " + kullanilanSatirSay);
        //Sayfadaki satır sayısını yazdırınız
        int sayfadakiSatirSay = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("sayfadakiSatirSay = " + sayfadakiSatirSay);

    }
}
