package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features="src/test/resources/features",
		glue="glues",
		monochrome=true,
		dryRun=false,
		plugin= {"pretty","html:target/cucumber.html",
				"json:target/cucumber.json",
				"junit:target/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failedtestscenarios.txt"}
)

public class TestRunner2ExtentReports extends AbstractTestNGCucumberTests
{
}
