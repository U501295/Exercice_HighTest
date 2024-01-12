package org.exercice.actions.linkedin;

import org.exercice.object_repository.linkedin.LinkedInHomePageRepository;

import static org.exercice.object_repository.linkedin.LinkedInHomePageRepository.loadLinkedInHomePageContextObjects;
import static org.exercice.utils.AutomTools.customClick;
import static org.exercice.utils.AutomTools.customSendKeys;
import static org.exercice.utils.LocalDrivers.defaultProjectDriver;
import static org.exercice.utils.ProjectRepository.getWebElementFromProjectRepo;

public class LinkedInHomePageActions {

    public void getToHomePage(String url) {
        defaultProjectDriver.get(url);
        defaultProjectDriver.manage().window().maximize();
    }
    public void submitLinkedInConnectionInformations(String email, String password) {
        LinkedInHomePageRepository localContext = loadLinkedInHomePageContextObjects();
        customSendKeys(getWebElementFromProjectRepo(localContext.getEmailBox()), email);
        customSendKeys(getWebElementFromProjectRepo(localContext.getPasswordBox()), password);
        customClick(getWebElementFromProjectRepo(localContext.getSubmitButton()));
    }
}
