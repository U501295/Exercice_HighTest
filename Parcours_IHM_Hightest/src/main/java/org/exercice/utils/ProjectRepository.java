package org.exercice.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

//This class will be used to contain all the webElements needed for an action to be performed,
//each webElement will be added with its actual value and a description for reporting purposes
@UtilityClass
public class ProjectRepository {


    public static Map<String, WebElement> webElementsRepository = new HashMap<>();

    //This function allows to recover any webElement with its associated description
    public static Map.Entry<String, WebElement> getWebElementFromProjectRepo(WebElement webElement) {
        for (Map.Entry<String, WebElement> entry : webElementsRepository.entrySet()) {
            if (entry.getValue() == webElement) {
                return entry;
            }
        }
        return null;
    }
}
