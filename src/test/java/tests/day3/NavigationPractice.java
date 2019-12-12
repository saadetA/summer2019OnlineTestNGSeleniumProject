package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
driver.manage().window().maximize();//to maximize the browser

        driver.get("http://google.com");
//wait for 3 seconds
 //this is our custom method
 //since method is static we use class name to call the method
  //as a parameter   we provide number of seconds(time in seconds)
        BrowserUtils.wait(3);
        driver.navigate().to("http://amazon.com");
//navigate back to google
driver.navigate().back();
//move forward to the amazon again
    driver.navigate().forward();
   //to refresh webpage /website
    driver.navigate().refresh();
    //shutdown browser
    driver.quit();
    //what will happen if i will call driver again
    //we can not call driver again after quit
    //after close if you have more than one tab you can work on them but if we have only single one tab we cant do
    //anything after close
    }





}
