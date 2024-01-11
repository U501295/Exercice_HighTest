package org.exercice;

import net.sourceforge.tess4j.TesseractException;
import org.exercice.actions.hightest.HightestHomePageActions;
import org.exercice.actions.hightest.HightestResultPageAction;
import org.exercice.actions.hightest.ISTQBQuestionPageActions;
import org.exercice.actions.hightest.ToolBoxPageActions;
import org.exercice.actions.linkedin.LinkedInHomePageActions;
import org.exercice.actions.linkedin.LinkedInMainPageActions;
import org.exercice.utils.AutomTools;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;


class ConnectionTest {

    @BeforeAll
    public static void configAndInit() {
        AutomTools.makeDriverChrome();
        AutomTools.driverImplicitWaitConfig(Duration.ofSeconds(15));
    }

//    @AfterAll
//    public static void finish() {
//        AutomTools.closeDriver();
//    }

    @Test
    void shouldGetToEndOfScenarioWithTotalSuccess() {
        HightestHomePageActions onHomePage = new HightestHomePageActions();
        onHomePage.getToHomePage("https://hightest.nc/");
        onHomePage.clickToolBoxButton();
        ToolBoxPageActions onToolBoxPage = new ToolBoxPageActions();
        onToolBoxPage.clickISTQBFoundationFrenchButton();
        AutomTools.switchToggleFocus(1);
        ISTQBQuestionPageActions onISTQBQuestionPage = new ISTQBQuestionPageActions();
        onISTQBQuestionPage.explicitlyWaitForRadioButtonsToBeLoaded();
        onISTQBQuestionPage.answerAllTestQuestionWithCompleteSuccess();
        onISTQBQuestionPage.clickTerminateButton();
        HightestResultPageAction onHightestResultPage = new HightestResultPageAction();
        onHightestResultPage.submitEmailAdressToReceiveResults("jul.baroni@orange.fr");
        onHightestResultPage.clickOkayButton();

    }

    @Test
    void shouldGetThroughLinkedInSteps() throws TesseractException, IOException {
        LinkedInHomePageActions onLinkedInHomePage = new LinkedInHomePageActions();
        onLinkedInHomePage.getToHomePage("https://www.linkedin.com/home");
        onLinkedInHomePage.submitLinkedInConnectionInformations("TestIhmLinkedIn@gmail.com", "Parcours123!");
        LinkedInMainPageActions onLinkedInMainPage = new LinkedInMainPageActions();
        onLinkedInMainPage.openChatWindowWithJulienBaroni();
        onLinkedInMainPage.openResults();
        onLinkedInMainPage.checkTotalSuccess();
    }
}
