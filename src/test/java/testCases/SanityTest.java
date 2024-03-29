package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import infra.Browser;
import infra.ErrorsManage;
import infra.Reporter;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.xml.sax.SAXException;
import pages.*;
import utils.Utils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//The class performs sanity tests for the 'next' site
public class SanityTest {

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;


    @BeforeClass
    public static void beforeClass() {

        extent = Reporter.getInstance().getExtent();

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


    @Test
    //The test performs sanity test on the home page
    //The test checks the correctness of the links (one from each group), as well as the correctness of the language change
    public void test02_HomePage() {
        Reporter.infoMessage(" @Test - Sanity test for home Page starting");
        Reporter.infoMessage("Checking links on the 'home page' and changing language");

        //create object of HomePage
        HomePage homePage = new HomePage();
        Utils.waiting();

        //A call to the function to check the links
        homePage.clickOnLinksAndValidateTitle();

        //Calling the function to check the language change
        homePage.changeLanguage();

        //Return to english
        Browser.getDriver().navigate().back();
        Utils.waiting();

    }

    @Test
    public void test03_ProductBuyingProcess() throws InterruptedException, IOException, ParserConfigurationException, SAXException {

        Reporter.infoMessage(" @Test - Sanity test for a Product Buying Process starting");
        //A call to the method that will perform sanity test on the Search page
        test_searchPage();

        //A call to the method that will perform sanity test on the product page
        test_productPage();

        //A call to the method that will perform sanity test on the shoppingBag page
        //test_shoppingBag();

        //A call to the method that will perform sanity test on the payment page
        //test_paymentPage();
    }

    @After
    public void tearDown() throws Exception {
        if (ErrorsManage.getNumError() > 0) {
            System.out.println(ErrorsManage.getNumError() + " errors were found in this test");
            Reporter.warningMessage(ErrorsManage.getNumError() + " errors were found in this test");
            ErrorsManage.resetErrors();
            Assert.fail();
        }

        Reporter.infoMessage(" @Test -  ending");
    }

    @AfterClass
    public static void afterClass() throws Exception {

        // build and flush report
        extent.flush();
        Browser.getDriver().quit();
        Reporter.infoMessage("@After class  was performed ");

    }


    //The test performs sanity test on the Search page
    public void test_searchPage() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        Reporter.infoMessage("Search And Product Selection ");

        //creating object for search page
        SearchPage searchPage = new SearchPage();

        //Enter a product name for search
        Reporter.infoMessage("Enter a product name for search");
        String dataToSearch = Utils.getData("ITEM_SEARCH");
        searchPage.SearchAndProductSelection(dataToSearch);

    }

    //Method for test productPage
    public void test_productPage() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        //test.log(Status.INFO, );
        Reporter.infoMessage("Choice of color and size in the selected product");
        //creating object for product page
        ProductPage productPage = new ProductPage();
        //test.log(Status.INFO,);
        Reporter.infoMessage("choice color");
        productPage.chooseColor();
        Utils.waiting();
        Reporter.infoMessage("choice size");
        productPage.chooseSize();

        //click on add to bag button
        Reporter.infoMessage("Click 'Add To Bag' Button");
        productPage.clickAddToBagButton();
        Utils.waiting();

        //click on view/edit option
        //productPage.clickViewEditBag();

        //Choosing a specific size
       /* test.log(Status.INFO, "Choosing a specific size");
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

        test.log(Status.INFO, " @Test - Sanity test for a Product page ending");*/
    }

    //Method for test shoppingBag
   /* public void test_shoppingBag() {
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
*/

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
            Reporter.passMessage("The transition to the web " + nameNewPage + " page was done successfully ");
        } else {
            System.out.println("The transition to the web " + nameNewPage + " page was fail");
            Reporter.errorMessage("The transition to the web " + nameNewPage + " page was fail");
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
    /*public static void addScreenshot() throws IOException {
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
*/


}