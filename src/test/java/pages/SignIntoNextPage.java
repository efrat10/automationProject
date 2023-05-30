package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

   public class SignIntoNextPage {
   WebDriver driver;
    //
   private By myAccountLocator = By.xpath("//header/div[1]/nav[1]/div[3]/div[2]/div[1]/a[1]/span[1]");
   private By emailLocator = By.id("EmailOrAccountNumber");
   private By passwordLocator = By.id("Password");
   private By signInButtonLocator = By.id("SignInNow");

   //
   public SignIntoNextPage(WebDriver driver) {
           this.driver = driver;
       }

    public void typeEmailId(String email)
    {
        driver.findElement(emailLocator).sendKeys(email);
    }
    public void typePassword(String password)
    {
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void clickSignInButton()
    {
        driver.findElement(signInButtonLocator).click();
    }
    public void clickMyAccount()
    {
        driver.findElement(myAccountLocator).click();
    }


}
