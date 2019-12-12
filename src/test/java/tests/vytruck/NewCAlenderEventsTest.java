package tests.vytruck;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.TestBase;


public class NewCAlenderEventsTest extends TestBase {
@Test(description = "verify that page subtitle is equal to 'All CAlender Events'")

public void test1() {
   extentTest=extentReports.createTest("verify that page subtitle is equal to 'All CAlender Events");
    LoginPage loginPage = new LoginPage(); //login page object

    loginPage.login("storemanager85", "UserUser123");
    loginPage.navigateTo("Activities", "Calendar Events");

    String expectedSubtitle = "All Calendar Events";
    String actualSubTitle = loginPage.getPageSubTitle();

    Assert.assertEquals(actualSubTitle, expectedSubtitle);
extentTest.pass("verify that page subtitle  'All CAlender Events is displayed");
}




}
