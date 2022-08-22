package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.toDoList.ToDoListPage;

public class ToDoListTest extends BaseTest{

    private ToDoListPage toDoListPage;

    @BeforeMethod
    public void openPage(){
        toDoListPage = new ToDoListPage();
        BasePage.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    public void verifyAddingOfNewTaskToToDoList() {
        String textOfNewTask = "My new task";

        toDoListPage.addNewTask(textOfNewTask);

        Assert.assertTrue(toDoListPage.isNewTaskAdded(textOfNewTask),
                "New task: " + textOfNewTask + " should be added to the To-Do List");
    }

    @Test
    public void verifyDeletingOfTaskFromToDoList() {
        String textOfTaskToDelete = "Task for deleting";

        toDoListPage.addNewTask(textOfTaskToDelete);

        Assert.assertTrue(toDoListPage.isNewTaskAdded(textOfTaskToDelete),
                "New task: " + textOfTaskToDelete + " should be added to the To-Do List");

        toDoListPage.deleteTask(textOfTaskToDelete);

        Assert.assertTrue(toDoListPage.isTaskDeleted(textOfTaskToDelete),
                "This task " + textOfTaskToDelete + " should be deleted");
    }
}