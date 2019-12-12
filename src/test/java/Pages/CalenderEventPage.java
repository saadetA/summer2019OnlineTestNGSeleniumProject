package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;


public class CalenderEventPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForVisibility(createCalendarEvent, 15);
        BrowserUtils.waitForClickablility(createCalendarEvent, 15);
        createCalendarEvent.click();
    }



}
