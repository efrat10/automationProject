package pages;

import com.aventstack.extentreports.ExtentTest;
import infra.Browser;
import infra.ExtendReport;
import infra.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.xml.sax.SAXException;
import testCases.Constants;
import utils.Utils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

//The class defines locators && methods for home page
public class HomePage {


    //WebDriver driver;

    //Locator for 'Home' link from header bar
    //private final By homeHeaderLinkLocator = By.xpath("//div[contains(text(),'home')]");

    //private final UiElement homeHeaderLink = new UiElement("homeHeaderLink",By.xpath("//div[contains(text(),'HOME')]"), Constants.TITLE_HOME_PAGE);
    private final UiElement homeHeaderLink = new UiElement("homeHeaderLink",By.cssSelector("[data-ga-v2='HOME']"), Constants.TITLE_HOME_PAGE);

    //Locator for 'Living room' link from the sidebar
    //private By livingRoomLeftSidebarLocator = By.xpath("//a[@id='left-sidebar-links2-day9op72hb9800ohcjowdvg5c']");
    //private final By livingRoomLeftSidebarLocator = By.id("left-sidebar-links2-613chwkk75gxwdh1w07g191i0");
    //private final UiElement livingRoomLeftSidebar = new UiElement("livingRoomLeftSidebar",By.id("left-sidebar-links2-613chwkk75gxwdh1w07g191i0"),Constants.TITLE_LIVING_ROOM_PAGE);
    //private final UiElement livingRoomLeftSidebar = new UiElement("livingRoomLeftSidebar",By.cssSelector("#left-sidebar-links4-877vry0ke29yyvl60ut1powgf"),Constants.TITLE_LIVING_ROOM_PAGE);
    private final UiElement livingRoomLeftSidebar = new UiElement("livingRoomLeftSidebar",By.xpath("//a[contains(text(),'Living Room')][@class='sidebar-links']"),Constants.TITLE_LIVING_ROOM_PAGE);


    //Locator for 'Garden' link from middle bar
    //private final By gardenlinkMiddleLocator = By.linkText("Garden");
    private final UiElement gardenMiddleLink = new UiElement("gardenMiddleLink",By.linkText("Garden"),Constants.TITLE_GARDEN_PAGE);

    //Locator for 'Sport' link from header bar
    //private final By sportsHeaderlinkLocator = By.xpath("//div[contains(text(),'sports')]");
    private final UiElement sportsHeaderlink = new UiElement("sportsHeaderLink",By.xpath("//div[contains(text(),'sports')])"),Constants.TITLE_SPORT_PAGE);


    ////Locator for language button
    //private final By languageBtnLocator = By.xpath("/html[1]/body[1]/div[2]/div[1]/section[1]/header[1]/div[1]/nav[1]/div[8]/div[1]/button[1]/img[1]");
    private final UiElement languageBtn = new UiElement("languageBtn",By.cssSelector("[data-testid='header-country-lang-flag']"));

    //Locator for 'עברית' button
    //private final By hebrewBtnLocator = By.xpath("//button[contains(text(),'עברית')]");
    private final UiElement hebrewBtn = new UiElement("hebrewBtn",By.xpath("//button[contains(text(),'עברית')]"));

    //Locator for 'SHOP NOW' button
    //private final By shopNowBtnLocator = By.xpath("//span[contains(text(),'SHOP NOW')]");
    private final UiElement shopNowHeBtn = new UiElement("shopNowBtn",By.cssSelector("[data-testid='country-selector-CTA-button']"),Constants.TITLE_HEBREW_HOME_PAGE);
    private static ExtentTest test;


    public HomePage() {
        test= ExtendReport.getInstance().getTest();

    }

    public void clickOnLinksAndValidateTitle() throws IOException, ParserConfigurationException, SAXException {
        homeHeaderLink.doubleClick();
        homeHeaderLink.isLinkTransitionTo();

        livingRoomLeftSidebar.doubleClick();
        livingRoomLeftSidebar.isLinkTransitionTo();
        Browser.getDriver().navigate().back();
        gardenMiddleLink.doubleClick();
        gardenMiddleLink.isLinkTransitionTo();
        Browser.getDriver().navigate().back();
        /*sportsHeaderlink.doubleClick();
        sportsHeaderlink.isLinkTransitionTo();*/

    }

    public void changeLanguage() throws IOException, ParserConfigurationException, SAXException {
        languageBtn.click();
        Utils.waiting();
        hebrewBtn.click();
        Utils.waiting();
        shopNowHeBtn.doubleClick();
        shopNowHeBtn.isLinkTransitionTo();
        Utils.waiting();

    }

    //Constructor that will be automatically called as soon as the object of the class created
   /* public HomePage(WebDriver driver) {
        this.driver = driver;
    }*/

    //Method to click double 'Home' link from Header bar
    /*public void doubleClickHomeHeaderLink()
    {
        Actions act =new Actions(Browser.getDriver());
        act.doubleClick(Browser.getDriver().findElement(homeHeaderLinkLocator));
        act.build().perform();
    }
*/
    //Method to click double 'Living room' link from sidebar
    /*public void doubleClickLivingRoomLeftSidebar()
    {
        Actions act =new Actions(Browser.getDriver());
        act.doubleClick(Browser.getDriver().findElement(livingRoomLeftSidebarLocator));
        act.build().perform();
    }
    //Method to click double 'Living room' link from middle bar
    public void doubleClickGardenLinkMiddle()
    {
        Actions act =new Actions(Browser.getDriver());
        act.doubleClick(Browser.getDriver().findElement(gardenlinkMiddleLocator));
        act.build().perform();
    }*/

    //Method to click double 'Sports' link
    /*public void doubleClickSportsTitleLink()
    {
        Actions act = new Actions(Browser.getDriver());
        act.doubleClick(Browser.getDriver().findElement(sportsHeaderlinkLocator));
        act.build().perform();
    }*/

    //Method to click language button
   /* public void clickLanguageBtn()
    {
        Browser.getDriver().findElement(languageBtnLocator).click();
    }

    //Method to click hebrew button
    public void clickHebrewBtn()
    {
        Browser.getDriver().findElement(hebrewBtnLocator).click();
    }

    //Method to click 'SHOP NOW' button
    public void clickShopNowBtn()
    {
        Browser.getDriver().findElement(shopNowBtnLocator).click();
    }*/

}
