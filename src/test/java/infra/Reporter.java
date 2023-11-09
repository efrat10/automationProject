package infra;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.xml.sax.SAXException;
import testCases.Constants;
import utils.Utils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Reporter {

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent ;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test ;


    public static ExtentTest getTestReport() throws ParserConfigurationException, IOException, SAXException {  //Check if a report has already been created
        if (test == null) {

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constants.REPORT_FILE_PATH);

            // attach reporter
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            // name your test and add description
            test = extent.createTest("SanityTest", "Sanity test for 'next' site");

            // add custom system info
            extent.setSystemInfo("Project Development Language: ", "Java");
            extent.setSystemInfo("Development Environment IDE: ", "IntelliJ idea");
            extent.setSystemInfo("Third Party Software: ", "Selenium WebDriver, Junit, ExtentReports, Maven");
            extent.setSystemInfo("URL: ", Utils.getData("URL"));
            extent.setSystemInfo("Tester", "Efrat Cohen");



        }
        return test;
    }
}
