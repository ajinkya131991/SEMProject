package Media.net.CM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Testbase.TestBase;

public class SemChecks extends TestBase 
{
	HorizontalScroll scroll;
	BrokenLinks broken;
	AlternateTextImageChecks AlternateText;
	ResolutionScreenshot Screenshots;
	
	
	
	@BeforeClass
	public void setUp() throws IOException {
      init();
      System.out.println("TESTING BELOW CHECKLIST FOR URL :" +dr.getCurrentUrl());
      Reporter.log("TESTING BELOW CHECKLIST FOR URL :" +dr.getCurrentUrl());
      Reporter.log(" ");
    
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
	public void TC003() 
	{
		System.out.println("========== Test Case 3: Check for Alternate Text Present for all images ================");
		
		Reporter.log("========== Test Case 3: Check for Alternate Text Present for all images ================");
		Reporter.log(" ");
		AlternateText = new AlternateTextImageChecks(dr);
		AlternateText.AlternateImageText();		
	}	


	@Test
	public void TC004() 
	{
		System.out.println("========== Test Case 4: Check for Broken Links on a page ================");
		Reporter.log("========== Test Case 4: Check for Broken Links on a page ================");
		broken = new BrokenLinks(dr);
		broken.BrokenLink();
	}	
	
	
	
	
	
	
		/*System.out.println("========== Test Case 2: Check for Broken Links on a page ================");
		broken = new BrokenLinks();
		broken.*/
		
		
	
	
	@AfterClass
	public void close()
	{
		closeBrowser();
	}
}
