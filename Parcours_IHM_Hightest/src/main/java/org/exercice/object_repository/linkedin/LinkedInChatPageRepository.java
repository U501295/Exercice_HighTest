package org.exercice.object_repository.linkedin;

import com.aventstack.extentreports.Status;
import lombok.Getter;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.exercice.utils.ProjectRepository.webElementsRepository;
import static org.exercice.utils.Reporter.testCase;

@Getter
public class LinkedInChatPageRepository {


    private final WebElement resultImageInChat = LocalDrivers.defaultProjectDriver.findElement(By.className("msg-s-event-listitem__image"));
    public static LinkedInChatPageRepository loadChatContextObjects() {
        LinkedInChatPageRepository linkedInChatPageRepository = null;
        try {
            linkedInChatPageRepository = new LinkedInChatPageRepository();
            webElementsRepository.put("image from the linkedIn chat", linkedInChatPageRepository.resultImageInChat);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "LinkedIn chat page objects loading failed : " + e.getCause());
        }
        return linkedInChatPageRepository;
    }
}