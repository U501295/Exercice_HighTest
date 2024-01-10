package org.exercice.hightest;

import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    protected String url;


    public HomePage(String url) {
        this.url = url;
    }

    public void getToHomePage() {
        LocalDrivers.defaultProjectDriver.get(url);
        LocalDrivers.defaultProjectDriver.manage().window().maximize();
    }

    public ToolBoxPage clickToolBoxButton() {
        final WebElement toolboxButton = LocalDrivers.defaultProjectDriver.findElement(By.id("menu-item-33"));
        AutomTools.customClick(toolboxButton);
        return new ToolBoxPage();
    }
}
