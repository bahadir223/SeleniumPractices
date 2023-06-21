package TechProPractices.day07_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_ActionsDragAndDrop extends TestBase {
    // https://demoqa.com/droppable adresine gidiniz
    // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
    // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz


    @Test
    public void test01() {
        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");
        bekle(3);
        //'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        WebElement drag = driver.findElement(By.cssSelector("[id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop);

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        WebElement yazi = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertEquals("Dropped!", yazi.getText());
    }
}
