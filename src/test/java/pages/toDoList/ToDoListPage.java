package pages.toDoList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.WebElementUtils;

public class ToDoListPage extends BasePage {

    @FindBy(css = "input[placeholder='Add new todo']")
    private WebElement textInputField;

    public ToDoListPage() {
        super();
    }

    private final String TASK_LOCATOR_TEMPLATE = "//li[contains(text(),'%s')]";
    public final String TASK_DELETE_BUTTON_LOCATOR_TEMPLATE = "//li[contains(text(),'%s')]/span";

    public void addNewTask(String textOfTask) {
        WebElementUtils.setValueAndEnter(textInputField, textOfTask);
    }

    public void deleteTask(String textOfTask) {
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(String.format(TASK_LOCATOR_TEMPLATE, textOfTask))))
                .moveToElement(WebElementUtils.findElement(By.xpath(String.format(TASK_DELETE_BUTTON_LOCATOR_TEMPLATE, textOfTask))))
                .click()
                .perform();
    }

    public boolean isNewTaskAdded(String textOfTask) {
        return WebElementUtils.isElementPresent(By.xpath(String.format(TASK_LOCATOR_TEMPLATE, textOfTask)));
    }

    public boolean isTaskDeleted(String textOfTask) {
        return !(WebElementUtils.isElementPresent(By.xpath(String.format(TASK_LOCATOR_TEMPLATE, textOfTask))));
    }
}