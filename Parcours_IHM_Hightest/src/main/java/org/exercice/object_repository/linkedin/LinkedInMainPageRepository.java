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
public class LinkedInMainPageRepository {

    private final WebElement chatContactJulienBaroni = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//h3[contains(.,'Julien Baroni')]"));

    public static LinkedInMainPageRepository loadMainPageContextObjects() {
        LinkedInMainPageRepository linkedInMainPageRepository = null;
        try {
            linkedInMainPageRepository = new LinkedInMainPageRepository();
            webElementsRepository.put("chat window with the contact Julien Baroni on LinkedIn", linkedInMainPageRepository.chatContactJulienBaroni);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "LinkedIn main page objects loading failed : " + e.getMessage());
        }
        return linkedInMainPageRepository;
    }
}