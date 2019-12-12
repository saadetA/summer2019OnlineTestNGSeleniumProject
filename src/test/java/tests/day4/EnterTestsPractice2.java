package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTestsPractice2 {

    public static void main(String[] args) {

       //test 3 homewrk
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox =driver.findElement(By.name("email"));
        inputBox.sendKeys("random@email.com", Keys.ENTER);
       WebElement confirmationMessage=driver.findElement(By.name("confirmation message"));
   String expectedMessage="Your e-mail's been send";
        //to get the text from element
        String actualMessage = confirmationMessage.getText();
        if(expectedMessage.equals(actualMessage)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }
       // BrowserUtils.wait(2);
        driver.close();
    }



}
