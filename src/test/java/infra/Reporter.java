package infra;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import testCases.Constants;
import utils.Utils;

public class Reporter {
    private static Reporter instance;
    private ExtentReports extent;
    private static ExtentTest test;

    // Private constructor to prevent instance creation from outside
    private Reporter() {

        //Definition variable of extend report
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constants.REPORT_FILE_PATH);

        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // add custom system info
        extent.setSystemInfo("Project Development Language: ", "Java");
        extent.setSystemInfo("Development Environment IDE: ", "IntelliJ idea");
        extent.setSystemInfo("Third Party Software: ", "Selenium WebDriver, Junit, ExtentReports, Maven");
        //extent.setSystemInfo("URL: ", Utils.getData("URL"));
        extent.setSystemInfo("Tester", "Efrat Cohen");
        test = extent.createTest("SanityTest", "Sanity test for 'next' site");

    }

    //The method return the one instance of Reporter
    public static Reporter getInstance() {
        if (instance == null) {
            instance = new Reporter();

        }
        return instance;
    }


    //Get method of extend
    public ExtentReports getExtent() {
        return extent;
    }

    //Get method of test
    public ExtentTest getTest() {
        return test;
    }

    //The method get information message and sent it to report
    public static void infoMessage(String message) {
        getInstance().getTest().log(Status.INFO, message);
    }

    //The method get warning message and sent it to report
    public static void warningMessage(String message) {
        getInstance().getTest().log(Status.WARNING, message);

    }

    //The method get error message and sent it to report
    public static void errorMessage(String message) {
        getInstance().getTest().log(Status.FAIL, message);
        ErrorsManage.setNumError();
        Utils.addScreenshot();
    }

    //The method get fatal message and sent it to report
    public static void fatalMessage(String message) {
        getInstance().getTest().log(Status.FATAL, message);
    }

    //The method get pass message and sent it to report
    public static void passMessage(String message) {
        getInstance().getTest().log(Status.PASS, message);
    }

}


