package infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import utils.Utils;


// Custom listener class
public class MyListener extends AbstractWebDriverEventListener {


    public void onException(Throwable throwable, WebDriver driver) {
        Reporter.errorMessage(throwable.getMessage());
        Utils.addScreenshot();
    }


   /* @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Finding element: " + "[" + by + "]");
        Reporter.infoMessage("Finding element: " + "[" + by + "]");
    }*/

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Element found: " + "[" + by + "]");
        Reporter.infoMessage("Element found: " + "[" + by + "]");

    }


    public void beforeNavigateBack(WebDriver driver) {
        Reporter.infoMessage("beforeNavigateBack title= [" + driver.getTitle() + "]");
        System.out.println("beforeNavigateBack title= [" + driver.getTitle() + "]");

    }

    public void afterNavigateBack(WebDriver driver) {
        Reporter.infoMessage("afterNavigateBack title= [" + driver.getTitle() + "]");
        System.out.println("afterNavigateBack title= [" + driver.getTitle() + "]");
        Utils.waiting();
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        Reporter.infoMessage("Before Click On [" + element.getText() + "]");
        System.out.println("Before Click On [" + element.getText() + "]");
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        Reporter.infoMessage("After Click On [" + element.getTagName() + " " + element.getText() + "]");
        System.out.println("After Click On [" + element.getTagName() + " " + element.getText() + "]");
    }

}


