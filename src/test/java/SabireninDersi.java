import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SabireninDersi {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://www.expedia.com");
        WebDriverWait wait=new WebDriverWait(driver, 20);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Shoes", Keys.ENTER);
        //Thread.sleep(2000);
    }
}
