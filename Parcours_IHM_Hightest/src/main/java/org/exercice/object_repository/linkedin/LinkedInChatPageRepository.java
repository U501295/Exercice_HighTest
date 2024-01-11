package org.exercice.object_repository.linkedin;

import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LinkedInChatPageRepository {

    final public WebElement resultImageInChat = LocalDrivers.defaultProjectDriver.findElement(By.className("msg-s-event-listitem__image-container"));
}