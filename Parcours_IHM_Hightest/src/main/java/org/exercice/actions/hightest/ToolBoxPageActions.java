package org.exercice.actions.hightest;

import com.aventstack.extentreports.Status;
import org.exercice.object_repository.hightest.ToolBoxRepository;
import org.exercice.utils.AutomTools;
import org.openqa.selenium.NoSuchElementException;

import static org.exercice.utils.Reporter.testCase;

public class ToolBoxPageActions {

    private static ToolBoxRepository toolBoxRepository;

    private static void loadToolBoxContextObjects() {
        try {
            toolBoxRepository = new ToolBoxRepository();
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "ToolBox page objects loading failed : " + e.getMessage());
        }
        testCase.log(Status.PASS, "Toolbox page objects loaded");
    }

    public void clickISTQBFoundationFrenchButton() {
        loadToolBoxContextObjects();
        AutomTools.customClick(toolBoxRepository.iSTQBFoundationFrenchButton);
    }
}
