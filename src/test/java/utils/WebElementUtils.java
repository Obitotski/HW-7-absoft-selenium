package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

public class WebElementUtils {

    public static boolean checkContentOfElementText(By locator, String expectedText) {
        if (WebElementUtils.isElementPresent(locator)) {
            return WebElementUtils.findElement(locator)
                    .getText()
                    .contains(expectedText);
        } else {
            return false;
        }
    }

    public static void setValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public static WebElement findElement(By locator) {
        if (isElementPresent(locator)) {
            return driver().findElement(locator);
        } else {
            throw new AssertionError("There is no element with such locator: " + locator);
        }
    }

    public static boolean isElementPresent(By locator) {
        return !(driver().findElements(locator).isEmpty());
    }

    private static WebDriver driver() {
        return BaseTest.getDriver();
    }
}