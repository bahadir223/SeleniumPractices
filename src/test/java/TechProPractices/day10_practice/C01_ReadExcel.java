package TechProPractices.day10_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    // Ulkeler dosyasındaki 3.satırdaki indexin, 3. sutunundaki indexinin
    // "Cezayir" oldugunu test eden method olusturunuz.


    @Test
    public void test01() throws IOException {
        banaDataGetir(3, 3);
    }

    public void banaDataGetir(int satir, int sutun) throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String satirSutun = workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun).toString();
        Assert.assertEquals("Cezayir", satirSutun);
    }
}
