package org.exercice.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@UtilityClass
public class ProjectRepository {

    public static Map<String, WebElement> webElementsRepository = new HashMap<>();

    public static Map.Entry<String, WebElement> getWebElementFromProjectRepo(WebElement webElement) {
        Iterator iter = webElementsRepository.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            if (entry.getValue() == webElement) {
                return entry;
            }
        }
        return null;
    }
}
