package pages.loginPortal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.WebElementUtils;

public class LoginPortalPage extends BasePage {

    @FindBy(id = "text")
    private WebElement usernameInputField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPortalPage() {
        super();
    }

    public void setUsername(String username) {
        WebElementUtils.setValue(usernameInputField, username);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isAlertWithErrorMessagePresent() {
        return driver
                .switchTo()
                .alert()
                .getText()
                .contains("validation failed");
    }
}