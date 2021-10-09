package Utilities;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
@ScenarioScoped
public class TestContext {
    WebDriver driver;
    Scenario scenario;
}
