package org.exercice.object_repository.linkedin;

import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LinkedInHomePageRepository {
    public final WebElement emailBox = LocalDrivers.defaultProjectDriver.findElement(By.id("session_key"));
    public final WebElement passwordBox = LocalDrivers.defaultProjectDriver.findElement(By.id("session_password"));
    public final WebElement submitButton = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button"));
}