package objectRepository;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Declaration
	
	@FindBy(xpath = "(//select[@id='searchDropdownBox'])[1]")
	private WebElement homeDropDown;
	
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement homeSearchBox;
	
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement homeSearchBtn;
	
	@FindBy(how = How.ID, using = "nav-flyout-searchAjax") 
	private List<WebElement> iPhone13SearchList;
	
	
	@FindBy(xpath = "(//div[@class='left-pane-results-container'])//div")
	private WebElement productSearch;
	
	@FindBy(xpath = "//span[normalize-space()='Apple iPhone 13 (128GB) - Midnight']")
	private WebElement productPageNavigation;
	
	
	@FindBy(xpath = "//a[@id='bylineInfo']")
	private WebElement visitAppleStoreLink;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	
	public void selectHomeDropDown(String txt)
	{
		handleDropDown(txt, homeDropDown);
	}
	
	public void enterTextInHomeSearchBox(String txt)
	{
		homeSearchBox.sendKeys(txt);
	}
	
	public void clickHomeSearchBtn()
	{
		homeSearchBtn.click();
	}
	
	
	public List<String> getiPhone13SearchList() {
	    //create an empty list in which the label texts will be stored
	    List<String> actualSearchList = new ArrayList<String>();
	    //iterate through all the webElements
	    for (WebElement webElement : iPhone13SearchList) {
	        //add each webElements label to the labelsList
	    	actualSearchList.add(webElement.getText());
	    }
	    //return all the label texts that are visible in the dropdown
	    return actualSearchList;
	}
	public void clearSearchBox()
	{
		homeSearchBox.clear();
	}
	
	public void productSearchClick()
	{
		productSearch.click();
	}
	
	public void productPageNavigation()
	{
		productPageNavigation.click();
	}
	
	public void clickVisitAppleStoreLink()
	{
		visitAppleStoreLink.click();
	}
	

}
