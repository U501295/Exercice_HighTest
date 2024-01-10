package org.exercice;

import org.exercice.actions.hightest.HightestResultPageAction;
import org.exercice.actions.hightest.HomePageActions;
import org.exercice.actions.hightest.ISTQBQuestionPageActions;
import org.exercice.actions.hightest.ToolBoxPageActions;
import org.exercice.utils.AutomTools;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    void shouldGetToEndOfScenarioWithTotalSuccess() {
        HomePageActions onHomePage = new HomePageActions();
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
}
