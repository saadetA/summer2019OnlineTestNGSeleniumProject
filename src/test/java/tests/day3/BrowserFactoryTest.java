package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BrowserFactoryTest {
    public static void main(String[] args) {
//now we can get webDriver like this
        //getDriver() method will return webDriver object
        //and we can use reference variable to work with that object
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        //how we can print a source code of the page?
        System.out.println(driver.getPageSource());
        //to finish test execution.
        driver.quit();


    }




}
