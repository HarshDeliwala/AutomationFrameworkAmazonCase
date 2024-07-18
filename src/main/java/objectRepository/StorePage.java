package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StorePage 
{
	//Declaration
	
	@FindBy(xpath = "(//a[@role='button'])[4]")
	private WebElement appleWatch;
	
	@FindBy(xpath = "//li[@class='Navigation__navItem__bakjf Navigation__hasChildren__jSUsH']//li[6]//a[1]")
	private WebElement productGPSCellular;
	
	
	@FindBy(xpath = "(//span[@class='QuickLook__label__tOBqR'][normalize-space()='Quick look'])[2]")
	private WebElement quickLookUp;
	
	
	
	@FindBy(xpath = "(//a[@class='Overlay__overlay__LloCU EditorialTile__overlay__RMD1L'])[2]")
	private WebElement mouseHoverEle;
	
	//Apple Watch SE (2nd Gen)[GPS + Cellular 44 mm]smart watch w/Starlight Aluminium Case & Starlight Sport Band
	@FindBy(xpath = "(//a[contains(text(),'Apple Watch SE (2nd Gen)[GPS + Cellular 44 mm]smar')])[1]")
	private WebElement textGPSCellular;
	
	//Initialization 
	public StorePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public void appleWatchClick()
	{
		appleWatch.click();
	}
	
	public void productGPSCellularClick()
	{
		productGPSCellular.click();
	}
	
	public void quickLookUpClick()
	{
		if(quickLookUp.isDisplayed())
		{
			quickLookUp.click();
		}
	}
	
	public WebElement mouseHoverEle()
	{
		return mouseHoverEle;
	}
	
	public boolean verifyTextGPSCellular()
	{
		String actualtxt=textGPSCellular.getText();
		String expectedTxt="Apple Watch SE (2nd Gen)[GPS + Cellular 44 mm]smart watch w/Starlight Aluminium Case & Starlight Sport Band...";
		Assert.assertEquals(actualtxt, expectedTxt);
		return true;
	}
	

}
