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
public class LinkedInContactsRepository {
    private final WebElement zoomedImageElement = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//img[@alt='Aperçu de la photo jointe']\n"));

    public static LinkedInContactsRepository loadContactsContextObjects() {
        LinkedInContactsRepository linkedInContactsRepository = null;
        try {
            linkedInContactsRepository = new LinkedInContactsRepository();
            webElementsRepository.put("Fullscreen image from the linkedIn chat when you click on it", linkedInContactsRepository.zoomedImageElement);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "LinkedIn contacts objects loading failed : " + e.getCause());
        }
        return linkedInContactsRepository;
    }
}