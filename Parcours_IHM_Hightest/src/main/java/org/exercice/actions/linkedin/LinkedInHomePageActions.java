package org.exercice.actions.linkedin;

import org.exercice.object_repository.linkedin.LinkedInHomePageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;

public class LinkedInHomePageActions {

    LinkedInHomePageRepository homePageRepository;

    public void getToHomePage(String url) {
        LocalDrivers.defaultProjectDriver.get(url);
        LocalDrivers.defaultProjectDriver.manage().window().maximize();
    }

    public void submitLinkedInConnectionInformations(String email, String password) {
        homePageRepository = new LinkedInHomePageRepository();
        homePageRepository.emailBox.sendKeys(email);
        homePageRepository.passwordBox.sendKeys(password);
        AutomTools.customClick(homePageRepository.submitButton);
    }
}
