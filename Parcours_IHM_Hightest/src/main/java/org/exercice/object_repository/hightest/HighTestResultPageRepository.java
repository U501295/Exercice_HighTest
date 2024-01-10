package org.exercice.object_repository.hightest;

import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HighTestResultPageRepository {

    public final WebElement emailBox = LocalDrivers.defaultProjectDriver.findElement(By.id("email"));
    public final WebElement submitButton = LocalDrivers.defaultProjectDriver.findElement(By.id("submitMail"));
}
