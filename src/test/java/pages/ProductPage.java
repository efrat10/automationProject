package pages;

import infra.Browser;
import infra.UiElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;
import utils.Utils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ProductPage {

    //Creating an object for comboBoxColor
    private final UiElement comboBoxColor = new UiElement("comboBoxColor",By.cssSelector("[id*=dk_container_Colour-] .dk_label"));
    //Imports a specific color from a config file for xpath of specificColor element
    private final String color = Utils.getData("CHOOSE_COLOR");
    //Creating an object for specificColor
    private final UiElement specificColor = new UiElement(color + " COLOR",By.xpath("//li/a[contains(text(),'"+color +"')]"));

    //Creating an object for comboBoxSize
    private final UiElement comboBoxSize = new UiElement("comboBoxSize",By.cssSelector("[id*='dk_container_Size']"));
    //Imports a specific size from a config file for xpath of specificColor element
    private final String size = Utils.getData("CHOOSE_SIZE");
    //Creating an object for specificSize
    private final UiElement specificSize = new UiElement(size ,By.xpath("//li/a[contains(text(),'"+size +"')]"));
    //Creating an object for 'add to bug' button
    private final UiElement addToBugBtn = new UiElement("'add to bug' button",By.xpath("//a[contains(text(),'Add To Bag')]"));
    //Creating an object for 'view edit Bag' button
    private final UiElement viewEditBagBtn = new UiElement("'view edit Bag' button",By.xpath("//a[contains(text(),'VIEW/EDIT BAG')]"));


    //Locator for comboBox 'quantity' (after click 'view or edit bag' button)
    private final By quantityDrpLocator = By.id("Qty_2");

    //Locator for 'checkout' green button (after click 'add to bag' button)
    private final By checkoutButtonLocator = By.xpath("//span[contains(text(),'CHECKOUT')]");

    public ProductPage() throws ParserConfigurationException, IOException, SAXException {
    }
    //The method selects a certain color from the list of sizes
    public void chooseColor(){
        comboBoxColor.click();
        Utils.waiting();
        specificColor.click();
        Utils.waiting();

    }
    //The method selects a certain size from the list of sizes
    public void chooseSize(){
        comboBoxSize.click();
        Utils.waiting();
        specificSize.click();
        Utils.waiting();
    }
    //The method click on 'add to bag' button
    public void clickAddToBagButton() {
        //Browser.getDriver().findElement(addToBagButtonLocator).click();
        addToBugBtn.click();
    }

    //The method click on 'VIEW/EDIT BAG' option
    public void clickViewEditBag(){
        viewEditBagBtn.click();
        Utils.waiting();
    }

/*

    //The method selects a certain size from the list of sizes
    public void clickSelectSize() throws InterruptedException {
        WebElement e1 = Browser.getDriver().findElement(sizeComboBoxLocator);
        e1.click();
        Thread.sleep(4000);
        WebElement e2 = Browser.getDriver().findElement(specificSizeLocator);
        e2.click();
    }

    //The method for select size from comboBox By visible
    public void selectSize(String size) {
        Select drpSize = new Select(Browser.getDriver().findElement(sizeComboBoxLocator));
        drpSize.selectByVisibleText(size);
    }

    //The method for select size from comboBox by index
    public void selectSize(int index) {
        Select drpSize = new Select(Browser.getDriver().findElement(sizeComboBoxLocator));
        drpSize.selectByIndex(index);
    }

    //The method click on 'add to bag' button
    public void clickAddToBagButton() {
        Browser.getDriver().findElement(addToBagButtonLocator).click();
    }

    //The method click on 'view or edit bag' button
    public void clickViewEditBag() {
        Browser.getDriver().findElement(viewEditBagButtonLocator).click();
    }

    //The method select quantity from drop down
    public void selectQuantity(String quantity) {
        Select drpQuantity = new Select(Browser.getDriver().findElement(quantityDrpLocator));
        drpQuantity.selectByVisibleText(quantity);
    }

*/

}
