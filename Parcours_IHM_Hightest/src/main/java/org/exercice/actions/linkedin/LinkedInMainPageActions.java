package org.exercice.actions.linkedin;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.exercice.object_repository.linkedin.LinkedInChatPageRepository;
import org.exercice.object_repository.linkedin.LinkedInContactsRepository;
import org.exercice.object_repository.linkedin.LinkedInMainPageRepository;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.exercice.object_repository.linkedin.LinkedInChatPageRepository.loadChatContextObjects;
import static org.exercice.object_repository.linkedin.LinkedInContactsRepository.loadContactsContextObjects;
import static org.exercice.object_repository.linkedin.LinkedInMainPageRepository.loadMainPageContextObjects;
import static org.exercice.utils.AutomTools.captureCroppedPicture;
import static org.exercice.utils.AutomTools.customClick;
import static org.exercice.utils.AutomTools.customDoubleClick;
import static org.exercice.utils.ProjectRepository.getWebElementFromProjectRepo;

public class LinkedInMainPageActions {

    public void openChatWindowWithJulienBaroni() {
        LinkedInMainPageRepository localContext = loadMainPageContextObjects();
        customDoubleClick(getWebElementFromProjectRepo(localContext.getChatContactJulienBaroni()));
    }

    public void openResults() {
        LinkedInChatPageRepository localContext = loadChatContextObjects();
        WebDriverWait wait = new WebDriverWait(LocalDrivers.defaultProjectDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(localContext.getResultImageInChat()));
        customClick(getWebElementFromProjectRepo(localContext.getResultImageInChat()));
    }

    //This function will use text recognition technology from the Tesseract's framework to "read" the email
    //and return the quizz result
    public String getResultsFromImage() throws TesseractException, InterruptedException {
        LinkedInContactsRepository localContext = loadContactsContextObjects();
        customClick(getWebElementFromProjectRepo(localContext.getZoomedImageElement()));

        //We croppe the result image to ensure the text recognition is optimized
        captureCroppedPicture();

        // Use Tesseract OCR to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng");
        tesseract.setDatapath("src/test/resources/tessdata");
        return tesseract.doOCR(new File("src/test/resources/output/ResultImageToBeInterpreted.png"));
    }


}
