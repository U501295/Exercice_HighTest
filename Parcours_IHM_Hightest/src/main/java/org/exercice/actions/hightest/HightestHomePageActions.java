package org.exercice.actions.hightest;

import org.exercice.object_repository.hightest.HightestHomePageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;
import org.exercice.utils.ProjectRepository;

import static org.exercice.object_repository.hightest.HightestHomePageRepository.loadHomePageContextObjects;

public class HightestHomePageActions {


    public void getToHomePage(String url) {
        LocalDrivers.defaultProjectDriver.get(url);
        LocalDrivers.defaultProjectDriver.manage().window().maximize();
    }

    public void clickToolBoxButton() {
        HightestHomePageRepository localContext = loadHomePageContextObjects();
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(localContext.getToolboxButton()));
    }

    public void clickContactButton() {
        HightestHomePageRepository localContext = loadHomePageContextObjects();
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(localContext.getContactButton()));
    }
}
