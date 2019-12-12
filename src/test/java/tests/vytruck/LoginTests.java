package tests.vytruck;

import Pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.Driver;

//we write extends TestBase to inherit @before and @after Methods
public class LoginTests extends TestBase {
@Test(description = "verify that page title equals to Dashboard")
public  void test1(){
    LoginPage loginPage=new LoginPage();//create page object from page class
//how we can use login
loginPage.login("storemanager85","UserUser123");
//we can use config reader to properties too
//this is verification step

    Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
//Driver.get()=driver same Driver get() it returns webdriver object
}

}
