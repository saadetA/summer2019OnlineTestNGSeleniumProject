package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestforNameLocator {




    public static void main(String[] args) {
        //remember!
        //for Mac users: you don't need to use WebDriverManager for Safari
        //safari has embedded webdriver support.
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/new_tab");
        //if you want to do in one line, without creating webelemnt
//enter full name
        driver.findElement(By.name("full_name")).sendKeys("test User");
//enter email

driver.findElement(By.name("emai")).sendKeys("test_email@email.com");
        //click sign up
        driver.findElement(By.name("wooden_spoon")).click();
        //pause for 3 seconds
        BrowserUtils.wait(3);
driver.quit();
    }

}
