package TechProPractices.day10_practice;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
    //ülkeler dosyasındaki "Başkent (İngilizce) sütununu yazdırınız.

    @Test
    public void test01() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        for (int i = 0; i < workbook.getSheet("Sayfa1").getPhysicalNumberOfRows(); i++) {
            System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }

    }


}
