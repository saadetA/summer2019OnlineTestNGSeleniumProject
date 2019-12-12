package tests.Homewrk3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurationReader;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public abstract class VytruckSyncrnz_checkbox {
private WebDriverWait wait;
@BeforeMethod
public void setup(){
  String url= ConfigurationReader.getProperty("url");
    Driver.get().get(url);
wait=new WebDriverWait(Driver.get(),15);
    Driver.get().manage().window().maximize();
    Driver.get().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("user_name"));
    Driver.get().findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    Driver.get().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
    wait.until(ExpectedConditions.visibilityOf(loaderMask));
    wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    //BrowserUtils.wait(2);
    WebElement activitiesElement = Driver.get().findElement(By.linkText("Activities"));
    wait.until(ExpectedConditions.visibilityOf(activitiesElement));
    wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
    activitiesElement.click();
    WebElement calendarEventsElement = Driver.get().findElement(By.linkText("Calendar Events"));
    wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
    wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
    calendarEventsElement.click();

    wait.until(ExpectedConditions.invisibilityOf(loaderMask));

}
//@Test(description = "verify that page title option is displayed")
  //  public void test1(){
  //  WebElement optionsButton=Driver.get().findElement(By.cssSelector("[class='btn btn-link dropdown-toggle']"));
   // Assert.assertTrue(optionsButton.isDisplayed());
//}







@AfterMethod
    public void teardown(){
        Driver.close();
    }

}
