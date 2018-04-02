package Media.net.CM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LinkChecks {

	
	WebDriver driver;
	
	
	
	@BeforeMethod
	public void setup()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\jars\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://www.health.online/");
		driver.get("http://172.16.136.161/a/300x250_kw/300x250_kw.html");
		//driver.get("https://cm.reports.mn/template/framework/preview.php?frm_id=800059826&pagename=keywords-only-300x250.html&isiframe");
	}
	
	
	@Test(enabled=false)
	public void FontUsage()
	{
		List<WebElement> foundFontTags = driver.findElements(By.tagName("*"));
	    for (WebElement foundFontTag : foundFontTags)
	    {
	    	System.out.println(foundFontTag);
	        //System.out.println(foundFontTag.getAttribute("outerHTML"));
	    }
	}
	
	@Test(enabled=false)
	public void SourceCode()
	{
		String Source = driver.getPageSource();
		//assertTrue(Source.contains("Selenium143"));
		
	}
	
	@Test
	public void ImageCheck()
	{
		try {
	
			driver.switchTo().frame("_mN_main_353259147_0_n");
			
			WebElement image = driver.findElement(By.id("kbb_img_1"));
			
			String width = image.getCssValue("width");
			String newwidth= width.replaceAll("[^0-9]", "");		
			System.out.println("Image Height is : " + newwidth);
			double newwidth1 = Double.parseDouble(newwidth);
			System.out.println(newwidth1);
			
			String height = image.getCssValue("height");
			String newheight= height.replaceAll("[^0-9]", "");		    			
			double newheight1 = Double.parseDouble(newheight);
			System.out.println("Image width is : " + newheight1);
			
			String naturalWidth = image.getAttribute("naturalWidth");
			System.out.println("Image naturalWidth is : " + naturalWidth);
			//double newnaturalWidth = Double.parseDouble(naturalWidth);
			
			
			String naturalHeight = image.getAttribute("naturalHeight");
			System.out.println("Image naturalHeight is : " + naturalHeight);
			//double newnaturalHeight = Double.parseDouble(naturalHeight);
			
			
			double d= newwidth1/newheight1;
			
			double[] ratio = {0.92 , 1 , 1.08 , 1.26 , 1.27 , 1.3 , 1.33, 1.34 , 1.39, 1.42 , 1.5 , 1.63 , 1.67, 1.76, 1.84, 2 , 2.07,2.72,2.88,3.03,3.26};
			
			/*if(d==1)
			{
				int natwidth = 140;
				int natheight = 140;
				Assert.assertEquals(newnaturalWidth, natwidth );
				Assert.assertEquals(newnaturalHeight, natheight );
			}*/
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	@AfterMethod
	public void close()
	{
		driver.close();
		//driver.quit();		
	}
}
