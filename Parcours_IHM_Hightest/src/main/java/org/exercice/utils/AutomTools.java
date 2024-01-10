package org.exercice.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;

@UtilityClass
public class AutomTools {

    public static void makeDriverChrome() {
        LocalDrivers.defaultProjectDriver = new ChromeDriver();
    }

    public static void closeDriver() {
        LocalDrivers.defaultProjectDriver.quit();
    }

    public static void driverImplicitWaitConfig(Duration duration) {
        LocalDrivers.defaultProjectDriver.manage().timeouts().implicitlyWait(duration);
    }

    private void configuredClick(WebElement webElement) {
        Actions actions = new Actions(LocalDrivers.defaultProjectDriver);
        actions.moveToElement(webElement);
        actions.perform();
        webElement.click();
    }

    public static void switchToggleFocus(Integer toggleNumber) {
        ArrayList<String> tabs = new ArrayList<>(LocalDrivers.defaultProjectDriver.getWindowHandles());
        LocalDrivers.defaultProjectDriver.switchTo().window(tabs.get(toggleNumber));
    }

    public static void customClick(WebElement webElement) {
        try {
            configuredClick(webElement);
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) LocalDrivers.defaultProjectDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            configuredClick(webElement);
        }
    }
}
