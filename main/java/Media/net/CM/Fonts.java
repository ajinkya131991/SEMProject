package Media.net.CM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fonts {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\jars\\chromedriver_win32 (1)\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://www.zlti.com");
	    Thread.sleep(5000);

	    //WebElement el = driver.findElement(By.cssSelector("#menu-item-13 > a > span"));
	    //System.out.println(el.getText());
	    //System.out.println(el.getCssValue("font-family"));
	    
	    //List<WebElement> foundFontTags = driver.findElements(By.cssSelector("[style*='font-family:fontname']"));
	    List<WebElement> foundFontTags = driver.findElements(By.xpath("//*"));
	    for (WebElement foundFontTag : foundFontTags)
	    {
	    	//boolean a = false;
	    	   //System.out.println(foundFontTag.getCssValue("font-family"));
	    	   //System.out.println(foundFontTag.getCssValue("font-weight"));
	    	   //System.out.println(foundFontTag.getCssValue("color"));
	    	String get = foundFontTag.getCssValue("line-height");
	    	//int value = Integer.parseInt(get);
	    	//String get = foundFontTag.getAttribute("color");
	    	
	    	if(get.contains("."))
	    	{
	    		
	    		System.out.println(get);
	    	}
	    	//Boolean b = Boolean.valueOf(get);
	    	//System.out.println(b);
	    	/*if(get==get)
	    	{
	    		System.out.println(foundFontTag);
	    		//System.out.println(foundFontTag.getAttribute("innerHTML"));
	    	}*/
	    	 
	    	//System.out.println(getting);
	    	   
	    	   //if(!foundFontTag.getCssValue(null))
	    	   {
	    		   
	    	   }
	     
	    }
	    
	  
	    
	    
	    driver.close();
	}

}
