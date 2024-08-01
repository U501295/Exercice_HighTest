package org.exercice.object_repository.hightest;

import com.aventstack.extentreports.Status;
import lombok.Getter;
import org.exercice.utils.LocalDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.exercice.utils.ProjectRepository.webElementsRepository;
import static org.exercice.utils.Reporter.testCase;

@Getter
public class HightestContactPageRepository {

    private WebElement surname;
    private WebElement name;
    private WebElement email;
    private WebElement phoneNumber;
    private WebElement confidencialityPolicyCheckBox;
    private WebElement submitButton;
    private WebElement errorMessageMandatorySurnameField;
    private WebElement errorMessageMandatoryNameField;
    private WebElement errorMessageMandatoryEmailField;
    private WebElement errorMessageMandatoryPhoneNumberField;
    private WebElement errorMessageNotValidEmail;

    // Here there are many loading functions depending on the context, because dynamic elements (error messages), appear
    // under certain conditions.
    // As loading those elements before their apparition would provoque an error,
    // we only load them when we know they are supposed to be displayed on the application.
    public HightestContactPageRepository loadContactPageNominalContextObjects() {
        HightestContactPageRepository contactPageRepository = null;
        surname = LocalDrivers.defaultProjectDriver.findElement(By.name("your-firstname"));
        name = LocalDrivers.defaultProjectDriver.findElement(By.name("your-name"));
        email = LocalDrivers.defaultProjectDriver.findElement(By.name("your-email"));
        phoneNumber = LocalDrivers.defaultProjectDriver.findElement(By.name("your-tel"));
        confidencialityPolicyCheckBox = LocalDrivers.defaultProjectDriver.findElement(By.name("acceptance-59"));
        submitButton = LocalDrivers.defaultProjectDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/section[2]/div/div[2]/div/div[1]/form/div[3]/p/input"));
        try {
            contactPageRepository = new HightestContactPageRepository();
            webElementsRepository.put("Hightest contact page 'prénom' text input field", surname);
            webElementsRepository.put("Hightest contact page 'nom' text input field", name);
            webElementsRepository.put("Hightest contact page 'e-mail' text input field", email);
            webElementsRepository.put("Hightest contact page 'tèl' text input field", phoneNumber);
            webElementsRepository.put("Hightest contact page confidentiality policy checkbox", confidencialityPolicyCheckBox);
            webElementsRepository.put("Hightest contact page submit button", submitButton);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Hightest contact page objects loading failed : " + e.getCause().getMessage());
        }
        return contactPageRepository;
    }

    public HightestContactPageRepository loadContactPageErrorMessageMandatoryFieldContextObjects() {
        HightestContactPageRepository contactPageRepository = loadContactPageNominalContextObjects();
        errorMessageMandatorySurnameField = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//*[@id=\"wpcf7-f5-o1\"]/form/div[2]/p/span[1]/span"));
        errorMessageMandatoryNameField = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//*[@id=\"wpcf7-f5-o1\"]/form/div[2]/p/span[2]/span"));
        errorMessageMandatoryEmailField = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//*[@id=\"wpcf7-f5-o1\"]/form/div[2]/p/span[3]/span"));
        errorMessageMandatoryPhoneNumberField = LocalDrivers.defaultProjectDriver.findElement(By.xpath("//*[@id=\"wpcf7-f5-o1\"]/form/div[2]/p/span[4]/span"));
        try {
            webElementsRepository.put("Hightest contact page error message for mandatory surname text input field", contactPageRepository.errorMessageMandatorySurnameField);
            webElementsRepository.put("Hightest contact page error message for mandatory name text input field", contactPageRepository.errorMessageMandatoryNameField);
            webElementsRepository.put("Hightest contact page error message for mandatory email text input field", contactPageRepository.errorMessageMandatoryEmailField);
            webElementsRepository.put("Hightest contact page error message for mandatory phone number text input field", contactPageRepository.errorMessageMandatoryPhoneNumberField);

        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Hightest contact page objects loading failed : " + e.getCause());
        }
        return contactPageRepository;
    }

    public HightestContactPageRepository loadContactPageInvalidEmailFormatContextObjects() {
        HightestContactPageRepository contactPageRepository = loadContactPageNominalContextObjects();
        errorMessageNotValidEmail = LocalDrivers.defaultProjectDriver.findElement(By.className("wpcf7-not-valid-tip"));
        try {
            webElementsRepository.put("Hightest contact page invalid format error message for email input field", contactPageRepository.errorMessageNotValidEmail);
        } catch (NoSuchElementException e) {
            testCase.log(Status.FAIL, "Hightest contact page objects loading failed : " + e.getCause());
        }
        return contactPageRepository;
    }


}
