package VytrackLaunch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class exercices {
    public static void main(String[] args)throws Throwable {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver() ;
        String url="https://www.amazon.com/b?node=14194728011&pf_rd_p=4938f3a1-84d9-48b5-a47d-eef6a7c8a49c&pf_rd_r=2X257HQKNYSYVSVFCSZ6";
    driver.get(url);
    Thread.sleep(3000);
    driver.close();


    }
}
