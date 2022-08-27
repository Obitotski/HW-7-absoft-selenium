package pages.ajaxLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.WebElementUtils;

public class AjaxLoaderPage extends BasePage {

    @FindBy(xpath = "//p[contains(text(),'CLICK ME!')]")
    private WebElement clickMeButton;
    @FindBy(id = "myModalClick")
    private WebElement modalDialog;
    @FindBy(css = "h4[class=modal-title]")
    private WebElement modalDialogTitle;
    @FindBy(xpath = "//button[text()='Close']")
    private WebElement buttonToCloseDialog;

    private final By clickMeButtonLocator = By.xpath("//p[contains(text(),'CLICK ME!')]");
    private final By modalDialogLocator = By.id("myModalClick");

    public AjaxLoaderPage() {
        super();
    }

    public void waitAppearanceOfClickMeButton() {
        WebElementUtils.waiting(30).until(ExpectedConditions.visibilityOfElementLocated(clickMeButtonLocator));
    }

    public boolean isClickMeButtonAppeared() {
        return clickMeButton.isDisplayed();
    }

    public void clickMeButton() {
        clickMeButton.click();
    }

    public void waitAppearanceOfDialog() {
        WebElementUtils.waiting(30).until(ExpectedConditions.visibilityOfElementLocated(modalDialogLocator));
    }

    public boolean isDialogAppeared() {
        return modalDialog.isDisplayed();
    }

    public boolean isDialogWithExpectedMessage(String message) {
        return modalDialogTitle
                .getText()
                .contains(message);
    }

    public void closeDialog() {
        buttonToCloseDialog.click();
    }

    public boolean isDialogDisappeared() {
        return WebElementUtils.waiting(5).until(ExpectedConditions.invisibilityOfElementLocated(modalDialogLocator));
    }
}