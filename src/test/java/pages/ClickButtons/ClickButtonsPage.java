package pages.ClickButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.WebElementUtils;

public class ClickButtonsPage extends BasePage {

    @FindBy(id = "button1")
    private WebElement clickButton;
    @FindBy(id = "button2")
    private WebElement jsClickButton;
    @FindBy(id = "button3")
    private WebElement actionClickButton;

    private final By clickPopUpLocator = By.id("myModalClick");
    private final By jsClickPopUpLocator = By.id("myModalJSClick");
    private final By actionClickPopUpLocator = By.id("myModalMoveClick");

    public ClickButtonsPage() {
        super();
    }

    public void clickClickButton() {
        clickButton.click();
    }

    public boolean isPopUpForSuccessfulWebElementClickAppeared() {
        return isButtonClickedAndPopUpAppeared(clickPopUpLocator);
    }

    public void clickJsClickButton() {
        var jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click()", jsClickButton);
    }

    public boolean isPopUpForSuccessfulJsClickAppeared() {
        return isButtonClickedAndPopUpAppeared(jsClickPopUpLocator);
    }

    public void clickActionClickButton() {
        new Actions(driver)
                .click(actionClickButton)
                .perform();
    }

    public boolean isPopUpForSuccessfulActionClickAppeared() {
        return isButtonClickedAndPopUpAppeared(actionClickPopUpLocator);
    }

    private boolean isButtonClickedAndPopUpAppeared(By locator) {
        return WebElementUtils
                .waiting(5)
                .until(ExpectedConditions.visibilityOfElementLocated(locator))
                .isDisplayed();
    }
}