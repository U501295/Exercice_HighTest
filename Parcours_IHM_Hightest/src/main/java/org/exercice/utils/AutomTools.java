package org.exercice.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    public static void captureCroppedPicture(WebElement element) throws IOException, InterruptedException {

        //cast element to wrapsDriver
        //WrapsDriver wrapsDriver = (WrapsDriver) element;

        // get the entire screenshot from the driver of passed WebElement
        Thread.sleep(3000);
        File screen = ((TakesScreenshot) LocalDrivers.defaultProjectDriver)
                .getScreenshotAs(OutputType.FILE);

        // create an instance of buffered image from captured screenshot
        BufferedImage image = ImageIO.read(screen);

        // get the width and height of the WebElement using getSize()
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        // create a rectangle using width and height
        Rectangle rect = new Rectangle(width, height);

        // get the location of WebElement in a Point.
        // this will provide X & Y co-ordinates of the WebElement
        Point point = element.getLocation();

        // create image  for element using its location and size.
        // this will give image data specific to the WebElement
        BufferedImage dest = image.getSubimage(0, (int) image.getHeight() / 2, image.getWidth(), image.getHeight() / 2);
        //image.getSubimage(point.getX(), point.getY(), rect.width,
        //rect.height);
        // write back the image data for element in new File
        ImageIO.write(image, "png", new File("src/test/resources/Screen.png"));
        ImageIO.write(dest, "png", new File("src/test/resources/ResultImage.png"));
    }


    public static void switchTabFocus(Integer tab) {
        ArrayList<String> tabs = new ArrayList<>(LocalDrivers.defaultProjectDriver.getWindowHandles());
        LocalDrivers.defaultProjectDriver.switchTo().window(tabs.get(tab));
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
