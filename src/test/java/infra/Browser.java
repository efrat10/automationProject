package infra;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.xml.sax.SAXException;
import utils.Utils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Browser {

    static EventFiringWebDriver eventDriver;

    public static EventFiringWebDriver getDriver()  {

        System.out.println();
        if (eventDriver == null) {
            // Set the path to the chromedriver executable
            //System.setProperty("webdriver.chrome.driver", "resources\\chromedriver-win32\\chromedriver.exe");

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

            //ExtentReports extent = ExtendReport.getInstance().getExtent();
            //ExtentTest extentTest = extent.startTest("My Test");
            //extent.createTest("SanityTest", "Sanity test for 'next' site");

            // Create the listener instance and pass the extent instance
            MyListener listener = new MyListener();




            // Create an instance of the listener
            //MyListener listener = new MyListener();

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
