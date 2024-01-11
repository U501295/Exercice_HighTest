package org.exercice.actions.linkedin;

import com.aventstack.extentreports.Status;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.exercice.object_repository.linkedin.LinkedInChatPageRepository;
import org.exercice.object_repository.linkedin.LinkedInContactsRepository;
import org.exercice.object_repository.linkedin.LinkedInMainPageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import static org.exercice.utils.Reporter.testCase;

public class LinkedInMainPageActions {

    private static LinkedInMainPageRepository linkedInMainPageRepository;
    private static LinkedInChatPageRepository linkedInChatPageRepository;
    private static LinkedInContactsRepository linkedInContactsRepository;

    private static void loadMainPageContextObjects() {
        try {
            linkedInMainPageRepository = new LinkedInMainPageRepository();
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "LinkedIn main page objects loading failed : " + e.getMessage());
        }
        testCase.log(Status.PASS, "LinkedIn main page objects loaded");
    }

    private static void loadChatContextObjects() {
        try {
            linkedInChatPageRepository = new LinkedInChatPageRepository();
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "LinkedIn chat page objects loading failed : " + e.getMessage());
        }
        testCase.log(Status.PASS, "LinkedIn chat page objects loaded");
    }

    private static void loadContactsContextObjects() {
        try {
            linkedInContactsRepository = new LinkedInContactsRepository();
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "LinkedIn contacts objects loading failed : " + e.getMessage());
        }
        testCase.log(Status.PASS, "LinkedIn contacts objects loaded");
    }

    public void openChatWindowWithJulienBaroni() {
        loadMainPageContextObjects();
        Actions actions = new Actions(LocalDrivers.defaultProjectDriver);
        actions.doubleClick(linkedInMainPageRepository.chatContact).perform();
    }

    public void openResults() {
        loadChatContextObjects();
        AutomTools.customClick(linkedInChatPageRepository.resultImageInChat);
    }

    public String checkTotalSuccess() throws TesseractException, InterruptedException {
        // Find the image element
        loadContactsContextObjects();
        AutomTools.customClick(linkedInContactsRepository.zoomedImageElement);
        AutomTools.captureCroppedPicture();

        // Use Tesseract OCR to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng");
        tesseract.setDatapath("src/test/resources/tessdata");
        return tesseract.doOCR(new File("src/test/resources/output/ResultImage.png"));
    }


}
