package org.exercice.actions.hightest;

import com.aventstack.extentreports.Status;
import org.exercice.object_repository.hightest.HighTestResultPageRepository;
import org.exercice.utils.AutomTools;
import org.openqa.selenium.NoSuchElementException;

import static org.exercice.utils.Reporter.testCase;

public class HightestResultPageAction {


    private static HighTestResultPageRepository highTestResultPageRepository;

    private static void loadResultPageContextObjects() {
        try {
            highTestResultPageRepository = new HighTestResultPageRepository();
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Hightest result page objects loading failed : " + e.getMessage());
        }
        testCase.log(Status.PASS, "Hightest result page objects loaded");
    }

    public void submitEmailAdressToReceiveResults(String adress) {
        loadResultPageContextObjects();
        highTestResultPageRepository.emailBox.sendKeys(adress);
    }

    public void clickOkayButton() {
        AutomTools.customClick(highTestResultPageRepository.submitButton);
    }

}
