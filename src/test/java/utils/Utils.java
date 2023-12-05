package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import infra.Browser;
//import infra.Reporter;
import infra.ErrorsManage;
import infra.ExtendReport;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import testCases.Constants;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Utils {
    private static ExtentTest test;

    //The method check if the webpage opened successfully
    public static void isOpenPage(String url) {
        test= ExtendReport.getInstance().getTest();

        boolean pageOpened = false;
        try {
            Browser.getDriver().get(url);
            pageOpened = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FATAL, "next site was not found " + e.getMessage());
            ErrorsManage.setNumError();
            pageOpened = false;
            addScreenshot();
        } finally {
            if (pageOpened)
                test.log(Status.PASS, "Open webpage -" + "Webpage opened successfully");
        }
    }


    //The method waiting 4000 millis
    public static void waiting()  {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException i){
            i.printStackTrace();
        }


    }


    public static void addScreenshot()  {
        test=ExtendReport.getInstance().getTest();
        try {
            String currentTime = String.valueOf(System.currentTimeMillis());
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.SCREEN_SHOT_PATH + currentTime)).build());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //A function required to add a screenshot
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) Browser.getDriver();
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }


    //The method for reading from file
    public static String getData(String keyName) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File(Constants.CONFIG_XML_FILE_PATH);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        assert dBuilder != null;
        doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }


}
