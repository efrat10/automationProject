package pages;

import infra.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

//The class defines locators && methods for login page
   public class SignIntoNextPage {

   //WebDriver driver;

   //Locator for my account field
   private final By myAccountLocator = By.xpath("//header/div[1]/nav[1]/div[3]/div[2]/div[1]/a[1]/span[1]");

   //Locator for my email field
   private final By emailLocator = By.id("EmailOrAccountNumber");

   //Locator for my password field
   private final By passwordLocator = By.id("Password");

   //Locator for sign in button
   private final By signInButtonLocator = By.id("SignInNow");

  /* //constructor
   public SignIntoNextPage(WebDriver driver) {
           this.driver = driver;
       }*/

    //The method type email
    public void typeEmailId(String email) throws IOException, ParserConfigurationException, SAXException {
        Browser.getDriver().findElement(emailLocator).sendKeys(email);
    }

    //The method type password
    public void typePassword(String password) throws IOException, ParserConfigurationException, SAXException {
        Browser.getDriver().findElement(passwordLocator).sendKeys(password);
    }

    //The method click on sign in button
    public void clickSignInButton()
    {
        Browser.getDriver().findElement(signInButtonLocator).click();
    }

    //The method click on my account
    public void clickMyAccount()
    {
        Browser.getDriver().findElement(myAccountLocator).click();
    }

}
