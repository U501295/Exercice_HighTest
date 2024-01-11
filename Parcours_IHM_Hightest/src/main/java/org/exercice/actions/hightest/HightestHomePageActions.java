package org.exercice.actions.hightest;

import org.exercice.object_repository.hightest.HightestHomePageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;

public class HightestHomePageActions {
    private HightestHomePageRepository homePageRepository;

    public void getToHomePage(String url) {
        LocalDrivers.defaultProjectDriver.get(url);
        LocalDrivers.defaultProjectDriver.manage().window().maximize();
    }

    public void clickToolBoxButton() {
        homePageRepository = new HightestHomePageRepository();
        AutomTools.customClick(homePageRepository.toolboxButton);
    }
}
