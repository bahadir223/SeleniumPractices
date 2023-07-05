package TechProPractices.day10_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {
    // Ulkeler dosyasındaki 0. satır index'in, 4. hücre index'ine yeni bir cell olusturalım.
    // olusturdugumuz hücreye "Nufus" yazdıralım.


    @Test
    public void test01() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(10);
        FileOutputStream fos = new FileOutputStream("src/test/java/resources/ulkeler.xlsx");
        //dataları bizim class'imizdan ulkeler dosyasına göndereceğiz.
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
}
