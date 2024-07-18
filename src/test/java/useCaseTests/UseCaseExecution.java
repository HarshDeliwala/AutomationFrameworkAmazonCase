package useCaseTests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.ImmutableList;

import genericUtilities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import objectRepository.HomePage;
import objectRepository.StorePage;

@Listeners(genericUtilities.ListenersImplementationClass.class)
public class UseCaseExecution extends BaseClass 
{
	@Test
	public void useCaseTest() throws IOException, InterruptedException
	{
		//Step 1: Initialize WebDriver
		WebDriver driver = null;
		
		// Step 2: Read The Required Data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		// Step 3: Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + " launched");
		} else {
			System.out.println("Invalid Browser Name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);

		// Step 4: Load the URL
		driver.get(URL);
		
		//Step 5: Use Case Execution
		HomePage hp=new HomePage(driver);
		hp.selectHomeDropDown("Electronics");
		
		hp.enterTextInHomeSearchBox("IPhone 13");
		Thread.sleep(3000);
		//System.out.println(hp.getiPhone13SearchList());
		List<String> expectedLabelsList = new ArrayList<String>();
		
		expectedLabelsList.add("iphone 13");
		expectedLabelsList.add("iphone 13 back cover");
		expectedLabelsList.add("iphone 13 pro cover");
		expectedLabelsList.add("iphone 13 cover");
		expectedLabelsList.add("iphone 13 pro max cover");
		expectedLabelsList.add("iphone 13 case");
		expectedLabelsList.add("iphone 13 screen guard");
		expectedLabelsList.add("iphone 13 pro back cover");
		expectedLabelsList.add("iphone 13 pro");
		expectedLabelsList.add("iphone 13 pro max");
		
		SoftAssert assert1=new SoftAssert();
		assert1.assertEquals(hp.getiPhone13SearchList(), expectedLabelsList);
		
		hp.clearSearchBox();
		Thread.sleep(1000);
		hp.enterTextInHomeSearchBox("IPhone 13 128 GB");
		Thread.sleep(2000);
		hp.productSearchClick();
		Thread.sleep(2000);
		hp.productPageNavigation();
		Thread.sleep(2000);
		
		wUtil.switchToWindow(driver, "Apple-iPhone-13-128GB-Midnight");
		Thread.sleep(2000);
		hp.clickVisitAppleStoreLink();
		
		StorePage sp=new StorePage(driver);
		sp.appleWatchClick();
		Thread.sleep(2000);
		sp.productGPSCellularClick();
		
		wUtil.scrollDownAction(driver);
		Thread.sleep(2000);
		
		wUtil.mouseHoverAction(driver, sp.mouseHoverEle());
		Thread.sleep(2000);
		sp.quickLookUpClick();
		Thread.sleep(2000);
		
		
		//System.out.println(wUtil.getAlertText(driver));
		
		String expectedText="Apple Watch SE (2nd Gen)[GPS + Cellular 44 mm]smart watch w/Starlight Aluminium Case & Starlight Sport Band";
		
		Assert.assertEquals(sp.verifyTextGPSCellular(), true);
		Thread.sleep(2000);
		driver.quit();
		
		
		
	}

	
		
	}


