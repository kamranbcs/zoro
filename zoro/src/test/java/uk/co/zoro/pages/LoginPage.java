package uk.co.zoro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.zoro.drivers.DriverManager;

public class LoginPage extends DriverManager {

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "[type='submit']")
    WebElement submitButton;

    @FindBy(css = ".NewLoginForm_NewLogin_loginError__5Ngwo")
    WebElement invalidUserPassMessage;

    @FindBy(css = ".ToastWrapperComponent_ToastWrapper_ToastMessage__ziD_0")
    WebElement loginMessage;

    public void enterEmail(String emailTxt) {
        email.sendKeys(emailTxt);
    }

    public void enterPassword(String passwordTxt) {
        password.sendKeys(passwordTxt);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getLoginMessage() {
        loginMessage.click();
        return loginMessage.getText();
    }

    public String getInvalidUserPassMessage() {
        return invalidUserPassMessage.getText();
    }

}
