package GrupCalismalarimiz.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_Odev {
    /*
        ODEV1
            1.satirdaki 2.hucreye gidelim ve yazdiralim
            1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim
            2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
            Satir sayisini bulalim
            Fiziki olarak kullanilan satir sayisini bulun
            Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
         */

    @Test
    public void test01() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workBook = WorkbookFactory.create(fis);

        //1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workBook.getSheet("Sayfa1").getRow(0).getCell(1).toString());
        //1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim
        String birinciSatirIkinciHucre = workBook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("birinciSatirIkinciHucre = " + birinciSatirIkinciHucre);
        //2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
        String ikinciSatirDorduncuHucre = workBook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals("Kabil", ikinciSatirDorduncuHucre);
        //Satir sayisini bulalim
        int satirSayisi = workBook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("satirSayisi = " + satirSayisi);
        //Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatirSay = workBook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("kullanilanSatirSay = " + kullanilanSatirSay);
        //Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String, String> isimBaskent =new LinkedHashMap<>();
        for (int i = 0; i < workBook.getSheet("Sayfa1").getLastRowNum()+1; i++) {
            if (workBook.getSheet("Sayfa1").getRow(i) != null) { //--> Satirlar bos degilse
                String ulke = workBook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
                String sehir = workBook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
                isimBaskent.put(ulke, sehir + "\n");
            }
        }
        System.out.println(isimBaskent);
    }
}
