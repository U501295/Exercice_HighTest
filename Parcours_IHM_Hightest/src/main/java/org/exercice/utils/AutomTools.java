package org.exercice.utils;

import com.aventstack.extentreports.Status;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

import static org.exercice.utils.LocalDrivers.defaultProjectDriver;
import static org.exercice.utils.Reporter.testCase;

@UtilityClass
public class AutomTools {

    public static void makeDriverChrome() {
        defaultProjectDriver = new ChromeDriver();
    }

    public static void closeDriver() {
        defaultProjectDriver.quit();
    }

    public static void driverImplicitWaitConfig(Duration duration) {
        defaultProjectDriver.manage().timeouts().implicitlyWait(duration);
    }

    //this click overlay allows to target elements which are loaded on the page but not visible on the current
    //display of the webpage, there's also logging added for reporting purposes
    private void configuredClick(Map.Entry<String, WebElement> entry) {
        Actions actions = new Actions(defaultProjectDriver);
        actions.moveToElement(entry.getValue());
        try {
            actions.perform();
        } catch (StaleElementReferenceException e) {
            testCase.log(Status.FAIL, entry.getKey() + " was previously located, but can not be currently accessed");
        }
        entry.getValue().click();
        testCase.log(Status.PASS, "Successful click on : " + entry.getKey() + " element");
    }

    public static void capturePicture() throws InterruptedException {
        BufferedImage image = null;
        Thread.sleep(3000);
        // get a screenshot from the driver
        File screen = ((TakesScreenshot) defaultProjectDriver)
                .getScreenshotAs(OutputType.FILE);
        testCase.log(Status.PASS, "Success in taking a screenshot");

        // create an instance of buffered image from captured screenshot
        try {
            image = ImageIO.read(screen);
        } catch (IOException e) {
            testCase.log(Status.FAIL, "Could not get image from screenshot");
        }

        // save the image for reporting purpose
        try {
            ImageIO.write(image, "png", new File("src/test/resources/output/ResultImageToBeInterpreted.png"));
        } catch (IOException e) {
            testCase.log(Status.FAIL, "Could not save image from screenshot in output folder");
        }
        testCase.log(Status.PASS, "Success in saving the screenshot");
    }

    //this double-click overlay adds logging to the actual action for reporting purposes
    public static void customDoubleClick(Map.Entry<String, WebElement> entry) {
        try {
            Actions actions = new Actions(defaultProjectDriver);
            actions.doubleClick(entry.getValue()).perform();
            testCase.log(Status.PASS, "Success in double clicking on : " + entry.getKey() + " " + " element : ");
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Element : " + entry.getKey() + " is not present");
        } catch (ElementNotInteractableException e) {
            testCase.log(Status.FAIL, "Element : " + entry.getKey() + " is present but not usable to double click");
        }

    }

    //this sendKeys overlay adds logging to the actual action for reporting purposes
    public static void customSendKeys(Map.Entry<String, WebElement> entry, String content) {
        try {
            entry.getValue().sendKeys(content);
            testCase.log(Status.PASS, "Success in sending keys : " + content + " " + "to web element : " + entry.getKey());
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Element : " + entry.getKey() + " is not present");
        } catch (ElementNotInteractableException e) {
            testCase.log(Status.FAIL, "Element : " + entry.getKey() + " is present but not usable to send keys");
        }
    }
    public static void switchTabFocus(Integer tab) {
        ArrayList<String> tabs = new ArrayList<>(defaultProjectDriver.getWindowHandles());
        defaultProjectDriver.switchTo().window(tabs.get(tab));
        testCase.log(Status.PASS, "Success in switching tab focus");
    }

    //this function is a second overlay to the click method, it triggers a javascript instruction to manually scroll
    //to the element if it's still not into view after the first "configuredClick" attempt
    public static void customClick(Map.Entry<String, WebElement> entry) {
        try {
            configuredClick(entry);
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) defaultProjectDriver).executeScript("arguments[0].scrollIntoView(true);", entry.getValue());
            configuredClick(entry);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Element :" + entry.getKey() + " is not present");
        } catch (ElementNotInteractableException e) {
            testCase.log(Status.FAIL, "Element :" + entry.getKey() + " is present but not clickable");
        }
    }
}
