package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class Browser {

    static EventFiringWebDriver eventDriver;

    public static EventFiringWebDriver getDriver() {

        System.out.println();
        if (eventDriver == null) {
            // Create a new instance of ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-extensions");
            options.addArguments("--profile-directory=Default");
            options.addArguments("--disable-plugins-discovery");
            options.addArguments("--start-maximized");

            // Create a new instance of ChromeDriver
            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            // Wrap the driver with EventFiringWebDriver
            eventDriver = new EventFiringWebDriver(driver);

            // Create the listener instance
            MyListener listener = new MyListener();

            // Register the listener with the event driver
            eventDriver.register(listener);

            // Navigate to the desired website
            eventDriver.get("https://www.next.co.il/en");
            Utils.isOpenPage("https://www.next.co.il/en");

            Utils.waiting();
            Utils.waiting();


        }
        return eventDriver;
    }
}
