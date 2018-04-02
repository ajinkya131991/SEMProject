package Media.net.CM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TeamCM.IdentifyingUnitDetails;
import Testbase.TestBase;

public class CMChecks  extends TestBase 
{
	
	IdentifyingUnitDetails details;
	CodeCheck code;
	HorizontalScroll scroll;
	BrokenLinks broken;
	AlternateTextImageChecks AlternateText;
	ResolutionScreenshot Screenshots;
	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
	  CMinit(); 
	  Thread.sleep(5000);
	  
	  Reporter.log(" ");
      System.out.println("TESTING BELOW CHECKLIST FOR URL :" +dr.getCurrentUrl());
      Reporter.log("TESTING BELOW CHECKLIST FOR URL :" +dr.getCurrentUrl());
      Reporter.log(" ");
    
	}
	
	@Test(priority=0)
	public void codecheckss() throws InterruptedException 
	{
		details = new IdentifyingUnitDetails(dr);
		details.Identify();
	}
	
	@Test(priority=1)
	public void IdentifyUnittype() throws InterruptedException
	{
		code = new CodeCheck(dr);
		code.checkingcodeCM();
	}
	
	@Test
	public void TC001() throws IOException, InterruptedException 
	{
		System.out.println("========== Test Case 1: Providing Screenshots for different resolutions ================");
		Reporter.log("========== Test Case 1: Providing Screenshots for different resolutions ================");
		Reporter.log(" ");
		Screenshots = new ResolutionScreenshot(dr);
		Screenshots.SSResolutions();		
	}
	
	@Test
	public void TC002() throws IOException, InterruptedException
	{
		System.out.println("========== Test Case 2: Check for HORIZONTAL SCROLL if any ================");
		Reporter.log("========== Test Case 2: Check for HORIZONTAL SCROLL if any ================");
		Reporter.log(" ");
		Reporter.log("**** Note: If No Errors are displayed then no horizontal scroll present on this page ****");
		scroll = new HorizontalScroll(dr);
		scroll.scrollsss();	
	}	
	
	@Test
	public void TC004() 
	{
		System.out.println("========== Test Case 4: Check for Broken Links on a page ================");
		Reporter.log("========== Test Case 4: Check for Broken Links on a page ================");
		broken = new BrokenLinks(dr);
		broken.BrokenLink();
	}	
	
	
	@AfterClass
	public void close()
	{
		closeBrowser();
	}
}
