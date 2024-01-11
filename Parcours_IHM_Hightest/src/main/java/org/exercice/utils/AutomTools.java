package org.exercice.utils;

import com.aventstack.extentreports.Status;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
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

import static org.exercice.utils.Reporter.testCase;

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
        testCase.log(Status.PASS, "Successful click on : " + webElement + " element");
    }

    public static void captureCroppedPicture() throws InterruptedException {
        BufferedImage image = null;
        // get the entire screenshot from the driver of passed WebElement
        Thread.sleep(3000);
        File screen = ((TakesScreenshot) LocalDrivers.defaultProjectDriver)
                .getScreenshotAs(OutputType.FILE);
        testCase.log(Status.PASS, "Success in taking a screenshot");

        // create an instance of buffered image from captured screenshot
        try {
            image = ImageIO.read(screen);
        } catch (IOException e) {
            testCase.log(Status.FAIL, "Could not get image from screenshot");
        }


        // create image  for element using its location and size.
        // this will give image data specific to the WebElement
        BufferedImage dest = image.getSubimage(0, image.getHeight() / 2, image.getWidth(), image.getHeight() / 2);

        // write back the image data for element in new File
        try {
            ImageIO.write(image, "png", new File("src/test/resources/output/Screenshot.png"));
            ImageIO.write(dest, "png", new File("src/test/resources/output/ResultImage.png"));
        } catch (IOException e) {
            testCase.log(Status.FAIL, "Could not save image from screenshot in output folder");
        }
        testCase.log(Status.PASS, "Success in saving the screenshot");


    }


    public static void switchTabFocus(Integer tab) {
        ArrayList<String> tabs = new ArrayList<>(LocalDrivers.defaultProjectDriver.getWindowHandles());
        LocalDrivers.defaultProjectDriver.switchTo().window(tabs.get(tab));
        testCase.log(Status.PASS, "Success in switching tab focus");
    }

    public static void customClick(WebElement webElement) {
        try {
            configuredClick(webElement);
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) LocalDrivers.defaultProjectDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            configuredClick(webElement);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Element :" + webElement.getAccessibleName() + " is not present");
        } catch (ElementNotInteractableException e) {
            testCase.log(Status.FAIL, "Element :" + webElement.getAccessibleName() + " is present but not clickable");
        }
    }
}
