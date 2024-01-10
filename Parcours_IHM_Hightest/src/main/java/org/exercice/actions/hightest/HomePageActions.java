package org.exercice.actions.hightest;

import org.exercice.object_repository.hightest.HomePageRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;

public class HomePageActions {
    private HomePageRepository homePageRepository;

    public void getToHomePage(String url) {
        LocalDrivers.defaultProjectDriver.get(url);
        LocalDrivers.defaultProjectDriver.manage().window().maximize();
    }

    public void clickToolBoxButton() {
        homePageRepository = new HomePageRepository();
        AutomTools.customClick(homePageRepository.toolboxButton);
    }
}
