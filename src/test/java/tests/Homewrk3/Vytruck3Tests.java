package tests.Homewrk3;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.mustache.Value;
import utils.Driver;

import java.time.Instant;
import java.util.List;

public class Vytruck3Tests extends VytruckSyncrnz_checkbox {
@Test(description = "verify that page title option is displayed")
      public void test1(){
      WebElement optionsButton= Driver.get().findElement(By.cssSelector("[class='btn btn-link dropdown-toggle']"));
     Assert.assertTrue(optionsButton.isDisplayed());
}

@Test(description = "verify that page number is equals to 1")
public void test2(){
 WebElement pagenumber=Driver.get().findElement(By.cssSelector("[type=number]"));
 String Value = pagenumber.getAttribute("value");
  // String actual="1" ;
 Assert.assertTrue(Value.equals("1"));

}
@Test(description = "Verify that view page number is equals to 25")
public void test3(){
    WebElement viewPageNumber=Driver.get().findElement(By.cssSelector("[class='btn dropdown-toggle ']"));
 String viewPageNumbertext =viewPageNumber.getText();
Assert.assertTrue(viewPageNumbertext.equals("25"));
}
    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void testCase4() {

        List<WebElement> Rows = Driver.get().findElements(By.xpath("//tbody//tr"));
        int numberOfRows = Rows.size();
        WebElement Records = Driver.get().findElement(By.cssSelector("[class='dib']:nth-of-type(3)"));
        String RecordsText = Records.getText();
        Assert.assertTrue(RecordsText.contains(""+numberOfRows));
    }
    @Ignore
    @Test(description = "Verify that all calendar events were selected")
    public void testCase5(){
        WebElement SelectAll= Driver.get().findElement
                (By.cssSelector("[type='checkbox'][data-select]"));
        WebDriverWait wait=new WebDriverWait(Driver.get(),15);
        wait.until(ExpectedConditions.elementToBeClickable(SelectAll));
        SelectAll.click();
        for(int i=1;i<=19;i++) {
            WebElement selection = Driver.get().findElement(By.xpath("//tbody//tr[" + i + "]//td//input"));
            Assert.assertTrue(selection.isSelected());
        }
    }

    @Test(description = "Verify that meeting data is displayed when clicked on meeting")
    public void testCase6(){
        WebElement meeting = Driver.get().findElement(By.xpath("//tbody//tr[13]//td[2]"));
        meeting.click();
        WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
        WebDriverWait wait=new WebDriverWait(Driver.get(),15);
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        String [] info = {"Title","Testers Meeting","Description", "Start","Nov 27, 2019, 9:30 PM","End","Nov 27, 2019, 10:30 PM",
                "All-day Event","No","Organizer","Stephan Haley","Guests","Tom Smith - Required","Recurrence",
                "Weekly every 1 week on Wednesday","Call Via Hangout","No","This is a a weekly testers meeting"};
        List<WebElement> data = Driver.get().findElements(By.cssSelector("[class='control-label']"));
        int count=0;
        for(WebElement each: data){
            Assert.assertEquals(each.getText(),info[count],"Info does not match");
            Assert.assertTrue(each.isDisplayed());
            count++;
        }
        WebElement description =Driver.get().findElement(By.cssSelector("[class='control-label html-property']"));
        String actualDescription = description.getText();
        String expectedDescription = info[17];
        Assert.assertEquals(actualDescription,expectedDescription,"Description is wrong");
    }



}

