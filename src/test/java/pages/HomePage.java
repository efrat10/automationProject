package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    //The class defines locators && methods for home page

    WebDriver driver;

    //Locator for 'Home' link from header bar
    private By homeHeaderLinkLocator = By.xpath("//div[contains(text(),'home')]");

    //Locator for 'Living room' link from the sidebar
    private By livingRoomLeftSidebarLocator = By.xpath("//a[@id='left-sidebar-links2-ac2rqxfo9ddtlfhrh1o48ac1w']");

    //Locator for 'Garden' link from middle bar
    private By gardenlinkMiddleLocator = By.linkText("Garden");

    //Locator for 'Sport' link from header bar
    private By sportsHeaderlinkLocator = By.xpath("//div[contains(text(),'sports')]");

    ////Locator for language button
    private By languageBtnLocator = By.xpath("/html[1]/body[1]/div[2]/div[1]/section[1]/header[1]/div[1]/nav[1]/div[8]/div[1]/button[1]/img[1]");

    //Locator for 'עברית' button
    private By hebrewBtnLocator = By.xpath("//button[contains(text(),'עברית')]");

    ////Locator for 'SHOP NOW' button
    private By shopNowBtnLocator = By.xpath("//span[contains(text(),'SHOP NOW')]");

    //Constructor that will be automatically called as soon as the object of the class created
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to click double 'Home' link from Header bar
    public void doubleClickHomeHeaderLink()
    {
        Actions act =new Actions(driver);
        act.doubleClick(driver.findElement(homeHeaderLinkLocator));
        act.build().perform();
    }

    //Method to click double 'Living room' link from sidebar
    public void doubleClickLivingRoomLeftSidebar()
    {

        Actions act =new Actions(driver);
        act.doubleClick(driver.findElement(livingRoomLeftSidebarLocator));
        act.build().perform();

    }
    //Method to click double 'Living room' link from middle bar
    public void doubleClickGardenLinkMiddle()
    {
        Actions act =new Actions(driver);
        act.doubleClick(driver.findElement(gardenlinkMiddleLocator));
        act.build().perform();
    }

    //    //Method to click double 'Living room' link
    public void doubleClickSportsTitleLink()
    {
        Actions act = new Actions(driver);
        act.doubleClick(driver.findElement(sportsHeaderlinkLocator));
        act.build().perform();
    }

    //Method to click language button
    public void clickLanguageBtn()
    {
        driver.findElement(languageBtnLocator).click();
    }

    //Method to click hebrew button
    public void clickHebrewBtn()
    {
        driver.findElement(hebrewBtnLocator).click();
    }

    //Method to click 'SHOP NOW' button
    public void clickShopNowBtn()
    {
        driver.findElement(shopNowBtnLocator).click();
    }

}
