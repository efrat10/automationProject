package infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

// Custom listener class
public class MyListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Finding element: " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Element found: " + by);
    }
}