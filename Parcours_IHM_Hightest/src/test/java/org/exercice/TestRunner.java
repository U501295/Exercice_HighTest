package org.exercice;

import com.aventstack.extentreports.Status;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.core.gherkin.Pickle;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.exercice.utils.AutomTools;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.exercice.utils.AutomTools.driverImplicitWaitConfig;
import static org.exercice.utils.AutomTools.makeDriverChrome;
import static org.exercice.utils.LocalDrivers.defaultProjectDriver;
import static org.exercice.utils.Reporter.extent;
import static org.exercice.utils.Reporter.extentSparkReporter;
import static org.exercice.utils.Reporter.testCase;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.exercice")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:reports/tests/cucumber/json/cucumberTestReport.json")
public class TestRunner {

    private int currentStepDefIndex = 0;

    @Before("@Exercice")
    public void setupForUI() {
        makeDriverChrome();
        driverImplicitWaitConfig(Duration.ofSeconds(15));
        testCase = extent.createTest("Parcours bout en bout");
        extent.attachReporter(extentSparkReporter);
    }

    @AfterStep("@Exercice")
    public void afterStep(Scenario scenario) throws IOException, IllegalAccessException, NoSuchFieldException {
        // Perform actions after each step, regardless of pass/fail status

        if (scenario.isFailed()) {
            File errorScreenShot = ((TakesScreenshot) defaultProjectDriver)
                    .getScreenshotAs(OutputType.FILE);
            BufferedImage errorImage = ImageIO.read(errorScreenShot);
            ImageIO.write(errorImage, "png", new File("src/test/resources/output/screenshotOfError.png"));
            testCase.addScreenCaptureFromPath("src/test/resources/output/ResultImage.png");

            final byte[] screenshot = ((TakesScreenshot) defaultProjectDriver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "toto");

            Field delegate = scenario.getClass().getDeclaredField("delegate");
            delegate.setAccessible(true);

            TestCaseState state = (TestCaseState) delegate.get(scenario);
            Field testCaseF = state.getClass().getDeclaredField("testCase");
            testCaseF.setAccessible(true);

            TestCase tC = (TestCase) testCaseF.get(state);
            Field pickle = tC.getClass().getDeclaredField("pickle");
            pickle.setAccessible(true);

            Pickle pickleState = (Pickle) pickle.get(tC);
            List<Step> steps = pickleState.getSteps();

//            Field f = scenario.getClass().getDeclaredField("testCase");
//            //f.setAccessible(true);
//            TestCase r = (TestCase) f.get(scenario);
//
            //You need to filter out before/after hooks
            List<PickleStepTestStep> stepDefs = tC.getTestSteps()
                    .stream()
                    .filter(x -> x instanceof PickleStepTestStep)
                    .map(x -> (PickleStepTestStep) x)
                    .collect(Collectors.toList());
//
//
//            //This object now holds the information about the current step definition
//            //If you are using pico container
//            //just store it somewhere in your world state object
//            //and to make it available in your step definitions.
            PickleStepTestStep currentStepDef = stepDefs
                    .get(currentStepDefIndex);


            testCase.log(Status.FAIL, currentStepDef.getStep().getText());


            AutomTools.closeDriver();
            extent.flush();
        }
        currentStepDefIndex += 1;
    }

    @After("@Exercice")
    public void tearDownForUi() {
        AutomTools.closeDriver();
        extent.flush();
    }
}
