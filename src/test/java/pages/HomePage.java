package pages;

import infra.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

//The class defines locators && methods for home page
public class HomePage {


    //WebDriver driver;

    //Locator for 'Home' link from header bar
    private final By homeHeaderLinkLocator = By.xpath("//div[contains(text(),'home')]");

    //Locator for 'Living room' link from the sidebar
    //private By livingRoomLeftSidebarLocator = By.xpath("//a[@id='left-sidebar-links2-day9op72hb9800ohcjowdvg5c']");
    private final By livingRoomLeftSidebarLocator = By.id("left-sidebar-links2-613chwkk75gxwdh1w07g191i0");

    //Locator for 'Garden' link from middle bar
    private final By gardenlinkMiddleLocator = By.linkText("Garden");

    //Locator for 'Sport' link from header bar
    private final By sportsHeaderlinkLocator = By.xpath("//div[contains(text(),'sports')]");

    ////Locator for language button
    private final By languageBtnLocator = By.xpath("/html[1]/body[1]/div[2]/div[1]/section[1]/header[1]/div[1]/nav[1]/div[8]/div[1]/button[1]/img[1]");

    //Locator for 'עברית' button
    private final By hebrewBtnLocator = By.xpath("//button[contains(text(),'עברית')]");

    //Locator for 'SHOP NOW' button
    private final By shopNowBtnLocator = By.xpath("//span[contains(text(),'SHOP NOW')]");




    //Constructor that will be automatically called as soon as the object of the class created
   /* public HomePage(WebDriver driver) {
        this.driver = driver;
    }*/

    //Method to click double 'Home' link from Header bar
    public void doubleClickHomeHeaderLink()
    {
        Actions act =new Actions(Browser.getDriver());
        act.doubleClick(Browser.getDriver().findElement(homeHeaderLinkLocator));
        act.build().perform();
    }

    //Method to click double 'Living room' link from sidebar
    public void doubleClickLivingRoomLeftSidebar()
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
    }

    //Method to click double 'Sports' link
    public void doubleClickSportsTitleLink()
    {
        Actions act = new Actions(Browser.getDriver());
        act.doubleClick(Browser.getDriver().findElement(sportsHeaderlinkLocator));
        act.build().perform();
    }

    //Method to click language button
    public void clickLanguageBtn()
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
    }

}
