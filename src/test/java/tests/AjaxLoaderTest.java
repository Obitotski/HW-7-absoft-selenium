package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ajaxLoader.AjaxLoaderPage;

public class AjaxLoaderTest extends BaseTest {

    AjaxLoaderPage ajaxLoaderPage;

    @BeforeMethod
    public void openPage() {
        ajaxLoaderPage = new AjaxLoaderPage();
        BasePage.getDriver().get("http://webdriveruniversity.com/Ajax-Loader/index.html");
    }

    @Test
    public void verifyAppearanceOfButton() {
        ajaxLoaderPage.waitAppearanceOfClickMeButton();
        Assert.assertTrue(ajaxLoaderPage.isClickMeButtonAppeared(),
                "\"CLICK ME!\" button should appear after some waiting");
    }

    @Test
    public void verifyClickingTheButton() {
        ajaxLoaderPage.waitAppearanceOfClickMeButton();
        ajaxLoaderPage.clickMeButton();
        ajaxLoaderPage.waitAppearanceOfDialog();
        Assert.assertTrue(ajaxLoaderPage.isDialogAppeared(),
                "Dialog should appear after clicking");
    }

    @Test
    public void verifyPopUpMessage() {
        var expectedMessage = "Well Done For Waiting....!!!";

        ajaxLoaderPage.waitAppearanceOfClickMeButton();
        ajaxLoaderPage.clickMeButton();
        ajaxLoaderPage.waitAppearanceOfDialog();
        Assert.assertTrue(ajaxLoaderPage.isDialogWithExpectedMessage(expectedMessage),
                "Dialog should be with next message " + expectedMessage);
    }

    @Test
    public void verifyPopUpClosing() {
        ajaxLoaderPage.waitAppearanceOfClickMeButton();
        ajaxLoaderPage.clickMeButton();
        ajaxLoaderPage.waitAppearanceOfDialog();
        ajaxLoaderPage.closeDialog();
        Assert.assertTrue(ajaxLoaderPage.isDialogDisappeared(),
                "Dialog should disappear after clicking \"Close\" button");
    }
}