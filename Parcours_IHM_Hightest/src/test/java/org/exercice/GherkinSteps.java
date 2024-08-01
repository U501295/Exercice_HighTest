package org.exercice;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;
import org.assertj.core.api.Assertions;
import org.exercice.actions.hightest.HightestContactPageActions;
import org.exercice.actions.hightest.HightestHomePageActions;
import org.exercice.actions.hightest.HightestResultPageActions;
import org.exercice.actions.hightest.ISTQBQuestionPageActions;
import org.exercice.actions.hightest.ToolBoxPageActions;
import org.exercice.utils.AutomTools;
import org.openqa.selenium.NoSuchWindowException;

import static org.exercice.utils.Reporter.testCase;

public class GherkinSteps {

    @Given("^I connect to Hightest$")
    public void i_connect_to_Hightest() {
        HightestHomePageActions onHomePage = new HightestHomePageActions();
        onHomePage.getToHomePage("https://hightest.nc/");
    }

    @And("^I go to the ToolBox section$")
    public void i_go_to_the_ToolBox_section() {
        HightestHomePageActions onHomePage = new HightestHomePageActions();
        onHomePage.clickToolBoxButton();
    }


    @And("^I select the ISQTB french quizz$")
    public void i_go_to_the_ISTQB_french_quizz() {
        ToolBoxPageActions onToolBoxPage = new ToolBoxPageActions();
        onToolBoxPage.clickISTQBFoundationFrenchButton();
        AutomTools.switchTabFocus(1);
    }

    @When("^I take the French ISTQB Quizz and all my answers are good$")
    public void i_take_the_French_ISTQB_Quizz() throws NoSuchWindowException {
        ISTQBQuestionPageActions onISTQBQuestionPage = new ISTQBQuestionPageActions();
        onISTQBQuestionPage.goodAnswersToAllTestQuestionsAndSubmit();
    }

    @When("^I give Julien Baroni's email for him to receive the results$")
    public void i_give_Julien_Baroni_s_email_for_him_to_receive_the_results() {
        HightestResultPageActions onHightestResultPage = new HightestResultPageActions();
        onHightestResultPage.submitEmailAdressToReceiveResults("jul.baroni@orange.fr");
    }

    @Then("^content of the header shows message : \"([^\"]*)\"$")
    public void then_content_of_the_results_indicates(String arg) throws TesseractException, InterruptedException {
        HightestResultPageActions onEmailSubmittedPage = new HightestResultPageActions();
        if (onEmailSubmittedPage.getResultsFromImage().contains(arg)) {
            testCase.log(Status.PASS, "Email submitted successfully");
            testCase.addScreenCaptureFromPath("classpath:ResultImageToBeInterpreted.png");
        } else {
            testCase.log(Status.FAIL, "Problem after email submitted");

        }
    }

    @And("I go to the contact section")
    public void iGoToTheContactSection() {
        HightestHomePageActions onHightestHomePage = new HightestHomePageActions();
        onHightestHomePage.clickContactButton();
    }

    @When("I try to submit a message without filling the mandatory fields")
    public void iTryToSubmitAMessageWithoutFillingTheMandatoryFields() {
        HightestContactPageActions onHightestContactPage = new HightestContactPageActions();
        onHightestContactPage.clickPolicyCheckBox();
        onHightestContactPage.clickSubmitButton();
    }

    @Then("error messages are displayed below the mandatory input fields stating : {string}")
    public void errorMessagesAreDisplayedBelowTheMandatoryInputFieldsStating(String libelle) {
        HightestContactPageActions onHightestContactPage = new HightestContactPageActions();
        Assertions.assertThat(onHightestContactPage.assertErrorMessagesAreDisplayedForMandatoryFields(libelle)).isTrue();
    }

    @When("I try to submit a message without filling the email field with a well formated email")
    public void iTryToSubmitAMessageWithoutFillingTheEmailFieldWithAWellFormatedEmail() {
        HightestContactPageActions onHightestContactPage = new HightestContactPageActions();
        onHightestContactPage.fillEmailInputFieldWithIncorrectFormat();
        onHightestContactPage.clickPolicyCheckBox();
        onHightestContactPage.clickSubmitButton();
    }

    @Then("an error message is displayed below the email input field stating : {string}")
    public void anErrorMessageIsDisplayedBelowTheEmailInputFieldStating(String libelle) {
        HightestContactPageActions onHightestContactPage = new HightestContactPageActions();
        Assertions.assertThat(onHightestContactPage.assertErrorMessagesIsDisplayedWhenIncorrectFormatIsWrittenForEmail(libelle)).isTrue();
    }

    @When("I try to submit a message without accepting the confidentiality policy")
    public void iTryToSubmitAMessageWithoutAcceptingTheConfidentialityPolicy() {
        HightestContactPageActions onHightestContactPage = new HightestContactPageActions();
        onHightestContactPage.fillInputFieldsWithCorrectFormatData();
    }

    @Then("the submit button is disabled and sending a message is not possible")
    public void theSubmitButtonIsDisabledAndSendingAMessageIsNotPossible() {
        HightestContactPageActions onHightestContactPage = new HightestContactPageActions();
        Assertions.assertThat(onHightestContactPage.assertSubmitButtonEnabled()).isFalse();
    }
}
