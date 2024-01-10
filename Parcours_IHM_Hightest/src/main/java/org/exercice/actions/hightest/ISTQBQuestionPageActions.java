package org.exercice.actions.hightest;

import org.exercice.object_repository.hightest.ISTQBQuestionPageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ISTQBQuestionPageActions {

    private ISTQBQuestionPageRepository istqbQuestionPageRepository;

    public void explicitlyWaitForRadioButtonsToBeLoaded() {
        istqbQuestionPageRepository = new ISTQBQuestionPageRepository();
        WebDriverWait wait = new WebDriverWait(LocalDrivers.defaultProjectDriver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(istqbQuestionPageRepository.goodAnswerQuestion1));
    }

    public void clickTerminateButton() {
        istqbQuestionPageRepository = new ISTQBQuestionPageRepository();
        AutomTools.customClick(istqbQuestionPageRepository.terminateButton);

    }

    public void answerAllTestQuestionWithCompleteSuccess() {
        istqbQuestionPageRepository = new ISTQBQuestionPageRepository();
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion1);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion2);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion3);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion4);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion5);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion6);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion7);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion8);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion9);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion10);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion11);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion12);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion13);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion14);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion15);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion16);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion17);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion18);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion19);
        AutomTools.customClick(istqbQuestionPageRepository.goodAnswerQuestion20);
    }
}
