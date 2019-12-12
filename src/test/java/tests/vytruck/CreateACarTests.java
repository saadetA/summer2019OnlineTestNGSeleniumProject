package tests.vytruck;

import Pages.CreateCarPage;
import Pages.LoginPage;
import Pages.VehiclesPage;
import org.testng.annotations.Test;
import tests.TestBase;

public class CreateACarTests extends TestBase {
@Test(description = "Create some random car")
    public  void Test1(){
    extentTest = extentReports.createTest("Create a new car");
    LoginPage loginPage=new LoginPage();
    VehiclesPage vehiclesPage=new VehiclesPage();
    CreateCarPage createCarPage=new CreateCarPage();

    loginPage.login("storemanager85","UserUser123");
loginPage.navigateTo("Fleet","Vehicles");

loginPage.waitUntilLoaderMaskDisappear();
vehiclesPage.clickToCreateACar();

loginPage.waitUntilLoaderMaskDisappear();

createCarPage.licensePlateElement.sendKeys("Random");
createCarPage.selectTags("Compact");

createCarPage.selectFuelType("Diesel");
loginPage.waitUntilLoaderMaskDisappear();
createCarPage.saveAndCloseButtonElement.click();
    extentTest.pass("New car was created");

}

}
