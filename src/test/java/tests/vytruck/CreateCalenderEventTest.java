package tests.vytruck;

import Pages.CalenderEventPage;
import Pages.CreateCalenderEventPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;


public class CreateCalenderEventTest extends TestBase {
   @Test(description ="Verify owner's name is Stephan Haley on qa1 storemanager85")
    public void test1(){
        LoginPage loginPage = new LoginPage();
        CalenderEventPage calendarEventPage = new CalenderEventPage();
       CreateCalenderEventPage createCalendarEventPage = new CreateCalenderEventPage();

        //login as Stephan Haley (storemanager85)
        loginPage.login("storemanager85", "UserUser123");

        //go to calendar events page
        loginPage.navigateTo("Activities", "Calendar Events");

        //click on create calendar event button
        calendarEventPage.waitUntilLoaderMaskDisappear();
        calendarEventPage.clickToCreateCalendarEvent();

        calendarEventPage.waitUntilLoaderMaskDisappear();
        String expectedOwner = "Stephan Haley";
        String actualOwner = createCalendarEventPage.owner.getText().trim();
Assert.assertEquals(actualOwner,expectedOwner);
    }
}

