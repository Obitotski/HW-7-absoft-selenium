package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

public class WebElementUtils {

    public static boolean checkContentOfElementText(By locator, String expectedText) {
        return waiting(5).until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    public static void setValueAndEnter(WebElement element, String value) {
        setValue(element, value);
        element.sendKeys(Keys.ENTER);
    }

    public static void setValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public static WebElement findElement(By locator) {
        return waiting(5).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static List<WebElement> findElements(By locator) {
        return waiting(5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static boolean isElementPresent(By locator) {
        try {
            return !(waiting(3).until(ExpectedConditions.invisibilityOfElementLocated(locator)));
        } catch (TimeoutException timeoutException) {
            return true;
        }
    }

    private static WebDriverWait waiting(long timeToWait) {
        return new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(timeToWait));
    }
}