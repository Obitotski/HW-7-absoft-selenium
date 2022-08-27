package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.dropCheckRadio.DropCheckRadioPage;

public class DropCheckRadioTest extends BaseTest {

    private DropCheckRadioPage dropCheckRadioPage;

    @BeforeMethod
    public void openPage() {
        dropCheckRadioPage = new DropCheckRadioPage();
        BasePage.getDriver().get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }

    @Test
    public void verifyDropDownMenus() {
        dropCheckRadioPage.chooseFromDropDownMenu("dropdowm-menu-1", "Java");
        Assert.assertTrue(dropCheckRadioPage.isDropDownMenuOptionSelected("dropdowm-menu-1", "Java"),
                "Dropdown menu option should be selected");

        dropCheckRadioPage.chooseFromDropDownMenu("dropdowm-menu-2", "TestNG");
        Assert.assertTrue(dropCheckRadioPage.isDropDownMenuOptionSelected("dropdowm-menu-2", "TestNG"),
                "Dropdown menu option should be selected");

        dropCheckRadioPage.chooseFromDropDownMenu("dropdowm-menu-3", "HTML");
        Assert.assertTrue(dropCheckRadioPage.isDropDownMenuOptionSelected("dropdowm-menu-3", "HTML"),
                "Dropdown menu option should be selected");
    }

    @Test
    public void verifyCheckboxes() {
        dropCheckRadioPage.clearAllCheckboxes();
        var checkBoxesToCheck = new String[]{"1", "4"};

        for (String checkBox : checkBoxesToCheck) {
            dropCheckRadioPage.checkCheckbox(checkBox);
            Assert.assertTrue(dropCheckRadioPage.isCheckboxChecked(checkBox),
                    "Checkbox " + checkBox + " should be checked");
        }
    }

    @Test
    public void verifyRadioButtons() {
        var radioButtonToChoose = "orange";

        dropCheckRadioPage.selectRadioButton(radioButtonToChoose);
        Assert.assertTrue(dropCheckRadioPage.isRadioButtonSelected(radioButtonToChoose),
                "Radio button " + radioButtonToChoose + " should be choose");
    }

    @Test
    public void verifySelectedAndDisabled() {
        Assert.assertTrue(dropCheckRadioPage.isRadioButtonSelected("Pumpkin"),
                "Radio button should be selected");
        Assert.assertTrue(dropCheckRadioPage.isRadioButtonDisabled("Cabbage"),
                "Radio button should be disabled");
        Assert.assertTrue(dropCheckRadioPage.isDropDownMenuOptionSelected("fruit-selects", "Grape"),
                "Dropdown menu option should be selected");
        Assert.assertTrue(dropCheckRadioPage.isDropDownMenuOptionDisabled("fruit-selects", "Orange"),
                "Dropdown menu option should be disabled");
    }
}