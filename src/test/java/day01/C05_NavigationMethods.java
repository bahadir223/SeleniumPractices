package day01;


public class C05_NavigationMethods {

    /*
      Yeni bir Class olusturalim.C05_NavigationMethods
    Youtube ana sayfasina gidelim . https://www.youtube.com/
    Amazon soyfasina gidelim. https://www.amazon.com/
    Tekrar YouTube’sayfasina donelim
    Yeniden Amazon sayfasina gidelim
    Sayfayi Refresh(yenile) yapalim
    Sayfayi kapatalim / Tum sayfalari kapatalim
     */
    public static void main(String[] args) {
        System.setProperty("chromedriver", "src/Resources/drivers/chromedriver.exe");

        //Youtube ana sayfasina gidelim . https://www.youtube.com/
        C04_Utils.myDriver.get("https://www.youtube.com/");

        //Amazon soyfasina gidelim. https://www.amazon.com/
        C04_Utils.myDriver.get("https://www.amazon.com/");

        //Tekrar YouTube’sayfasina donelim
        C04_Utils.myDriver.navigate().back();

        //Yeniden Amazon sayfasina gidelim
        C04_Utils.myDriver.navigate().forward();

        //Sayfayi Refresh(yenile) yapalim
        C04_Utils.myDriver.navigate().refresh();

        //Tum sayfalari kapatalim
        C04_Utils.myDriver.quit();


    }
}
