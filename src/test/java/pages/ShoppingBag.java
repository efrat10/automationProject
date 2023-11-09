package pages;

import infra.Browser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ShoppingBag {
    //WebDriver driver;

    //Locator for quantity comboBox
    private final By comboBoxQtyLocator = By.xpath("/html[1]/body[1]/section[1]/section[1]/div[1]/section[1]/div[2]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/div[1]");

    //Locator for specific quantity (2)
    private final By specificQuantityLocator = By.xpath("/html[1]/body[1]/section[1]/section[1]/div[1]/section[1]/div[2]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/div[1]/ul[1]/li[2]");

    //Locator for The quantity shown in the bag image in the top toolbar
    private final By imgBagQtyLocator = By.xpath("//header/div[1]/nav[1]/div[6]/div[2]/div[1]/button[1]/span[1]");

    //Locator for 'Go to Checkout' button (after click 'view or edit bag' button)
    private final By goToCheckoutButton = By.xpath("//body/section[@id='ContentArea']/section[1]/div[1]/section[1]/div[2]/div[2]/a[1]");

    //constructor
    /*public ShoppingBag(WebDriver driver) {
        this.driver = driver;
    }*/

    //The method selects a certain quantity from comboBox
    public void selectQty(){
//        Select qty = new Select(driver.findElement(comboBoxQtyLocator));
//        qty.selectByIndex(index);
        Browser.getDriver().findElement(comboBoxQtyLocator).click();
        Browser.getDriver().findElement(specificQuantityLocator).click();
    }

    //The method check if quantity selection was updated in the shopping bag
    public boolean isQtyBugImgUpdate()
    {
        String actualQty = Browser.getDriver().findElement(imgBagQtyLocator).getText();
        String expectedQty = "3";
        return actualQty.equals(expectedQty);

    }

    //The method click on 'go to checkout'  button
    public void clickGoToCheckoutButton()
    {
        Browser.getDriver().findElement(goToCheckoutButton).click();
    }

}
