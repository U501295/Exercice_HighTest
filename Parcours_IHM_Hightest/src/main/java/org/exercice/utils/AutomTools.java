package org.exercice.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

@UtilityClass
public class AutomTools {

    public static void makeDriverChrome() {
        LocalDrivers.defaultProjectDriver = new ChromeDriver();
    }

    public static void driverImplicitWaitConfig(Duration duration) {
        LocalDrivers.defaultProjectDriver.manage().timeouts().implicitlyWait(duration);
    }

    public static void customClick(WebElement webElement) {
        Actions actions = new Actions(LocalDrivers.defaultProjectDriver);
        actions.moveToElement(webElement);
        actions.perform();
        webElement.click();

    }
}
