package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@QAFTestStepProvider
public class GoogleStepDefs {
	@Given("^I am on Google Search Page$")
	public void I_am_on_Google_Search_Page() throws Throwable {

	




		 
		List<String> brokenLinks = getBrokenURLs(new WebDriverTestBase().getDriver(), "http://www.google.co.in", 2, new ArrayList<String>());
		for(String brokenLink : brokenLinks){
		System.out.println(brokenLink);
		}
		 
		 
		}
		public static List<String> getBrokenURLs(WebDriver driver, String appURL, int depth, List<String> links){
		{
			new WebDriverTestBase().getDriver().navigate().to(appURL);
		System.out.println("Depth is: " + depth);
		while(depth > 0){
		List<WebElement> linkElems = new WebDriverTestBase().getDriver().findElements(By.tagName("a"));
		for(WebElement linkElement : linkElems)
		if(!links.contains(linkElement))
		links.add(linkElement.getAttribute("href"));
		for(String link : links)
		getBrokenURLs(driver, link, --depth, links);
		}
		}
		return getBrokenURLs(driver, links, new ArrayList<String>()) ;
		}
		 
		public static List<String> getBrokenURLs(WebDriver driver, List<String> links, List<String> brokenLinks){
		{
		for(String link : brokenLinks){
		driver.navigate().to(link);
		if(driver.getTitle().contains("404 Page Not Found")){
		brokenLinks.add(link);
		}
		}
		}
		return brokenLinks ;
		}
}