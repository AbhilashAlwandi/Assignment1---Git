package com.quantum.steps;




import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Checklinks {

	static WebDriver driver;
	static String userDir = "";

	public static void main(String[] args) throws Exception {

		setupDriver();

		List<WebElement> allImages = findAllLinks(driver);

		System.out.println("Total number of elements found " + allImages.size());

		for (WebElement element : allImages) {

			try

			{

				System.out.println("URL: " + element.getAttribute("href") + " returned "
						+ isLinkBroken(new URL(element.getAttribute("href"))));

			}

			catch (Exception exp)

			{

				System.out.println(
						"At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());

			}

		}

		cleanSession();

	}

	public static List<WebElement> findAllLinks(WebDriver driver)

	{

		List<WebElement> elementList = new ArrayList<WebElement>();

		elementList = driver.findElements(By.tagName("a"));

		elementList.addAll(driver.findElements(By.tagName("img")));

		List<WebElement> finalList = new ArrayList<WebElement>();

		for (WebElement element : elementList)

		{

			if (element.getAttribute("href") != null)

			{

				finalList.add(element);

			}

		}

		return finalList;

	}

	public static String isLinkBroken(URL url) throws Exception

	{

		String response = "";

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try

		{

			connection.connect();

			response = connection.getResponseMessage();

			connection.disconnect();

			return response;

		}

		catch (Exception exp)

		{

			return exp.getMessage();

		}

	}

	private static void setupDriver() {

		userDir = System.getProperty("user.dir");

		DesiredCapabilities capability = DesiredCapabilities.chrome();

		File file = new File(userDir + "//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		capability.setBrowserName("chrome");
		capability.setJavascriptEnabled(true);

		driver = new ChromeDriver(capability);

		driver.get("https://google.co.in/");

		driver.manage().window().maximize();

	}

	private static void cleanSession() {

		driver.close();

	}

}