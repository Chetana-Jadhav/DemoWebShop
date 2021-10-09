package Stepdefs;

import Utilities.TestContext;
import com.google.inject.Inject;
import io.cucumber.java.*;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

@Log4j2
public class HookStefs {

    @Inject
    TestContext testContext;

    @Before
    public void SetUp(Scenario scenario) {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setAcceptInsecureCerts(true);
        // String browserName = System.getProperty("Chrome");
        // testContext.setDriver(DriverFactory.createInstance(browserName));
        testContext.setDriver(new ChromeDriver(cap));
        testContext.getDriver().manage().window().maximize();
        testContext.getDriver().manage().deleteAllCookies();
        testContext.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        testContext.setScenario(scenario);

    }


    @After
    public void cleanUp() {
        if (!(testContext.getDriver() == null))
            testContext.getDriver().quit();

    }

    @BeforeStep
    public void Before_Step() throws InterruptedException {
        Thread.sleep(2000);
    }

    @AfterStep
    public void afterEachStep() {
        if (!(testContext.getDriver() == null)) {
            TakesScreenshot scrnShot = (TakesScreenshot) testContext.getDriver();
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            testContext.getScenario().attach(data, "image/png", "step name:" + testContext.getScenario().getName());
        }
    }
}


