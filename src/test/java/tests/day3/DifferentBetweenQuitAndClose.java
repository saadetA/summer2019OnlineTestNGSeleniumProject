package tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferentBetweenQuitAndClose {
    public static void main(String[] args)throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
    driver.get("http://practice.cybertekschool.com/open_new_tab");
Thread.sleep(4000);//will pause executoin
    //driver.close();//will close only one tab
driver.quit();//will close all tabs

    }



}
