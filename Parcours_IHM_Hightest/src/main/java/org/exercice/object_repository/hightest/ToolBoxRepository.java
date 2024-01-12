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
public class ToolBoxRepository {

    private final WebElement iSTQBFoundationFrenchButton = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/section/article/div[2]/div/div[1]/div/div[2]/div/a[1]"));

    public static ToolBoxRepository loadToolBoxContextObjects() {
        ToolBoxRepository toolBoxRepository = null;
        try {
            toolBoxRepository = new ToolBoxRepository();
            webElementsRepository.put("Button to access the ISTQB Foundation level quizz in French", toolBoxRepository.iSTQBFoundationFrenchButton);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "ToolBox page objects loading failed : " + e.getMessage());
        }
        return toolBoxRepository;
    }
}
