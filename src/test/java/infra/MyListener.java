package infra;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import utils.Utils;


// Custom listener class
public class MyListener extends AbstractWebDriverEventListener {

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;


    public MyListener() {
        test = ExtendReport.getInstance().getTest();

    }


    public void onException(Throwable throwable, WebDriver driver) {
        test.log(Status.INFO, throwable.getMessage());
        Utils.addScreenshot();
    }


    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Finding element: " +"[" + by + "]");

        test.log(Status.INFO, "Finding element: " +"[" + by + "]");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Element found: " +"[" + by + "]" );
    }


    public void beforeNavigateBack(WebDriver driver) {
        test.log(Status.INFO, "beforeNavigateBack title= [" + driver.getTitle() + "]");
        System.out.println("beforeNavigateBack title= [" + driver.getTitle() + "]");

    }

    public void afterNavigateBack(WebDriver driver) {
        test.log(Status.INFO, "afterNavigateBack title= [" + driver.getTitle()+ "]");
        System.out.println("afterNavigateBack title= [" + driver.getTitle()+ "]");
        Utils.waiting();
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("beforeClickOn [" + element.getTagName() + " " + element.getText()+ "]");
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        test.log(Status.INFO, "afterClickOn [" + element.getTagName() + " " + element.getText() + "]");
        System.out.println("afterClickOn [" + element.getTagName() + " " + element.getText() + "]");
    }


}


