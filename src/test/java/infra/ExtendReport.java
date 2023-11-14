package infra;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import testCases.Constants;

public class ExtendReport {
    private static ExtendReport instance;
    private ExtentReports extent;
    private static ExtentTest test;


    private ExtendReport() {
        // Private constructor to prevent instance creation from outside
        //extent = new ExtentReports();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constants.REPORT_FILE_PATH);


        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        //ExtentTest test = extent.createTest("SanityTest", "Sanity test for 'next' site");

        // add custom system info
        extent.setSystemInfo("Project Development Language: ", "Java");
        extent.setSystemInfo("Development Environment IDE: ", "IntelliJ idea");
        extent.setSystemInfo("Third Party Software: ", "Selenium WebDriver, Junit, ExtentReports, Maven");
        //extent.setSystemInfo("URL: ", Utils.getData("URL"));
        extent.setSystemInfo("Tester", "Efrat Cohen");
        test = extent.createTest("SanityTest", "Sanity test for 'next' site");


    }

    public static ExtendReport getInstance() {
        if (instance == null) {
            instance = new ExtendReport();

        }
        return instance;
    }

    public ExtentReports getExtent() {
        return extent;
    }
    public ExtentTest getTest() {
        return test;
    }
}


