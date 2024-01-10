package org.exercice.hightest;

import org.exercice.utils.AutomTools;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ToolBoxPage {

    public void clickISTQBFoundationFrenchButton() {
        final WebElement iSTQBFoundationFrenchButton = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/section/article/div[2]/div/div[1]/div/div[2]/div/a[1]"));
        AutomTools.customClick(iSTQBFoundationFrenchButton);
    }
}
