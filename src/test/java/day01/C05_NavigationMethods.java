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
        Utils.myDriver.get("https://www.youtube.com/");

        //Amazon soyfasina gidelim. https://www.amazon.com/
        Utils.myDriver.get("https://www.amazon.com/");

        //Tekrar YouTube’sayfasina donelim
        Utils.myDriver.navigate().back();

        //Yeniden Amazon sayfasina gidelim
        Utils.myDriver.navigate().forward();

        //Sayfayi Refresh(yenile) yapalim
        Utils.myDriver.navigate().refresh();

        //Tum sayfalari kapatalim
        Utils.myDriver.quit();


    }
}
