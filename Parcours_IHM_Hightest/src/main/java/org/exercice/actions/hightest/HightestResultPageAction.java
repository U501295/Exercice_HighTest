package org.exercice.actions.hightest;

import org.exercice.object_repository.hightest.HighTestResultPageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.ProjectRepository;

import static org.exercice.object_repository.hightest.HighTestResultPageRepository.loadResultPageContextObjects;

public class HightestResultPageAction {

    public void submitEmailAdressToReceiveResults(String adress) {
        HighTestResultPageRepository localContext = loadResultPageContextObjects();
        AutomTools.customSendKeys(ProjectRepository.getWebElementFromProjectRepo(localContext.getEmailBox()), adress);
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(localContext.getSubmitButton()));
    }

}
