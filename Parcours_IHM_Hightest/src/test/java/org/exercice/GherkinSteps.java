package org.exercice;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;
import org.exercice.actions.hightest.HightestHomePageActions;
import org.exercice.actions.hightest.HightestResultPageAction;
import org.exercice.actions.hightest.ISTQBQuestionPageActions;
import org.exercice.actions.hightest.ToolBoxPageActions;
import org.exercice.actions.linkedin.LinkedInHomePageActions;
import org.exercice.actions.linkedin.LinkedInMainPageActions;
import org.exercice.utils.AutomTools;
import org.openqa.selenium.NoSuchWindowException;

import static org.exercice.utils.Reporter.testCase;

public class GherkinSteps {

    @Given("^I connect to Hightest$")
    public void i_connect_to_Hightest() {
        HightestHomePageActions onHomePage = new HightestHomePageActions();
        onHomePage.getToHomePage("https://hightest.nc/");
        onHomePage.clickToolBoxButton();
    }

    @When("^I go to the ToolBox section$")
    public void i_go_to_the_ToolBox_section() {
        ToolBoxPageActions onToolBoxPage = new ToolBoxPageActions();
        onToolBoxPage.clickISTQBFoundationFrenchButton();
        AutomTools.switchTabFocus(1);
    }

    @When("^I take the French ISTQB Quizz and all my answers are good$")
    public void i_take_the_French_ISTQB_Quizz() throws NoSuchWindowException {
        ISTQBQuestionPageActions onISTQBQuestionPage = new ISTQBQuestionPageActions();
        onISTQBQuestionPage.explicitlyWaitForRadioButtonsToBeLoaded();
        onISTQBQuestionPage.goodAnswersToAllTestQuestion();
        onISTQBQuestionPage.clickTerminateButton();
    }

    @When("^I give Julien Baroni's email for him to receive the results$")
    public void i_give_Julien_Baroni_s_email_for_him_to_receive_the_results() {
        HightestResultPageAction onHightestResultPage = new HightestResultPageAction();
        onHightestResultPage.submitEmailAdressToReceiveResults("jul.baroni@orange.fr");
        onHightestResultPage.clickOkayButton();
    }

    @When("^I connect to LinkedIn$")
    public void i_connect_to_LinkedIn() {
        LinkedInHomePageActions onLinkedInHomePage = new LinkedInHomePageActions();
        onLinkedInHomePage.getToHomePage("https://www.linkedin.com/home");
        onLinkedInHomePage.submitLinkedInConnectionInformations("TestIhmLinkedIn@gmail.com", "Parcours123!");
    }

    @When("^I open the results Julien Baroni sent me$")
    public void i_open_the_results_Julien_Baroni_sent_me() {
        LinkedInMainPageActions onLinkedInMainPage = new LinkedInMainPageActions();
        onLinkedInMainPage.openChatWindowWithJulienBaroni();
        onLinkedInMainPage.openResults();
    }

    @Then("^then content of the results indicates \"([^\"]*)\"$")
    public void then_content_of_the_results_indicates(String arg) throws TesseractException, InterruptedException {
        LinkedInMainPageActions onLinkedInMainPage = new LinkedInMainPageActions();
        if (onLinkedInMainPage.checkTotalSuccess().contains(arg)) {
            testCase.log(Status.PASS, "The total score is 100%");
            testCase.addScreenCaptureFromPath("classpath:ResultImage.png");
        } else {
            testCase.log(Status.FAIL, "The total score is not 100%");

        }
    }

}
