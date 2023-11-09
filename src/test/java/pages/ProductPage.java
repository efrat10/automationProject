package pages;

import infra.Browser;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage {
    //WebDriver driver;


    //Locator for drop comboBox color
    private final By colorComboBoxLocator = By.xpath("//div[@id='dk_container_Colour-485269']");

    //Locator for specific color
    private final By specificColorLocator = By.linkText("Pink");


    //Locator for drop comboBox size
    private final By sizeComboBoxLocator = By.cssSelector("#dk_container_Size-M16-308");

    //Locator for specific size
    private final By specificSizeLocator = By.linkText("6-9 Months (UK ) (EU 68-74cm) - ₪ 137");


    //Locator for 'add to bug' button
    //private By addToBagButtonLocator = By.linkText("Add To Bag");
    private final By addToBagButtonLocator = By.xpath("//a[contains(text(),'Add To Bag')]");


    //Locator for 'view or edit bag' button (after click 'add to bag' button)
    private final By viewEditBagButtonLocator = By.xpath("//span[contains(text(),'VIEW/EDIT BAG')]");

    //Locator for comboBox 'quantity' (after click 'view or edit bag' button)
    private final By quantityDrpLocator = By.id("Qty_2");

    //Locator for 'checkout' green button (after click 'add to bag' button)
    private final By checkoutButtonLocator = By.xpath("//span[contains(text(),'CHECKOUT')]");


    //constructor
    /*public ProductPage(WebDriver driver) {
        this.driver = driver;
    }*/

       /* Select drpColor = new Select(driver.findElement(colorComboBoxLocator));
        driver.findElement(colorComboBoxLocator).click();
        driver.findElement(specificColorLocator).click();*/
    //The method for select color from comboBox
    public void selectColor(int index)
    {
        drpColor.selectByIndex(index);
    }
    //The method selects a certain color from the list of colors
    public void clickSelectColor()
    {
    }

        Select drpColor = new Select(Browser.getDriver().findElement(colorComboBoxLocator));

    public void selectColor(String color)
    {
        drpColor.selectByVisibleText(color);
    }

    //The method selects a certain size from the list of sizes
    public void clickSelectSize() throws InterruptedException {
        WebElement e1=Browser.getDriver().findElement(sizeComboBoxLocator);
        e1.click();
        Thread.sleep(4000);
        WebElement e2=Browser.getDriver().findElement(specificSizeLocator);
        e2.click();
    }

    //The method for select size from comboBox By visible
    public void selectSize(String size)
    {
        Select drpSize = new Select(Browser.getDriver().findElement(sizeComboBoxLocator));
        drpSize.selectByVisibleText(size);
    }

    //The method for select size from comboBox by index
    public void selectSize(int index)
    {
        Select drpSize = new Select(Browser.getDriver().findElement(sizeComboBoxLocator));
        drpSize.selectByIndex(index);
    }

    //The method click on 'add to bag' button
    public void clickAddToBagButton()
    {
        Browser.getDriver().findElement(addToBagButtonLocator).click();
    }

    //The method click on 'view or edit bag' button
    public void clickViewEditBag()
    {
        Browser.getDriver().findElement(viewEditBagButtonLocator).click();
    }

    //The method select quantity from drop down
    public void selectQuantity(String quantity)
    {
        Select drpQuantity = new Select(Browser.getDriver().findElement(quantityDrpLocator));
        drpQuantity.selectByVisibleText(quantity);
    }



}
