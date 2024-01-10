package org.exercice.actions.hightest;

import org.exercice.object_repository.hightest.HighTestResultPageRepository;
import org.exercice.utils.AutomTools;

public class HightestResultPageAction {

    HighTestResultPageRepository highTestResultPageRepository;

    public void submitEmailAdressToReceiveResults(String adress) {
        highTestResultPageRepository = new HighTestResultPageRepository();
        highTestResultPageRepository.emailBox.sendKeys(adress);
    }

    public void clickOkayButton() {
        highTestResultPageRepository = new HighTestResultPageRepository();
        AutomTools.customClick(highTestResultPageRepository.submitButton);
    }
}
