package Media.net.CM;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Testbase.TestBase;

public class sample extends TestBase 
{
	@BeforeClass
	public void setUp() throws IOException {
      init();
      System.out.println("URL");
      //org.openqa.selenium.InvalidSelectorException: 
	}
	
	/*@Test
	public void sample1()
	{
		System.out.println(dr.manage().window().getSize());
	}*/
	
	@AfterClass
	public void close()
	{
		closeBrowser();
	}
}
