package org.exercice.actions.hightest;

import org.exercice.object_repository.hightest.HightestContactPageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.ProjectRepository;

import java.util.Objects;

public class HightestContactPageActions {

    public void clickPolicyCheckBox() {
        HightestContactPageRepository contactRepo = new HightestContactPageRepository();
        contactRepo.loadContactPageNominalContextObjects();
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getConfidencialityPolicyCheckBox()));
    }

    public void clickSubmitButton() {
        HightestContactPageRepository contactRepo = new HightestContactPageRepository();
        contactRepo.loadContactPageNominalContextObjects();
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getSubmitButton()));
    }

    public void fillEmailInputFieldWithIncorrectFormat() {
        HightestContactPageRepository contactRepo = new HightestContactPageRepository();
        contactRepo.loadContactPageNominalContextObjects();
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getSurname()));
        AutomTools.customSendKeys(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getSurname()), "testSurname");
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getName()));
        AutomTools.customSendKeys(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getName()), "testName");
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getEmail()));
        AutomTools.customSendKeys(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getEmail()), "IncorrectFormat");
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getPhoneNumber()));
        AutomTools.customSendKeys(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getPhoneNumber()), "0000000000");
    }

    public Boolean assertErrorMessagesAreDisplayedForMandatoryFields(String libelle) {
        HightestContactPageRepository contactRepo = new HightestContactPageRepository();
        contactRepo.loadContactPageErrorMessageMandatoryFieldContextObjects();
        return (contactRepo.getErrorMessageMandatorySurnameField().isDisplayed()
                && contactRepo.getErrorMessageMandatoryNameField().isDisplayed()
                && contactRepo.getErrorMessageMandatoryEmailField().isDisplayed()
                && contactRepo.getErrorMessageMandatoryPhoneNumberField().isDisplayed())
                &&
                ((Objects.equals(contactRepo.getErrorMessageMandatorySurnameField().getText(), libelle))
                        &&
                        (Objects.equals(contactRepo.getErrorMessageMandatoryNameField().getText(), libelle))
                        &&
                        (Objects.equals(contactRepo.getErrorMessageMandatoryEmailField().getText(), libelle))
                        &&
                        Objects.equals(contactRepo.getErrorMessageMandatoryPhoneNumberField().getText(), libelle));
    }

    public Boolean assertErrorMessagesIsDisplayedWhenIncorrectFormatIsWrittenForEmail(String libelle) {
        HightestContactPageRepository contactRepo = new HightestContactPageRepository();
        contactRepo.loadContactPageInvalidEmailFormatContextObjects();
        return contactRepo.getErrorMessageNotValidEmail().isDisplayed()
                &&
                Objects.equals(contactRepo.getErrorMessageNotValidEmail().getText(), libelle)
                ;
    }

    public void fillInputFieldsWithCorrectFormatData() {
        HightestContactPageRepository contactRepo = new HightestContactPageRepository();
        contactRepo.loadContactPageNominalContextObjects();
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getSurname()));
        AutomTools.customSendKeys(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getSurname()), "testSurname");
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getName()));
        AutomTools.customSendKeys(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getName()), "testName");
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getEmail()));
        AutomTools.customSendKeys(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getEmail()), "test@scenario.nc");
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getPhoneNumber()));
        AutomTools.customSendKeys(ProjectRepository.getWebElementFromProjectRepo(contactRepo.getPhoneNumber()), "0000000000");


    }

    public Boolean assertSubmitButtonEnabled() {
        HightestContactPageRepository contactRepo = new HightestContactPageRepository();
        contactRepo.loadContactPageNominalContextObjects();
        return contactRepo.getSubmitButton().isEnabled();
    }
}
