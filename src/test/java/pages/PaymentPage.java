package pages;

import infra.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    //WebDriver driver;

    //Locator for radio creditCard
    //private By creditRadioLocator = By.xpath("//body/section[@id='ContentArea']/section[1]/div[1]/div[1]/div[1]/div[4]/form[1]/div[3]/ul[1]/li[3]/div[1]/input[1]");
    private By creditRadioLocator = By.id("PaymentId");

    //Locator for cardNumber input
    private By cardNumberInputLocator = By.id("cardNumber");

    //Locator for cardholder's name
    private By nameOfCardholderLocator = By.id("cardholderName");

    //Locator for a month expiry date input
    private By monthExpiryDateInputLocator = By.id("expiryMonth");

    //Locator for a year expiry date input
    private By yearExpiryDateInputLocator = By.id("expiryYear");

    //Locator for a security code input
    private By securityCodeInputLocator = By.id("securityCode");

    //Locator for 'pay now' button
    private By payNowButtonLocator = By.id("submitButton");

    //constructor
    /*public PaymentPage(WebDriver driver) {
        this.driver = driver;

    }*/

    //Method for select radio creditCard
    public void selectCreditCardRadio() throws InterruptedException {
        WebElement creditCardRadio = Browser.getDriver().findElement(creditRadioLocator);
        boolean selectedValue = creditCardRadio.isSelected();
        if(!selectedValue)
            creditCardRadio.click();
    }

    //The method type card number
    public void typeCardNumber(String cardNumberTest) throws InterruptedException {
        WebElement cardNumberInput = Browser.getDriver().findElement(cardNumberInputLocator);
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNumberTest);
    }

    //The method type cardholder's name
    public void typeNameOfCardholder(String name)
    {
        WebElement nameCardholderInput = Browser.getDriver().findElement(nameOfCardholderLocator);
        nameCardholderInput.clear();
        nameCardholderInput.sendKeys(name);
    }

    //The method type month expiry
    public void typeMonthExpiry(String monthExpiryTest)
    {
        WebElement monthExpiryInput = Browser.getDriver().findElement(monthExpiryDateInputLocator);
        monthExpiryInput.clear();
        monthExpiryInput.sendKeys(monthExpiryTest);
    }


    //The method type year expiry
    public void typeYearExpiry(String yearExpiryTest)
    {
        WebElement yearExpiryInput = Browser.getDriver().findElement(yearExpiryDateInputLocator);
        yearExpiryInput.clear();
        yearExpiryInput.sendKeys(yearExpiryTest);
    }

    //The method type security code
    public void securityCode(String securityCodeTest)
    {
        WebElement securityCodeInput = Browser.getDriver().findElement(securityCodeInputLocator);
        securityCodeInput.clear();
        securityCodeInput.sendKeys(securityCodeTest);
    }

    //The method click on 'pay now' button
    public void clickPayOnButton(){
        Browser.getDriver().findElement(payNowButtonLocator).click();
    }









}
