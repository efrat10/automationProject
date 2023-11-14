package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import infra.Browser;
import infra.ExtendReport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.xml.sax.SAXException;
import pages.*;
import utils.Utils;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//The class performs sanity tests for the 'next' site
public class SanityTest {

    //private static WebDriver driver;

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;


    @BeforeClass
    public static void beforeClass() throws ParserConfigurationException, IOException, SAXException {

       /* ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constants.REPORT_FILE_PATH);

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
*/

        extent = ExtendReport.getInstance().getExtent();


        /*boolean driverEstablish = false;
        try {
            //System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-extensions");
            options.addArguments("--profile-directory=Default");
            options.addArguments("--disable-plugins-discovery");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driverEstablish = true;

        } catch (Exception e) {
            e.printStackTrace();
            fail("Cant connect chromeDriver");
            test.log(Status.FATAL, "Driver Connection Failed! " + e.getMessage());
            driverEstablish = false;
        } finally {
            if (driverEstablish)
                test.log(Status.PASS, "Driver established successfully");
        }

        isOpenPage(getData("URL"));
    }
*/
    }

    //The test method performs sanity test for login page
    @Test
    public void test01_verifyLogin() throws InterruptedException, ParserConfigurationException, IOException, SAXException {

        test.log(Status.INFO, "@Test - Sanity test for a page Verify Login starting");

        //creating object for sign in page
        //SignIntoNextPage login = new SignIntoNextPage(driver);
        SignIntoNextPage login = new SignIntoNextPage();

        Utils.waiting();

        //click on login button
        login.clickMyAccount();

        //checking if the clicking on login button successful
        System.out.println(Browser.getDriver().getTitle());
        isSucceededTransitionTo_New_Page("My account", Constants.TITLE_MY_ACCOUNT_PAGE);
        Utils.waiting();

        //Enter email && password
        test.log(Status.INFO, "Enter email && password");
        login.typeEmailId(Utils.getData("EMAIL"));
        login.typePassword(Utils.getData("PASSWORD"));

        //click on 'sign in' button
//        test.log(Status.INFO, "//click on 'sign in' button");
//        login.clickSignInButton();
//        waiting();

        Browser.getDriver().navigate().back();

        test.log(Status.INFO, " @Test - Sanity test for a Verify Login page are ending");

    }

    @Test
    //The test performs sanity test on the home page
    public void test02_HomePage() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        //test.log(Status.INFO, "@Test - Sanity test for a Home page  starting");
        test = ExtendReport.getInstance().getTest();
        // log results
        test.log(Status.INFO, "Beginning test homePage");
        //create object of HomePage
        HomePage homePage = new HomePage();

        Utils.waiting();

        //click on links from header links and sidebar
        test.log(Status.INFO, "click on 'Home' link from header links ");
        //addScreenshot();
        homePage.clickOnLinksAndValidateTitle();
        homePage.changeLanguage();

        //checking if the changing language succeeded
        //isSucceededTransitionTo_New_Page( "Hebrew",Constants.TITLE_HEBREW_HOME_PAGE);

        //return to english
        Browser.getDriver().navigate().back();
        Utils.waiting();

        ////A reference to the function that will test if navigate to the new page successful and reports on it
        //isSucceededTransitionTo_New_Page("english",Constants.TITLE_HOME_PAGE);

        test.log(Status.INFO, " @Test - Sanity test for a Home page ending");
    }

    @Test
    public void test03_ProductBuyingProcess() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        //A call to the method that will perform sanity test on the Search page
        test_searchPage();

        //A call to the method that will perform sanity test on the product page
        test_productPage();

        //A call to the method that will perform sanity test on the shoppingBag page
        test_shoppingBag();

        //A call to the method that will perform sanity test on the payment page
        //test_paymentPage();
    }

    @AfterClass
    public static void afterClass() throws Exception {

        // build and flush report
        extent.flush();
        Browser.getDriver().quit();
        test.log(Status.INFO, "@After class  was performed " );
    }


    //The test performs sanity test on the Search page
    public void test_searchPage() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        test.log(Status.INFO, " @Test - Sanity test for a Search page starting");

        //creating object for search page
        SearchPage searchPage = new SearchPage();

        //Enter a product name for search
        test.log(Status.INFO, "Enter a product name for search");
        String dataToSearch = Utils.getData("SEARCH");
        searchPage.typeSearch(dataToSearch);
        Utils.waiting();

        //Clicking on the desired product
        searchPage.doubleClickOndress1Img();
        test.log(Status.INFO, "Clicking on the desired product");
        Utils.waiting();
        isSucceededTransitionTo_New_Page("product", Constants.TITLE_PRODUCT_PAGE);

        test.log(Status.INFO, " Sanity test for a Search page ending");
    }

    //Method for test productPage
    public void test_productPage() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        test.log(Status.INFO, " @Test - Sanity test for a Product page starting");

        //creating object for product page
        ProductPage productPage = new ProductPage();

        System.out.println(Browser.getDriver().getTitle());

        //Choosing a specific color
        test.log(Status.INFO, "Choosing a specific color");
        //productPage.selectColor("Navy Blue");
        //productPage.selectColor(3);
        productPage.clickSelectColor();

        Utils.waiting();

        //Choosing a specific size
        test.log(Status.INFO, "Choosing a specific size");
        //productPage.selectSize(getData("SIZE"));
        productPage.clickSelectSize();
        Utils.waiting();

        //click on add to bag button
        test.log(Status.INFO, "click on add to bag button");
        productPage.clickAddToBagButton();
        Utils.waiting();

        //click on view/edit button
        test.log(Status.INFO, "click on 'view/edit' button");
        productPage.clickViewEditBag();

        test.log(Status.INFO, " @Test - Sanity test for a Product page ending");
    }

    //Method for test shoppingBag
    public void test_shoppingBag() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        //creating object for 'shopping bag' page
        ShoppingBag shoppingBag = new ShoppingBag();

        test.log(Status.INFO, "@Test - Sanity test for a Shopping Bag page starting");

        test.log(Status.INFO, "Selecting a specific quantity for the product selected from the menu");
        Utils.waiting();
        shoppingBag.selectQty();

        //Checking whether the quantity selection has been updated in the shopping bag
        Utils.waiting();
        boolean bool = shoppingBag.isQtyBugImgUpdate();
        if (bool)
            test.log(Status.PASS, "The quantity in the bag image has been updated");
        else {
            test.log(Status.FAIL, "The quantity in the bag image has not been updated");

            Utils.addScreenshot();
        }

        shoppingBag.clickGoToCheckoutButton();
        test.log(Status.INFO, " @Test - Sanity test for a Shopping Bag page ending");
    }

    public void test_paymentPage() throws ParserConfigurationException, IOException, SAXException, InterruptedException {

        test.log(Status.INFO, "@Test - Sanity test for a PaymentPage page starting");

        //creating an object for product page
        PaymentPage paymentPage = new PaymentPage();


        //selecting a credit card
        test.log(Status.INFO, "selecting a credit card");
        paymentPage.selectCreditCardRadio();

        //Enter a card number
        test.log(Status.INFO, "Enter a card number");
        paymentPage.typeCardNumber(Utils.getData("CARD_NUMBER"));

        //Enter a name card's holder
        test.log(Status.INFO, "Enter a name card's holder");
        paymentPage.typeNameOfCardholder(Utils.getData("NAME_CARDHOLDER"));


        //Enter a month expiry date
        test.log(Status.INFO, "Enter a month expiry date");
        paymentPage.typeMonthExpiry(Utils.getData("YEAR_EXPIRY_DATE"));

        //Clicking on 'pay now' button
        test.log(Status.INFO, "Clicking on 'pay now' button");
        paymentPage.clickPayOnButton();

        test.log(Status.INFO, "@Test - Sanity test for a PaymentPage page  Ending");

    }


    /*//The method check if the webpage opened successfully
    public static void isOpenPage(String url) throws IOException {
        boolean pageOpened = false;
        try {
            driver.get(url);
//            String firstWindowString = driver.getWindowHandle();
//            System.out.println("Window String: " + firstWindowString);
            pageOpened = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FATAL, "next site was not found " + e.getMessage());
            pageOpened = false;
            addScreenshot();
        } finally {
            if (pageOpened)
                test.log(Status.PASS, "Open webpage " + "Webpage opened successfully");
        }
    }


    //The method waiting 4000 millis
    public static void waiting() throws InterruptedException {
        Thread.sleep(4000);
    }*/


    //The method check if navigate to new page succeeded and send report
    private void isSucceededTransitionTo_New_Page(String nameNewPage, String expectedTitle) throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        System.out.println();
        Utils.waiting();
        String actualTitle = Browser.getDriver().getTitle();
        System.out.println("actualTitle: " + actualTitle);
        boolean equalsTitles = actualTitle.equals(expectedTitle);
        if (equalsTitles) {
            System.out.println("The transition to the web " + nameNewPage + " page was done successfully");
            test.log(Status.PASS, "The transition to the web " + nameNewPage + " page was done successfully ");
        } else {
            System.out.println("The transition to the web " + nameNewPage + " page was fail");
            test.log(Status.FAIL, "The transition to the web " + nameNewPage + " page was fail");
            Utils.addScreenshot();
        }

    }

    //The method check if navigate to home page succeeded.and send report
    private void isSucceededTransitionTo_Home_Page() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        isSucceededTransitionTo_New_Page("home", Constants.TITLE_HOME_PAGE);

    }

    // The method Make sure the driver is actually on the desired page
    private void isDesiredPath(String pageName, String expectedUrl) throws InterruptedException, IOException {
        Utils.waiting();
        String curUrl = Browser.getDriver().getCurrentUrl();
        boolean isUrl = curUrl.equals(expectedUrl);
        if (!isUrl)
            Browser.getDriver().navigate().to(expectedUrl);
    }

    //The method add screenshot
   /* public static void addScreenshot() throws IOException {
        String currentTime = String.valueOf(System.currentTimeMillis());
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.SCREEN_SHOT_PATH + currentTime)).build());
    }

    //A function required to add a screenshot
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
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
    private static String getData (String keyName) throws ParserConfigurationException, IOException, SAXException {
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
*/

}