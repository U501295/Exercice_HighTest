package org.exercice.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ProjectRepository {

    public static Map<String, WebElement> webElementsRepository = new HashMap<>();

    public static Map.Entry<String, WebElement> getWebElementFromProjectRepo(WebElement webElement) {
        for (Map.Entry<String, WebElement> entry : webElementsRepository.entrySet()) {
            if (entry.getValue() == webElement) {
                return entry;
            }
        }
        return null;
    }
}
