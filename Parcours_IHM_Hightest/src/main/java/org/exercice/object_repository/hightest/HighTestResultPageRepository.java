package org.exercice.object_repository.hightest;

import com.aventstack.extentreports.Status;
import lombok.Getter;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.exercice.utils.ProjectRepository.webElementsRepository;
import static org.exercice.utils.Reporter.testCase;

@Getter
public class HighTestResultPageRepository {

    private final WebElement emailBox = LocalDrivers.defaultProjectDriver.findElement(By.id("email"));
    private final WebElement submitButton = LocalDrivers.defaultProjectDriver.findElement(By.id("submitMail"));

    public static HighTestResultPageRepository loadResultPageContextObjects() {
        HighTestResultPageRepository highTestResultPageRepository = null;
        try {
            highTestResultPageRepository = new HighTestResultPageRepository();
            webElementsRepository.put("Hightest result page email box", highTestResultPageRepository.emailBox);
            webElementsRepository.put("Hightest result page submit button", highTestResultPageRepository.submitButton);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Hightest result page objects loading failed : " + e.getMessage());
        }
        return highTestResultPageRepository;
    }
}
