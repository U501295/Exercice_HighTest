package org.exercice.object_repository.linkedin;

import com.aventstack.extentreports.Status;
import lombok.Getter;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.exercice.utils.ProjectRepository.webElementsRepository;
import static org.exercice.utils.Reporter.testCase;

@Getter
public class LinkedInHomePageRepository {

    private final WebElement emailBox = LocalDrivers.defaultProjectDriver.findElement(By.id("session_key"));
    private final WebElement passwordBox = LocalDrivers.defaultProjectDriver.findElement(By.id("session_password"));
    private final WebElement submitButton = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button"));

    public static LinkedInHomePageRepository loadLinkedInHomePageContextObjects() {
        LinkedInHomePageRepository homePageRepository = null;
        try {
            homePageRepository = new LinkedInHomePageRepository();
            webElementsRepository.put("Box where to put email in order to login on the LinkedIn website", homePageRepository.emailBox);
            webElementsRepository.put("Box where to put password in order to login on the LinkedIn website", homePageRepository.passwordBox);
            webElementsRepository.put("Submit button to login on the LinkedIn website", homePageRepository.submitButton);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "LinkedIn home page objects loading failed : " + e.getMessage());
        }
        return homePageRepository;
    }
}