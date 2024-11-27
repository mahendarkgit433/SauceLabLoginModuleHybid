package test;

import org.testng.annotations.DataProvider;

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
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/failedtestscenarios.txt"}
)

public class TestRunner1ParallelScenarios extends AbstractTestNGCucumberTests
{
	
	@DataProvider(parallel=true)
	public Object[][] scenario()
	{
		return(super.scenarios());
	}
}
