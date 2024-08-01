package org.exercice.actions.hightest;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.exercice.object_repository.hightest.HighTestResultPageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.ProjectRepository;

import java.io.File;

import static org.exercice.object_repository.hightest.HighTestResultPageRepository.loadResultPageContextObjects;
import static org.exercice.utils.AutomTools.capturePicture;

public class HightestResultPageActions {

    public void submitEmailAdressToReceiveResults(String adress) {
        HighTestResultPageRepository localContext = loadResultPageContextObjects();
        AutomTools.customSendKeys(ProjectRepository.getWebElementFromProjectRepo(localContext.getEmailBox()), adress);
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(localContext.getSubmitButton()));
    }

    //This function will use text recognition technology from the Tesseract's framework to "read" the email
    //and return the quizz result
    public String getResultsFromImage() throws TesseractException, InterruptedException {
        //We croppe the result image to ensure the text recognition is optimized
        capturePicture();

        // Use Tesseract OCR to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng");
        tesseract.setDatapath("src/test/resources/tessdata");
        return tesseract.doOCR(new File("src/test/resources/output/ResultImageToBeInterpreted.png"));
    }

}
