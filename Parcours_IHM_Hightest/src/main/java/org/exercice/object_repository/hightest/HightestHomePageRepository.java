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
public class HightestHomePageRepository {
    private final WebElement toolboxButton = LocalDrivers.defaultProjectDriver.findElement(By.id("menu-item-33"));
    private final WebElement contactButton = LocalDrivers.defaultProjectDriver.findElement(By.id("menu-item-31"));
    public static HightestHomePageRepository loadHomePageContextObjects() {
        HightestHomePageRepository homePageRepository = null;
        try {
            homePageRepository = new HightestHomePageRepository();
            webElementsRepository.put("Hightest home page toolbox button", homePageRepository.toolboxButton);
            webElementsRepository.put("Hightest home page contact button", homePageRepository.contactButton);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Hightest home page objects loading failed : " + e.getCause());
        }
        return homePageRepository;
    }
}
