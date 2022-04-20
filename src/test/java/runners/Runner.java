package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "./src/test/resources/features",

        glue = {"stepdefinitions","Hooks"},

        tags = "@RoomApi",

        dryRun = false     // true olursa eksik stepleri gosteriyor

        // tags = "@wip and not @smoke"      @wip @smoke    --> wip (altinda smoke tag varsa onlari calistirma)
        // tags = "@wip and @smoke"          @wip @smoke    --> wip ve smoke beraber olan feature lar calisir, tek basina wip veya tek basina smoke olanlar calismaz
        // tags = "@wip or @smoke"           @wip veya @smoke  ikisinden birine sahip olan feature lar calisir



)
public class Runner {
}

