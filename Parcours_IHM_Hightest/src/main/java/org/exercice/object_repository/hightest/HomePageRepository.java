package org.exercice.object_repository.hightest;

import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageRepository {
    public final WebElement toolboxButton = LocalDrivers.defaultProjectDriver.findElement(By.id("menu-item-33"));
}
