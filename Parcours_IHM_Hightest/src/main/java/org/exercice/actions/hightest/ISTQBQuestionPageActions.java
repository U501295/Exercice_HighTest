package org.exercice.actions.hightest;

import org.exercice.object_repository.hightest.ISTQBQuestionPageRepository;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.exercice.object_repository.hightest.ISTQBQuestionPageRepository.loadISTQBQuestionsContextObjects;
import static org.exercice.utils.AutomTools.customClick;
import static org.exercice.utils.ProjectRepository.getWebElementFromProjectRepo;

public class ISTQBQuestionPageActions {

    public void explicitlyWaitForRadioButtonsToBeLoaded() throws NoSuchWindowException {
        ISTQBQuestionPageRepository localContext = loadISTQBQuestionsContextObjects();
        WebDriverWait wait = new WebDriverWait(LocalDrivers.defaultProjectDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(localContext.getGoodAnswerQuestion1()));

    }

    public void clickTerminateButton() {
        ISTQBQuestionPageRepository localContext = loadISTQBQuestionsContextObjects();
        customClick(getWebElementFromProjectRepo(localContext.getTerminateButton()));
    }

    public void goodAnswersToAllTestQuestion() {
        ISTQBQuestionPageRepository localContext = loadISTQBQuestionsContextObjects();
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion1()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion2()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion3()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion4()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion5()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion6()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion7()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion8()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion9()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion10()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion11()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion12()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion13()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion14()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion15()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion16()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion17()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion18()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion19()));
        customClick(getWebElementFromProjectRepo(localContext.getGoodAnswerQuestion20()));
    }
}
