package org.exercice.object_repository.hightest;

import com.aventstack.extentreports.Status;
import lombok.Getter;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.exercice.utils.ProjectRepository.webElementsRepository;
import static org.exercice.utils.Reporter.testCase;

@Getter
public class ISTQBQuestionPageRepository {

    private final WebElement goodAnswerQuestion1 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='0'][value='1']"));
    private final WebElement goodAnswerQuestion2 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='1'][value='2']"));
    private final WebElement goodAnswerQuestion3 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='2'][value='1']"));
    private final WebElement goodAnswerQuestion4 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='3'][value='2']"));
    private final WebElement goodAnswerQuestion5 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='4'][value='2']"));
    private final WebElement goodAnswerQuestion6 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='5'][value='3']"));
    private final WebElement goodAnswerQuestion7 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='6'][value='2']"));
    private final WebElement goodAnswerQuestion8 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='7'][value='4']"));
    private final WebElement goodAnswerQuestion9 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='8'][value='1']"));
    private final WebElement goodAnswerQuestion10 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='9'][value='3']"));
    private final WebElement goodAnswerQuestion11 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='10'][value='4']"));
    private final WebElement goodAnswerQuestion12 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='11'][value='2']"));
    private final WebElement goodAnswerQuestion13 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='12'][value='3']"));
    private final WebElement goodAnswerQuestion14 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='13'][value='2']"));
    private final WebElement goodAnswerQuestion15 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='14'][value='4']"));
    private final WebElement goodAnswerQuestion16 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='15'][value='3']"));
    private final WebElement goodAnswerQuestion17 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='16'][value='3']"));
    private final WebElement goodAnswerQuestion18 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='17'][value='1']"));
    private final WebElement goodAnswerQuestion19 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='18'][value='2']"));
    private final WebElement goodAnswerQuestion20 = LocalDrivers.defaultProjectDriver.findElement(By.cssSelector("input[type='radio'][name='19'][value='2']"));
    private final WebElement terminateButton = LocalDrivers.defaultProjectDriver.findElement(By.id("submit"));

    public static ISTQBQuestionPageRepository loadISTQBQuestionsContextObjects() {
        ISTQBQuestionPageRepository istqbQuestionPageRepository = null;
        try {
            istqbQuestionPageRepository = new ISTQBQuestionPageRepository();
            webElementsRepository.put("Radio button for answering correctly to question 1", istqbQuestionPageRepository.goodAnswerQuestion1);
            webElementsRepository.put("Radio button for answering correctly to question 2", istqbQuestionPageRepository.goodAnswerQuestion2);
            webElementsRepository.put("Radio button for answering correctly to question 3", istqbQuestionPageRepository.goodAnswerQuestion3);
            webElementsRepository.put("Radio button for answering correctly to question 4", istqbQuestionPageRepository.goodAnswerQuestion4);
            webElementsRepository.put("Radio button for answering correctly to question 5", istqbQuestionPageRepository.goodAnswerQuestion5);
            webElementsRepository.put("Radio button for answering correctly to question 6", istqbQuestionPageRepository.goodAnswerQuestion6);
            webElementsRepository.put("Radio button for answering correctly to question 7", istqbQuestionPageRepository.goodAnswerQuestion7);
            webElementsRepository.put("Radio button for answering correctly to question 8", istqbQuestionPageRepository.goodAnswerQuestion8);
            webElementsRepository.put("Radio button for answering correctly to question 9", istqbQuestionPageRepository.goodAnswerQuestion9);
            webElementsRepository.put("Radio button for answering correctly to question 10", istqbQuestionPageRepository.goodAnswerQuestion10);
            webElementsRepository.put("Radio button for answering correctly to question 11", istqbQuestionPageRepository.goodAnswerQuestion11);
            webElementsRepository.put("Radio button for answering correctly to question 12", istqbQuestionPageRepository.goodAnswerQuestion12);
            webElementsRepository.put("Radio button for answering correctly to question 13", istqbQuestionPageRepository.goodAnswerQuestion13);
            webElementsRepository.put("Radio button for answering correctly to question 14", istqbQuestionPageRepository.goodAnswerQuestion14);
            webElementsRepository.put("Radio button for answering correctly to question 15", istqbQuestionPageRepository.goodAnswerQuestion15);
            webElementsRepository.put("Radio button for answering correctly to question 16", istqbQuestionPageRepository.goodAnswerQuestion16);
            webElementsRepository.put("Radio button for answering correctly to question 17", istqbQuestionPageRepository.goodAnswerQuestion17);
            webElementsRepository.put("Radio button for answering correctly to question 18", istqbQuestionPageRepository.goodAnswerQuestion18);
            webElementsRepository.put("Radio button for answering correctly to question 19", istqbQuestionPageRepository.goodAnswerQuestion19);
            webElementsRepository.put("Radio button for answering correctly to question 20", istqbQuestionPageRepository.goodAnswerQuestion20);
            webElementsRepository.put("Terminé button", istqbQuestionPageRepository.terminateButton);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "ISTQB questions page objects loading failed : " + e.getMessage());
        }
        return istqbQuestionPageRepository;
    }

}