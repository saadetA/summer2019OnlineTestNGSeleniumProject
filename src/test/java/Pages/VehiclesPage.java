package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class VehiclesPage extends BasePage{
@FindBy(css="[title='Create Car']")
public WebElement createACarElement;
/**
use this method to click createACar button
method already contains waits to handle synchronization issues
 */
public  void clickToCreateACar(){
    BrowserUtils.waitForVisibility(createACarElement,15);
BrowserUtils.waitForClickablility(createACarElement,15);
createACarElement.click();
}






}
