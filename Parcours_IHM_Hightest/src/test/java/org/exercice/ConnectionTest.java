package org.exercice;

import net.sourceforge.tess4j.TesseractException;
import org.assertj.core.api.Assertions;
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


class ConnectionTest {

    @BeforeAll
    public static void configAndInit() {
        AutomTools.makeDriverChrome();
        AutomTools.driverImplicitWaitConfig(Duration.ofSeconds(15));
    }

    @AfterAll
    public static void finish() {
        AutomTools.closeDriver();
    }

    @Test
    void shouldGetToEndOfScenarioWithTotalSuccess() throws TesseractException, IOException, InterruptedException {
        HightestHomePageActions onHomePage = new HightestHomePageActions();
        onHomePage.getToHomePage("https://hightest.nc/");
        onHomePage.clickToolBoxButton();
        ToolBoxPageActions onToolBoxPage = new ToolBoxPageActions();
        onToolBoxPage.clickISTQBFoundationFrenchButton();
        AutomTools.switchTabFocus(1);
        ISTQBQuestionPageActions onISTQBQuestionPage = new ISTQBQuestionPageActions();
        onISTQBQuestionPage.explicitlyWaitForRadioButtonsToBeLoaded();
        onISTQBQuestionPage.answerAllTestQuestionWithCompleteSuccess();
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
        Assertions.assertThat(onLinkedInMainPage.checkTotalSuccess().contains("20 question(s) sur 20, soit 100 % de réussite"));
    }

}
