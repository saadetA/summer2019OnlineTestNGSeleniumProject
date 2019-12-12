package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {
//we will create a method that will return webdriver object
//this method will take one parameter -String browser
//based on the value of the browser parameter
//method will return corresponded webDriver object
//if browser=chrome   then return chromeDriver object
public static WebDriver getDriver(String browser) {
    if (browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
    return null;
}

}
