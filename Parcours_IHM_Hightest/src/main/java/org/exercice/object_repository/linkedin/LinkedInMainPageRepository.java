package org.exercice.object_repository.linkedin;

import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LinkedInMainPageRepository {

    final public WebElement chatContact = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//h3[contains(.,'Julien Baroni')]"));
}