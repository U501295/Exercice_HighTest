package org.exercice;

import com.aventstack.extentreports.Status;
import net.sourceforge.tess4j.TesseractException;
import org.exercice.actions.hightest.HightestHomePageActions;
import org.exercice.actions.hightest.HightestResultPageAction;
import org.exercice.actions.hightest.ISTQBQuestionPageActions;
import org.exercice.actions.hightest.ToolBoxPageActions;
import org.exercice.actions.linkedin.LinkedInHomePageActions;
import org.exercice.actions.linkedin.LinkedInMainPageActions;
import org.exercice.utils.AutomTools;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;

import static org.exercice.utils.Reporter.extent;
import static org.exercice.utils.Reporter.extentSparkReporter;
import static org.exercice.utils.Reporter.testCase;


class EndtoEndIntegTest {


    @BeforeAll
    public static void configAndInit() {
        AutomTools.makeDriverChrome();
        AutomTools.driverImplicitWaitConfig(Duration.ofSeconds(15));
        extent.attachReporter(extentSparkReporter);


    }

    @AfterAll
    public static void finish() {
        AutomTools.closeDriver();
        extent.flush();

    }

    @Test
    void shouldGetToEndOfScenarioWithTotalSuccess() throws TesseractException, IOException, InterruptedException {
        testCase = extent.createTest("Parcours bout en bout");
        HightestHomePageActions onHomePage = new HightestHomePageActions();
        onHomePage.getToHomePage("https://hightest.nc/");
        onHomePage.clickToolBoxButton();
        ToolBoxPageActions onToolBoxPage = new ToolBoxPageActions();
        onToolBoxPage.clickISTQBFoundationFrenchButton();
        AutomTools.switchTabFocus(1);
        ISTQBQuestionPageActions onISTQBQuestionPage = new ISTQBQuestionPageActions();
        onISTQBQuestionPage.explicitlyWaitForRadioButtonsToBeLoaded();
        onISTQBQuestionPage.goodAnswersToAllTestQuestion();
        onISTQBQuestionPage.clickTerminateButton();
        HightestResultPageAction onHightestResultPage = new HightestResultPageAction();
        onHightestResultPage.submitEmailAdressToReceiveResults("jul.baroni@orange.fr");
        onHightestResultPage.clickOkayButton();
        LinkedInHomePageActions onLinkedInHomePage = new LinkedInHomePageActions();
        onLinkedInHomePage.getToHomePage("https://www.linkedin.com/home");
        onLinkedInHomePage.submitLinkedInConnectionInformations("TestIhmLinkedIn@gmail.com", "Parcours123!");
        LinkedInMainPageActions onLinkedInMainPage = new LinkedInMainPageActions();
        onLinkedInMainPage.openChatWindowWithJulienBaroni();
        onLinkedInMainPage.openResults();
        if (onLinkedInMainPage.checkTotalSuccess().contains("20 question(s) sur 20, soit 100 % de réussite")) {
            testCase.log(Status.PASS, "The total score is 100%");
            testCase.addScreenCaptureFromPath("classpath:ResultImage.png");
        } else {
            testCase.log(Status.FAIL, "The total score is not 100%");

        }
    }

}
