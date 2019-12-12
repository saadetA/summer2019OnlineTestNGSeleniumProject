package tests.homwrk4;


import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.Driver;

public class CalenderEvent extends CalenderEventsHW{
private WebDriverWait wait=new WebDriverWait(Driver.get(),15);
   @Test(description = "Verify that view ,delete and options are avaliable for each calender event")
//test 1 33 te fail oluyor //iki pass //uc pass
   public void test1() {
       WebElement  calenderevents=Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
       wait.until(ExpectedConditions.visibilityOf(calenderevents));
       wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
       calenderevents.click();

       int row=13;
        int column=9;
       WebElement HoverPoint = Driver.get().findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]"));

       Actions action=new Actions(Driver.get());
action.moveToElement(HoverPoint).perform();

       String[] options = { "a[href='#']", "a[href='/calendar/event/update/184']","a[href='/calendar/event/view/184']"};
       WebElement option;
       for (String each : options) {
           option = Driver.get().findElement(By.cssSelector(each));
           Assert.assertTrue(option.isDisplayed());
       }

   }

@Test(description = "Verify that title column still displayed")
public void test2(){
    WebElement  calenderevents=Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
    wait.until(ExpectedConditions.visibilityOf(calenderevents));
    wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
    calenderevents.click();
    Driver.get().findElement(By.cssSelector("[class='fa-cog hide-text']")).click();

    WebElement name;
    for (int i = 2; i <= 7; i++) {
        name = Driver.get().findElement(By.xpath("//tr[" + i + "]//td[3]//input"));
        name.click();
        Assert.assertFalse(name.isSelected(), "Option is still selected");
    }

    WebElement titleColumn = Driver.get().findElement(By.xpath("//span[@class='grid-header-cell__label'][contains(text(),'Title')][1]"));
    Assert.assertTrue(titleColumn.isDisplayed(), "Title column is not displayed");

}

@Test(description = "Verify that 'Save and Close','Save and New', and 'Save' options are available")

public void Test3(){

 WebElement  calenderevents=Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
    wait.until(ExpectedConditions.visibilityOf(calenderevents));
      wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
       calenderevents.click();
      Driver.get().findElement(By.cssSelector("[title='Create Calendar event']")).click();
WebElement loadmask=Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
   wait.until(ExpectedConditions.invisibilityOf(loadmask));
Driver.get().findElement(By.cssSelector("[class='btn-success btn dropdown-toggle']")).click();

    WebElement option;
    for(int i = 1;i<=3;i++) {
        option = Driver.get().findElement(By.xpath("//li[1]//button[contains(text(),'Save')]"));
        Assert.assertTrue(option.isDisplayed(), "Option "+i+" is not Display");
        Assert.assertTrue(option.isEnabled(), "Option "+i+" is not Enabled");
    }


   }
@Test(description =  "Verify that 'All Calendar Events' page subtitle is displayed")
public void test4(){
    WebElement  calenderevents=Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
    wait.until(ExpectedConditions.visibilityOf(calenderevents));
    wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
    calenderevents.click();
    Driver.get().findElement(By.cssSelector("[title='Create Calendar event']")).click();
    WebElement loadmask=Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
    wait.until(ExpectedConditions.invisibilityOf(loadmask));
    Driver.get().findElement(By.linkText("Cancel")).click();
    WebElement subTitle = Driver.get().findElement(By.cssSelector("[class='oro-subtitle']"));
    Assert.assertTrue(subTitle.isDisplayed(),"Subtitle is not displayed");
   }
@Test(description = "\"Verify that difference between end and start time is exactly 1 hour\")")
public void test5(){
    WebElement  calenderevents=Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
    wait.until(ExpectedConditions.visibilityOf(calenderevents));
    wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
    calenderevents.click();
    Driver.get().findElement(By.cssSelector("[title='Create Calendar event']")).click();
    WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
    wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    WebElement StartTime = Driver.get().findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
    StartTime.click();
    Driver.get().findElement(By.xpath("//li[contains(text(),'12:00 AM')]")).click();
    Driver.get().findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']")).click();
    WebElement EndTime = Driver.get().findElement(By.cssSelector("[class='ui-timepicker-am ui-timepicker-selected']:nth-of-type(3)"));
    String actuslEndTime = EndTime.getText();
    String expectedEndTime = "1:00 AM";
    Assert.assertTrue(EndTime.isDisplayed());
    Assert.assertEquals(actuslEndTime,expectedEndTime, "Start time and end time are not 1 hour apart");
   }
@Test(description = "\"Verify that end time is equals to 10:00pm when 9:00 PM start time is selected\")")
public void test6(){
    WebElement  calenderevents=Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
    wait.until(ExpectedConditions.visibilityOf(calenderevents));
    wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
    calenderevents.click();
    Driver.get().findElement(By.cssSelector("[title='Create Calendar event']")).click();
    WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
    wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    WebElement StartTime = Driver.get().findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
    StartTime.click();
    Driver.get().findElement(By.xpath("//li[contains(text(),'9:00 PM')]")).click();
    Driver.get().findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']")).click();
    WebElement EndTime = Driver.get().findElement(By.cssSelector("[class='ui-timepicker-pm ui-timepicker-selected']:nth-of-type(3)"));
    String actuslEndTime = EndTime.getText();
    String expectedEndTime = "10:00 PM";
    Assert.assertTrue(EndTime.isDisplayed());
    Assert.assertEquals(actuslEndTime,expectedEndTime, "Start time and end time are not 1 hour apart");

}


@Test(description = "Verify taht 'All-Day Event' is selected and start/end time slots are not displayed")

public void test7() {
    WebElement calenderevents = Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
    wait.until(ExpectedConditions.visibilityOf(calenderevents));
    wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
    calenderevents.click();
    Driver.get().findElement(By.cssSelector("[title='Create Calendar event']")).click();

    WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
    wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    WebElement allDaybutton = Driver.get().findElement(By.cssSelector("[data-name='field__all-day']"));
    allDaybutton.click();
    BrowserUtils.wait(2);
    Assert.assertTrue(allDaybutton.isSelected(), "All day event button is not selected");

    WebElement StartTime = Driver.get().findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
    WebElement Endtime = Driver.get().findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']"));
    Assert.assertFalse(StartTime.isDisplayed(), " Start time is displayed");
    Assert.assertFalse(Endtime.isDisplayed(), "End time is displayed");

}

 @Test(description = "verify tat repeat checkbox selected ,verify that daily is selected by default foolw optns are avaliable")

public void test8(){
     WebElement calenderevents = Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
     wait.until(ExpectedConditions.visibilityOf(calenderevents));
     wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
     calenderevents.click();
     Driver.get().findElement(By.cssSelector("[title='Create Calendar event']")).click();

     WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
     wait.until(ExpectedConditions.invisibilityOf(loaderMask));
 WebElement repeatbutton=Driver.get().findElement(By.cssSelector("[data-name='recurrence-repeat']"));
repeatbutton.click();
Assert.assertTrue(repeatbutton.isSelected());
WebElement daily=Driver.get().findElement(By.cssSelector("[class='recurrence-repeats__select']"));
daily.click();
WebElement daily2=Driver.get().findElement(By.xpath("(//option[@value='daily'])[1]"));
Assert.assertTrue(daily2.isEnabled());
Assert.assertTrue(daily2.isSelected());
     //JavascriptExecutor js = (JavascriptExecutor) driver;//buyolla da bulunur
     //js.executeScript("arguments[0].click()", Daily);
WebElement weekly=Driver.get().findElement(By.xpath("//option[@value='weekly']"));
Assert.assertTrue(weekly.isEnabled());

 WebElement monthly= Driver.get().findElement(By.xpath("//option[@value='monthly']"));
     Assert.assertTrue(monthly.isEnabled());
     WebElement yearly=Driver.get().findElement(By.xpath("//option[@value='yearly']"));
Assert.assertTrue(yearly.isEnabled());
   }

@Test(description = "Verify that never radio button is selected,verify that following message as a summary is displayed")
public void test9(){
    WebElement calenderevents = Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
    wait.until(ExpectedConditions.visibilityOf(calenderevents));
    wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
    calenderevents.click();
    Driver.get().findElement(By.cssSelector("[title='Create Calendar event']")).click();

    WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
    wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    WebElement repeatbutton=Driver.get().findElement(By.cssSelector("[data-name='recurrence-repeat']"));
    repeatbutton.click();
    Assert.assertTrue(repeatbutton.isSelected());
WebElement repeatEveryButton=Driver.get().findElement(By.cssSelector("[data-name='recurrence-repeat']"));
Assert.assertTrue(repeatEveryButton.isSelected());
WebElement neverButton=Driver.get().findElement(By.xpath("(//input[@type='radio'])[3]"));
Assert.assertTrue(neverButton.isSelected());
WebElement summary=Driver.get().findElement(By.cssSelector(".control-group.recurrence-summary.alert-info"));
String actualText=summary.getText();
String expectedText="Summary:\nDaily every 1 day";
 Assert.assertEquals(actualText,expectedText,"expected text could not find");
   }
@Test(description = "Verify that following message as a summary is displayed")
public void test10() {
    WebElement calenderevents = Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
    wait.until(ExpectedConditions.visibilityOf(calenderevents));
    wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
    calenderevents.click();
    Driver.get().findElement(By.cssSelector("[title='Create Calendar event']")).click();

    WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
    wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    WebElement repeatbutton = Driver.get().findElement(By.cssSelector("[data-name='recurrence-repeat']"));
    repeatbutton.click();
    WebElement afterButton = Driver.get().findElement(By.xpath("(//input[@type='radio'])[4]"));
    afterButton.click();
    WebElement inputbox = Driver.get().findElement(By.cssSelector("[data-related-field='occurrences']"));
    inputbox.sendKeys("10");
    WebElement occurences = Driver.get().findElement(By.xpath("//span[contains(text(),'occurrences')]"));
    occurences.click();
    WebElement summary = Driver.get().findElement(By.cssSelector(".control-group.recurrence-summary.alert-info"));
    summary.click();
    String actualText = summary.getText();
    String expectedText = "Summary:\nDaily every 1 day, end after 10 occurrences";
    Assert.assertEquals(actualText, expectedText);
}

@Test(description ="Summary: Daily every 1 day, end by Nov 18, 2021" )
public void test11(){
    WebElement calenderevents = Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
    wait.until(ExpectedConditions.visibilityOf(calenderevents));
    wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
    calenderevents.click();
    Driver.get().findElement(By.cssSelector("[title='Create Calendar event']")).click();

    WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
    wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    WebElement repeatbutton = Driver.get().findElement(By.cssSelector("[data-name='recurrence-repeat']"));
    repeatbutton.click();
WebElement bybutton=Driver.get().findElement(By.xpath("(//input[@type='radio'])[5]"));

    bybutton.click();
//wait.until(ExpectedConditions.invisibilityOf(bybutton));
    WebElement datebox=Driver.get().findElement(By.xpath(("(//*[@placeholder='Choose a date'])[3]")));

datebox.click();
WebElement selectYear=Driver.get().findElement(By.cssSelector("[data-handler='selectYear']"));
   selectYear.click();
    WebElement year = Driver.get().findElement(By.className("ui-datepicker-year"));
    year.click();
   WebElement year2021=Driver.get().findElement(By.cssSelector("[value='2021']"));
year2021.click();


    WebElement month=Driver.get().findElement(By.cssSelector("[data-handler='selectMonth']"));
month.click();
WebElement month10=Driver.get().findElement(By.xpath("//option[text()='Nov']"));
month10.click();
WebElement day=Driver.get().findElement(By.xpath("//a[text()='18']"));
day.click();
String expectedResult="Summary:\n" +
        "Daily every 1 day, end by Nov 18, 2021";
WebElement actual=Driver.get().findElement(By.cssSelector("[class='control-group recurrence-summary alert-info']"));
String actualResult=actual.getText();
Assert.assertEquals(expectedResult,actualResult);
   }

@Test(description = "verify that Summary: Weekly every 1 week onMonday, Friday”")
public void test12(){
    WebElement calenderevents = Driver.get().findElement(By.cssSelector("[class='dropdown dropdown-level-1 active']"));
    wait.until(ExpectedConditions.visibilityOf(calenderevents));
    wait.until(ExpectedConditions.elementToBeClickable(calenderevents));
    calenderevents.click();
    Driver.get().findElement(By.cssSelector("[title='Create Calendar event']")).click();

    WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
    wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    WebElement repeatbutton = Driver.get().findElement(By.cssSelector("[data-name='recurrence-repeat']"));
    repeatbutton.click();
WebElement dailiy=Driver.get().findElement(By.className("recurrence-repeats__select"));
dailiy.click();
//WebElement daily=Driver.get().findElement(By.xpath("(//*[@value='weekly'])[3])"));
//daily.click();


    Select select = new Select(dailiy);
    select.selectByVisibleText("Weekly");
    Driver.get().findElement(By.xpath("(//*[@value='monday'])[3]")).click();
    Driver.get().findElement(By.xpath("(//*[@value='friday'])[3]")).click();
    String actualText = Driver.get().findElement(By.cssSelector(".control-group.recurrence-summary.alert-info")).getText();
    String expectedText = "Summary:\nWeekly every 1 week on Monday, Friday";
    Assert.assertEquals(actualText, expectedText);










//  JavascriptExecutor js=(javaScriptExecuter)Driver.get();

   // js.executeScript("arguments[0].click()", Daily);
 //   Select select = new Select(Daily);
  //  select.selectByVisibleText("Weekly");
  //  driver.findElement(By.xpath("(//*[@value='monday'])[3]")).click();
    //driver.findElement(By.xpath("(//*[@value='friday'])[3]")).click();
   // String actualText = driver.findElement(By.cssSelector(".control-group.recurrence-summary.alert-info")).getText();
   // String expectedText = "Summary:\nWeekly every 1 week on Monday, Friday";
 //   Assert.assertEquals(actualText, expectedText);




   }


    @AfterMethod
    public void teardown() {
        Driver.get().quit();
    }





}












