package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features= {".//Features/LoginDDTExcel.feature"},
		//features= {".//Features//"},All
		//features= {".//Features//LoginDDTExcel.feature",.//Features//LoginDDT.feature", },//only two
		features= {".//Features//Login.feature"},
		//features="@target/rerun.txt" runs only failures
		glue="stepDefinitions",
		plugin= {"pretty", "html:reports1/myreport.html", "json:reports1/myreport.json", "rerun:target/rerun.txt",},
		dryRun=false,
		monochrome=true//junk characters will be removed from console window..?, 0...
		//tags = "@sanity"//scenarios tagged with @sanity(similar to groups in TestNG)
		//tags = "@sanity and @regression",//scenarios tagged with both @sanity and @regression
		//tags = "@sanity or @regression",//scenarios tagged with either @sanity and @regression
		//tags = "@sanity and not @regression",//scenarios tagged with  @sanity but not tagged with @regression
		)
public class TestRunner {
	

}
