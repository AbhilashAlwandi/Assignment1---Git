package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import org.openqa.selenium.By;

@QAFTestStepProvider
public class GoogleStepDefs {
	@Given("^I am on Google Search Page$")
	public void I_am_on_Google_Search_Page() throws Throwable {
		
		new WebDriverTestBase().getDriver().get("http://www.google.com/");
	}
	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String searchKey) throws Throwable {
		QAFExtendedWebElement searchBoxElement = new QAFExtendedWebElement("name=q");
		QAFExtendedWebElement searchBtnElement = new QAFExtendedWebElement("name=btnG");
		
		searchBoxElement.clear();
		searchBoxElement.sendKeys(searchKey);
		searchBtnElement.click();

	}
	@Then("^it should have \"([^\"]*)\" in search results$")
	public void it_should_have_in_search_results(String result) throws Throwable {
		QAFExtendedWebElement searchResultElement =
				new QAFExtendedWebElement("partialLink=" + result);
		searchResultElement.verifyPresent(result);
	}

	@Then("^it should have following search results:$")
	public void it_should_have_all_in_search_results(List<String> results) {
		QAFExtendedWebElement searchResultElement;
		for (String result : results) {
			searchResultElement = new QAFExtendedWebElement("partialLink=" + result);
			searchResultElement.verifyPresent(result);
		}
	}
	
	/**
	 * @author M1039682
	 */
	
	@Given("^I am on HUB2Test Page$")
	public void I_am_on_HUB2Test_Page() throws Throwable {
		
		new WebDriverTestBase().getDriver().get("http://hub2-test.lfg.com/");
	}
	
	@When("^I enter username and password$")
	public void i_enter_username_and_password() throws Throwable {
		new WebDriverTestBase().getDriver().findElement(By.id("")).sendKeys("");
		new WebDriverTestBase().getDriver().findElement(By.id("")).sendKeys("");
		new WebDriverTestBase().getDriver().findElement(By.id("")).click();
	}

	@Then("^I expect login to Hub(\\d+)$")
	public void i_expect_login_to_Hub(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
