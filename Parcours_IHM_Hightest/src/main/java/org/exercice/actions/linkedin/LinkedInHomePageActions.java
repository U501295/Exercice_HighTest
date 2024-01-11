package org.exercice.actions.linkedin;

import com.aventstack.extentreports.Status;
import org.exercice.object_repository.linkedin.LinkedInHomePageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.NoSuchElementException;

import static org.exercice.utils.Reporter.testCase;

public class LinkedInHomePageActions {

    private static LinkedInHomePageRepository homePageRepository;

    private static void loadContextObjects() {
        try {
            homePageRepository = new LinkedInHomePageRepository();
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "LinkedIn home page objects loading failed : " + e.getMessage());
        }
        testCase.log(Status.PASS, "LinkedIn home page objects loaded");
    }

    public void getToHomePage(String url) {
        LocalDrivers.defaultProjectDriver.get(url);
        LocalDrivers.defaultProjectDriver.manage().window().maximize();
    }

    public void submitLinkedInConnectionInformations(String email, String password) {
        loadContextObjects();
        homePageRepository.emailBox.sendKeys(email);
        homePageRepository.passwordBox.sendKeys(password);
        AutomTools.customClick(homePageRepository.submitButton);
    }
}
