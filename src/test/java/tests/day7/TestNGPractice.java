package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {




   @Test
    public void test(){
      //to verify that expected result equals actual result is the same
       //if no it will throw exeption and stop the program
//also you will see in the console what was expected and what was actually
  //we dont need to write expected or actual Assret give us

       Assert.assertEquals("appl","apple"); //int sectigim icin rakm yazdim


   }
@Test(description = "verifying title of the practice website")
   public void verifyTitle(){
    WebDriver driver= BrowserFactory.getDriver("chrome");
driver.get("http://practice.cybertekschool.com/");
    String expectedTitle = "Practice";
    String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle, "Title is wrong");
    driver.quit();

}
@Test(description = "verify that heading is displayed")
public void vrifyHeadingisDisplay(){
    WebDriver driver = BrowserFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/");
    //if there is no element with this locator, we will get NoSuchElementException
    //and our program will stop on the findElement line
    WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
    //to make sure that element is visible to user
    //because element can be present, but not visible
    //we need to make sure element is visible
    Assert.assertTrue(heading.isDisplayed());
    //Element is not visible -- will be printed it element is there, but not visible
    //assertTrue - method that checks if something is true
    //if it's false, you will get exception
    //.isDisplayed() return true or false
    //if it returns true - that means element is visible
    //if this method returns false - element is not visible

    driver.quit();
}



}
