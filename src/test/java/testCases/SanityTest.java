///////////////////jjjjjjjjjjjjj
package testCases;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pages.HomePage;
import pages.SignIntoNextPage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SanityTest {
    //The class performs sanity tests for the 'next' site

    private static WebDriver driver;
    private String expectedTitle;
    private String message;

    @BeforeClass
    public static void beforeClass() throws ParserConfigurationException, IOException, SAXException {

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chrome\\chromedriver107.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getData("URL"));

    }

    //The test method performs sanity test for login page
    @Test
    public void verifyLogin() throws InterruptedException, ParserConfigurationException, IOException, SAXException {

        //creating object for sign in page
        SignIntoNextPage login = new SignIntoNextPage(driver);

        waiting();

        //click on login button
        login.clickMyAccount();

        //waiting method
        waiting();

        //checking if the clicking on login button successful
        expectedTitle = "Sign In | My Account | Next Directory Online";
        message = "The Login to link 'my account'";
        equals(message,expectedTitle);
        waiting();

        //Enter email && password
        login.typeEmailId(getData("EMAIL"));
        login.typePassword(getData("PASSWORD"));

        //click on sign in button
        login.clickSignInButton();
        waiting();

    }

    @Test
    //The test performs sanity test on the home page
    public void sanityHomePage() throws InterruptedException {

        //create object of HomePage
        HomePage homePage = new HomePage(driver);

        waiting();

        //click on 'Home' link from header links
        homePage.doubleClickHomeHeaderLink();

        //checking if the clicking on Home link successful
        message = "The clicking on the link 'Home' in the header";
        expectedTitle = "Furniture & Homeware | Home & Garden | Next Israel";
        equals(message,expectedTitle);
        waiting();

//        //click on Living room link from left sidebar
//        homePage.doubleClickLivingRoomLeftSidebar();
//        message = "Entering the link 'Living room' from the left side bar";
//        expectedTitle = "Living Room | All Living Room Accessories | Next Israel";
//        equals(message,expectedTitle);
//        driver.navigate().back();
//
//        //A reference to the function that will test if navigate to home page successful
//        isSuccessNavigateToHomePage();


        //click on 'Garden' link from Middle bar
        homePage.doubleClickGardenLinkMiddle();

        //checking if the clicking on Home link successful
        message = "Entering the link 'Garden' from the middle bar";
        expectedTitle = "Garden & Outdoors | Garden Furniture Sets & Accessories | Next";
        equals(message,expectedTitle);

        //navigate to Home page
        driver.navigate().back();

        //A reference to the function that will test if navigate to home page successful
        isSuccessNavigateToHomePage();

        waiting();

        //click on Sport link from header links
        homePage.doubleClickSportsTitleLink();
        message = "Entering the link 'Sport' from title link";
        expectedTitle = "Sportswear | Gym Clothing | Next Israel";
        equals(message,expectedTitle);

        //navigate to Home page
        driver.navigate().back();

        //A reference to the function that will test if navigate to home page successful
        isSuccessNavigateToHomePage();


        //for changing language to hebrew
        homePage.clickLanguageBtn();
        homePage.clickHebrewBtn();
        homePage.clickShopNowBtn();

        //checking if the changing language successful
        equals("Changing the language to Hebrew","נקסט ישראל | קנו אופנה והלבשה באינטרנט");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();
    }

    //The method waiting 4000 millis
    private void waiting() throws InterruptedException {
        Thread.sleep(4000);
    }

    //The method equals between actual title to expected title
    private void equals(String message,String expected) throws InterruptedException {
        System.out.println();
        waiting();
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle: " + actualTitle);
        Assert.assertEquals(message+ " was fail",expected,actualTitle);
        System.out.println(message + " was done successfully");

    }

    //The method check if navigate to home page successful
    private void isSuccessNavigateToHomePage() throws InterruptedException {
        equals("The navigate to Home page","Furniture & Homeware | Home & Garden | Next Israel");

    }

    //The method for reading from file
    private static String getData (String keyName) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File("C:\\Users\\User\\IdeaProjects\\automationProjectForTheNextSite\\config (1).xml");

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