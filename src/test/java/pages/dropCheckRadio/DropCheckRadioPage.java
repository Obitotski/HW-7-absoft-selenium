package pages.dropCheckRadio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.WebElementUtils;

public class DropCheckRadioPage extends BasePage {

    private final String DROPDOWN_MENU_OPTION_LOCATOR_TEMPLATE = "option[value='%s']";
    private final String CHECKBOX_LOCATOR_TEMPLATE = "input[value=option-%s]";
    private final String RADIO_BUTTON_LOCATOR_TEMPLATE = "input[value=%s]";

    public DropCheckRadioPage() {
        super();
    }

    public void chooseFromDropDownMenu(String dropDownMenuId, String option) {
        WebElementUtils.findElement(By.id(dropDownMenuId)).click();
        WebElementUtils.findElement(By.cssSelector(String.format(DROPDOWN_MENU_OPTION_LOCATOR_TEMPLATE, option.toLowerCase()))).click();
    }

    public boolean isDropDownMenuOptionSelected(String dropDownMenuId, String option) {
        WebElementUtils.findElement(By.id(dropDownMenuId)).click();
        return WebElementUtils.findElement(By.cssSelector(String.format(DROPDOWN_MENU_OPTION_LOCATOR_TEMPLATE, option.toLowerCase()))).isSelected();
    }

    public boolean isDropDownMenuOptionDisabled(String dropDownMenuId, String option) {
        WebElementUtils.findElement(By.id(dropDownMenuId)).click();
        return !(WebElementUtils.findElement(By.cssSelector(String.format(DROPDOWN_MENU_OPTION_LOCATOR_TEMPLATE, option.toLowerCase()))).isEnabled());
    }

    public void clearAllCheckboxes() {
        var checkedCheckboxesLocator = "//input[@value and @checked]";
        var checkedCheckboxes = WebElementUtils.findElements(By.xpath(checkedCheckboxesLocator));
        if (!checkedCheckboxes.isEmpty()) {
            checkedCheckboxes.forEach(WebElement::click);
        }
    }

    public void checkCheckbox(String index) {
        WebElementUtils.findElement(By.cssSelector(String.format(CHECKBOX_LOCATOR_TEMPLATE, index))).click();
    }

    public boolean isCheckboxChecked(String index) {
        var checkbox = WebElementUtils.findElement(By.cssSelector(String.format(CHECKBOX_LOCATOR_TEMPLATE, index)));
        return checkbox.isSelected();
    }

    public void selectRadioButton(String option) {
        WebElementUtils.findElement(By.cssSelector(String.format(RADIO_BUTTON_LOCATOR_TEMPLATE, option.toLowerCase()))).click();
    }

    public boolean isRadioButtonSelected(String option) {
        return WebElementUtils.findElement(By.cssSelector(String.format(RADIO_BUTTON_LOCATOR_TEMPLATE, option.toLowerCase()))).isSelected();
    }

    public boolean isRadioButtonDisabled(String option) {
        return !(WebElementUtils.findElement(By.cssSelector(String.format(RADIO_BUTTON_LOCATOR_TEMPLATE, option.toLowerCase()))).isEnabled());
    }
}