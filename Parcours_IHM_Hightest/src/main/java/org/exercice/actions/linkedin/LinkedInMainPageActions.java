package org.exercice.actions.linkedin;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.exercice.object_repository.linkedin.ContactChatRepository;
import org.exercice.object_repository.linkedin.LinkedInChatPageRepository;
import org.exercice.object_repository.linkedin.LinkedInMainPageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class LinkedInMainPageActions {

    LinkedInMainPageRepository linkedInMainPageRepository;
    LinkedInChatPageRepository linkedInChatPageRepository;
    ContactChatRepository contactChatRepository;

    public void openChatWindowWithJulienBaroni() {
        linkedInMainPageRepository = new LinkedInMainPageRepository();
        Actions actions = new Actions(LocalDrivers.defaultProjectDriver);
        actions.doubleClick(linkedInMainPageRepository.chatContact).perform();
    }

    public void openResults() {
        linkedInChatPageRepository = new LinkedInChatPageRepository();
        AutomTools.customClick(linkedInChatPageRepository.resultImageInChat);
    }

    public String checkTotalSuccess() throws TesseractException, IOException, InterruptedException {
        // Find the image element
        contactChatRepository = new ContactChatRepository();
        AutomTools.customClick(contactChatRepository.zoomedImageElement);
        AutomTools.captureCroppedPicture(contactChatRepository.zoomedImageElement);

        // Use Tesseract OCR to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng");
        tesseract.setDatapath("src/test/resources/tessdata");
        String result = tesseract.doOCR(new File("src/test/resources/ResultImage.png"));
        return result;
    }


}
