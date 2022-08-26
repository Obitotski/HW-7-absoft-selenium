package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.loginPortal.LoginPortalPage;

public class LoginPortalTest extends BaseTest {

    private LoginPortalPage loginPortalPage;

    @BeforeMethod
    public void openPage() {
        loginPortalPage = new LoginPortalPage();
        BasePage.getDriver().get("http://webdriveruniversity.com/Login-Portal/index.html");
    }

    @Test
    public void verifyInvalidAuthWithoutPassword() {
        loginPortalPage.setUsername("login");
        loginPortalPage.clickLoginButton();
        Assert.assertTrue(loginPortalPage.isAlertWithErrorMessagePresent(),
                "Alert with error message about auth problem should be present");
    }
}