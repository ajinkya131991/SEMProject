package Media.net.CM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ImageLoadFail 
{
	@Test
	public void Imagecheck()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("http://c8stage.keywordblocks.com/test_template.html?template_key=TME27JV&size=300x250&v=30&image_width=1&image_height=800");
	
        driver.switchTo().frame("mnet_ifr");
        WebElement ImageFile = driver.findElement(By.xpath("/html/body/div/ul/li/div/div[1]"));
        
        ImageFile.isDisplayed();
        
      
		
		
			
	    Boolean ImagePresent = null;
		try {
			
			
			
			
			//ImagePresent = (Boolean) ((JavascriptExecutor)driver)
				//	.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
			
			if(!ImagePresent) 
			  {
				System.out.println("Image not displayed.");
			  } else 
			  {
				System.out.println("Image displayed.");
			  }
			
		    
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			
        //WebElement ImageFile = driver.findElement(By.id(“imageid”));
			
			
		
		
		
		
	}	

}
