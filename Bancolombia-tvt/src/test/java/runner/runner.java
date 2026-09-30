package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "StepDefinitions",
        features = "src/test/resources/features/",
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        tags = " @test1"
)
public class runner {
}
