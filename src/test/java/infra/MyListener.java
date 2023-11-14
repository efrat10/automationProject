package infra;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.xml.sax.SAXException;
import utils.Utils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


// Custom listener class
public class MyListener extends AbstractWebDriverEventListener {

    // create ExtentReports and attach reporter(s)
    //private static ExtentReports extent;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;
    /*private ExtentReports extent;
    private ExtentTest extentTest;*/

    public MyListener() {
        //extent = ExtendReport.getInstance().getExtent();
        test=ExtendReport.getInstance().getTest();

    }




    public void onException(Throwable throwable, WebDriver driver) {
        test.log(Status.INFO,throwable.getMessage());
    }


    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Finding element: " + by);
        //extentTest.log(LogStatus.INFO, "Test started");

        test.log(Status.INFO,"Finding element: " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Element found: " + by + element.getTagName()+ element.getText());
    }


    public void beforeNavigateBack(WebDriver driver) {
        test.log(Status.INFO,"beforeNavigateBack");
        test.log(Status.INFO,driver.getTitle());

        System.out.println("beforeNavigateBack");
        System.out.println(driver.getTitle());


    }

    public void afterNavigateBack(WebDriver driver) {
        test.log(Status.INFO,"afterNavigateBack");
        test.log(Status.INFO,driver.getTitle());
        System.out.println("afterNavigateBack");
        System.out.println(driver.getTitle());
        Utils.waiting();
    }
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("beforeClickOn " + element.getTagName() +" "+ element.getText());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        test.log(Status.INFO,"afterClickOn " + element.getTagName() + " "+element.getText());
        System.out.println("afterClickOn " + element.getTagName() + " "+element.getText());
    }


    }


