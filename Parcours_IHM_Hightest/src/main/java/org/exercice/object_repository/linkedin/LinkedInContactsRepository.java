package org.exercice.object_repository.linkedin;

import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LinkedInContactsRepository {

    public final WebElement zoomedImageElement = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//img[@alt='Aperçu de la photo jointe']\n"));
}