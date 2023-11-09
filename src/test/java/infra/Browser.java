package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.Utils;

public class Browser {

    static EventFiringWebDriver eventDriver;

    public static EventFiringWebDriver getDriver()  {

        System.out.println();
        if (eventDriver == null) {
            // Set the path to the chromedriver executable
            //System.setProperty("webdriver.chrome.driver", "resources\\chromedriver-win32\\chromedriver.exe");

            // Create a new instance of ChromeDriver
            WebDriver driver = new ChromeDriver();

            // Wrap the driver with EventFiringWebDriver
            eventDriver = new EventFiringWebDriver(driver);

            // Create an instance of the listener
            MyListener listener = new MyListener();

            // Register the listener with the event driver
            eventDriver.register(listener);

            // Navigate to the desired website
            eventDriver.get("https://www.next.co.il/en");
            try {
                Utils.waiting();
                Utils.waiting();
            }catch (Exception e){
                e.printStackTrace();
            }


        }
        return eventDriver;
    }

}
