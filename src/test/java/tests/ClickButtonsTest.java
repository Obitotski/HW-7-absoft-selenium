package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ClickButtons.ClickButtonsPage;

public class ClickButtonsTest extends BaseTest {

    private ClickButtonsPage clickButtonsPage;

    @BeforeMethod
    public void openPage() {
        clickButtonsPage = new ClickButtonsPage();
        BasePage.getDriver().get("http://webdriveruniversity.com/Click-Buttons/index.html");
    }

    @Test
    public void verifyWebElementClick() {
        clickButtonsPage.clickClickButton();
        Assert.assertTrue(clickButtonsPage.isPopUpForSuccessfulWebElementClickAppeared(),
                "Pop Up with Success message should be displayed after successful WebElement click");
    }

    @Test
    public void verifyJsClick() {
        clickButtonsPage.clickJsClickButton();
        Assert.assertTrue(clickButtonsPage.isPopUpForSuccessfulJsClickAppeared(),
                "Pop Up with Success message should be displayed after successful JavaScript click");
    }

    @Test
    public void verifyActionClick() {
        clickButtonsPage.clickActionClickButton();
        Assert.assertTrue(clickButtonsPage.isPopUpForSuccessfulActionClickAppeared(),
                "Pop Up with Success message should be displayed after successful Action click");
    }
}