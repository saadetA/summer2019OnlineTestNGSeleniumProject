package VytrackLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class LoginLounch2 {

    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
                                       //getDriver methodu statik oldugu icin class ismiyle cagiryrz
    //go to website
        driver.get("https://qa2.vytrack.com/user/login");
       //insert username
        WebElement username=driver.findElement(By.name("_username"));
        username.sendKeys("storeManager79");
    //insert password
        WebElement password=driver.findElement(By.name("_password"));
          password.sendKeys("UserUser123");
   //to click login
    WebElement clickLogin=driver.findElement(By.id("_submit"));
        clickLogin.click();
        WebElement username2=driver.findElement(By.name("_username"));
        username2.sendKeys("Saadet");
        WebElement password2=driver.findElement(By.name("_password"));
        password2.sendKeys("4567");
     // wrong error msj
        WebElement ErrorMessage=driver.findElement(By.id("login-form"));




    }

}
