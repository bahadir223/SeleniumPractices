package TechProPractices.day10_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C03_ReadExcel {
    // Ulkeler dosyasındaki tum dataları map'a alınız ve yazdırınız.

    @Test
    public void test01() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String, String> tumDatalar = new LinkedHashMap<>();
        for (int i = 0; i < workbook.getSheet("Sayfa1").getPhysicalNumberOfRows(); i++) {
            String ulkeIng = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + " ==> "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + " ==> "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            tumDatalar.put(ulkeIng, value + "\n");
        }
        System.out.println(tumDatalar);
    }
}
