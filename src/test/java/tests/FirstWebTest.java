package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import utils.WebElementUtils;

public class FirstWebTest extends BaseTest {

    @BeforeMethod
    public void openSite(){
        BasePage.getDriver().get("https://www.saucedemo.com/");
    }

    @Test
    public void verifyStandardUserCanNotAuthWithWrongPassword() {
        invalidAuth("standard_user", "12345",
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void verifyLockedOutUserCanNotAuth() {
        invalidAuth("locked_out_user", "secret_sauce",
                "Epic sadface: Sorry, this user has been locked out.");
    }

    private void invalidAuth(String userName, String password, String expectedErrorMessage) {
        WebElementUtils.setValue(WebElementUtils.findElement(By.id("user-name")), userName);
        WebElementUtils.setValue(WebElementUtils.findElement(By.id("password")), password);

        WebElementUtils.findElement(By.id("login-button")).click();

        var errorMessageLocator = By.cssSelector("h3[data-test='error']");

        Assert.assertTrue(WebElementUtils.checkContentOfElementText(errorMessageLocator, expectedErrorMessage),
                "Error message should be " + expectedErrorMessage);
    }
}

