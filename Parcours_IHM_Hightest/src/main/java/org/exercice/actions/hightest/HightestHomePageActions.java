package org.exercice.actions.hightest;

import com.aventstack.extentreports.Status;
import org.exercice.object_repository.hightest.HightestHomePageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.NoSuchElementException;

import static org.exercice.utils.Reporter.testCase;

public class HightestHomePageActions {
    private static HightestHomePageRepository homePageRepository;

    private static void loadHomePageContextObjects() {
        try {
            homePageRepository = new HightestHomePageRepository();
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Hightest home page objects loading failed : " + e.getMessage());
        }
        testCase.log(Status.PASS, "Hightest home page objects loaded");
    }

    public void getToHomePage(String url) {
        LocalDrivers.defaultProjectDriver.get(url);
        LocalDrivers.defaultProjectDriver.manage().window().maximize();
    }

    public void clickToolBoxButton() {
        loadHomePageContextObjects();
        AutomTools.customClick(homePageRepository.toolboxButton);
    }
}
