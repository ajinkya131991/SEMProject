package SEMChecklists;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Media.net.CM.AlternateTextImageChecks;
import Testbase.TestBase;

public class CategoryPage extends TestBase 
{
	AlternateTextImageChecks AlternateText;
	
	@BeforeClass
	public void setUp() throws IOException {
	  SEM_Categoryinit();
      System.out.println("TESTING BELOW CHECKLIST FOR URL :" +dr.getCurrentUrl());
      Reporter.log("TESTING BELOW CHECKLIST FOR URL :" +dr.getCurrentUrl());
      Reporter.log(" ");
    
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
	
	@AfterClass
	public void close()
	{
		closeBrowser();
	}
}
