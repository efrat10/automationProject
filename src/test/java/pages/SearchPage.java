package pages;


import infra.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

//The class defines locators && methods for search page
public class SearchPage {
    //WebDriver driver;

    //Locator for field the search
    private By searchLocator = By.id("header-big-screen-search-box");


    //Locator for first choose in search (dress img)
    private By dress1Locator =By.xpath("//body/main[@id='next-plp-entrypoint']/div[@id='platform_modernisation_plp']/div[@id='plp']/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]");


    //constructor
    /*public SearchPage(WebDriver driver) {
        this.driver = driver;
    }*/

    //Method to type string for search
    public void typeSearch(String dataSearch)
    {
        Browser.getDriver().findElement(searchLocator).sendKeys(dataSearch);
        Browser.getDriver().findElement(searchLocator).sendKeys(Keys.ENTER);

    }

    //method for click on first choose btn (first dress img)
    public void doubleClickOndress1Img()
    {
        Actions act = new Actions(Browser.getDriver());
        act.doubleClick(Browser.getDriver().findElement(dress1Locator));
        act.build().perform();
    }
}
