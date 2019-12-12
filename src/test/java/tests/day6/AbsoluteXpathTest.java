package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AbsoluteXpathTest {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
    driver.get("https://login1.nextbasecrm.com/?login=yes");
//click on login without username and password
//to invoke warning message
    driver.findElement(By.className("login-button")).click();
        BrowserUtils.wait(1);
        WebElement warningMessage=driver.findElement(By.xpath("https://login1.nextbasecrm.com/?login=yes"));
        System.out.println(warningMessage.getText());
    //to the end the test execution
        driver.quit();
    }

}
