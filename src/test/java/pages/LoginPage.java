package pages;

import infra.UiElement;
import org.openqa.selenium.By;
import utils.Utils;

public class LoginPage {

    //Creating an object for email input
    private final UiElement emailInput = new UiElement("email input", By.cssSelector("#EmailOrAccountNumber"));

    //Creating an object for password input
    private final UiElement passwordInput = new UiElement("password input", By.cssSelector("#Password"));

    //The method get email and password and fills the fields
    public void fillPage(String email, String password) {
        emailInput.input(email);
        passwordInput.input(password);
        Utils.waiting();
    }

}
