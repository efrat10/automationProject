package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import infra.Browser;
import infra.Reporter;
import infra.UiElement;
import org.openqa.selenium.By;
import testCases.Constants;
import utils.Utils;

//The class defines locators && methods for home page
public class HomePage {

    //Creating an object for 'Home' link from header bar
    private final UiElement homeHeaderLink = new UiElement("homeHeaderLink", By.cssSelector("[data-ga-v2='HOME']"), Constants.TITLE_HOME_PAGE);

    //Creating an object for 'Living room' link from the sidebar
    private final UiElement livingRoomLeftSidebar = new UiElement("livingRoomLeftSidebar", By.xpath("//a[contains(text(),'Living Room')][@class='sidebar-links']"), Constants.TITLE_LIVING_ROOM_PAGE);

    //Creating an object UiElement for 'Garden' link from middle bar
    private final UiElement gardenMiddleLink = new UiElement("gardenMiddleLink", By.linkText("Garden"), Constants.TITLE_GARDEN_PAGE);

    //Creating an object UiElement for language button
    private final UiElement languageBtn = new UiElement("languageBtn", By.cssSelector("[data-testid='header-country-lang-flag']"));

    //Creating an object UiElement for 'עברית' button
    private final UiElement hebrewBtn = new UiElement("hebrewBtn", By.xpath("//button[contains(text(),'עברית')]"));

    //Creating an object UiElement for 'SHOP NOW' button
    private final UiElement shopNowHeBtn = new UiElement("shopNowBtn", By.cssSelector("[data-testid='country-selector-CTA-button']"), Constants.TITLE_HEBREW_HOME_PAGE);

    //Object definition for test report
    private static ExtentTest test;


    public HomePage() {
        //Receiving Singleton Test
        test = Reporter.getInstance().getTest();

    }

    //The function performs clicks on various links from the 'home page',
    // and makes sure that they lead to the correct page
    public void clickOnLinksAndValidateTitle() {
        test.log(Status.INFO, "click on 'Home' link from header links ");
        homeHeaderLink.doubleClick();
        homeHeaderLink.isLinkTransitionTo();
        test.log(Status.INFO, "click on 'Living Room' link from left sidebar ");
        livingRoomLeftSidebar.doubleClick();
        livingRoomLeftSidebar.isLinkTransitionTo();
        Browser.getDriver().navigate().back();
        test.log(Status.INFO, "click on 'Garden' link from middle links ");
        gardenMiddleLink.doubleClick();
        gardenMiddleLink.isLinkTransitionTo();
        Browser.getDriver().navigate().back();

    }

    //The function changes the language from English to Hebrew, and verifies that the change was made successfully
    public void changeLanguage() {
        test.log(Status.INFO, "Change language from English to Hebrew ");
        languageBtn.click();
        Utils.waiting();
        hebrewBtn.click();
        Utils.waiting();
        shopNowHeBtn.doubleClick();
        shopNowHeBtn.isLinkTransitionTo();
        Utils.waiting();

    }

}
