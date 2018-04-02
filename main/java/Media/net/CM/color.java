package Media.net.CM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.Color;

public class color {

	public static WebDriver driver;
	public static String newhex;
	public static void main(String[] args) throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
	    //driver = new ChromeDriver();
	    driver = new HtmlUnitDriver();
	    driver.get("http://www.health.online/");
	    Thread.sleep(5000);
	    driver.manage().window().maximize();
	
	    List<WebElement> foundFontTags = driver.findElements(By.xpath(".//*"));
	    for (WebElement foundFontTag : foundFontTags)
	    { 	
	    	String get = foundFontTag.getCssValue("color");		    	
	    	String element = foundFontTag.getAttribute("class");
	    	String hex = Color.fromString(get).asHex();
            	    	
	    	if(hex.contains("#"))
	    	{    		
	    		 newhex = hex.replace("#", "");
	    	}
	    	
             HashMap<String, String> hm = new HashMap<String,String>();
	    	 hm.put(newhex,element);
	    		    	
	    		/*if(newhex.contains("000000")||newhex.contains("0000ee"))
	    		{
	    			System.out.print("");
	    		}*/
	    		/*else
	    		{*/
	    			for(Map.Entry m:hm.entrySet())
	    	    	{  
	    				int n = newhex.length();
	    	            int count=0;
	    	            int count1 = 0;
	    	            int count2 = 0;
	    	            for (int i = 1; i < n; i++)	
	    	            {
	    	            	if (newhex.charAt(i) != newhex.charAt(1)) 
	    	            	{
	    	                    break;
	    	                }
	    	            	count++;
	    	            	
	    	            	if (i%2 == 0 && newhex.charAt(i) != newhex.charAt(0))
    	            		{
    	            			break;
    	            		}
    	            		count1++;
    	            		
    	            		if (i%2 == 1 && newhex.charAt(i) != newhex.charAt(1))
    	            		{
    	            			break;
    	            		}
    	            		count2++;
	    	            	
	    	            }
	    	            
	    	            //if (count == n-1) 
	    	            if (count1 == n-1 && count2 == n-1) 
	    	            {
	    	            	System.out.println("Color is : "+ m.getKey()+" And its class name is : "+m.getValue());  
	    	            }
	    	            	    	            				
	    		}
	    	}
	    }

	}









/*List<WebElement> foundFontTags = driver.findElements(By.xpath(".//*"));
for (WebElement foundFontTag : foundFontTags)
{ 	
	String get = foundFontTag.getCssValue("color");		    	
	String element = foundFontTag.getAttribute("class");
	String hex = Color.fromString(get).asHex();
    	    	
	if(hex.contains("#"))
	{    		
		 newhex = hex.replace("#", "");
	}
	
     HashMap<String, String> hm = new HashMap<String,String>();
	 hm.put(newhex,element);
		    	
		if(newhex.contains("000000")||newhex.contains("0000ee"))
		{
			System.out.print("");
		}
		else
		{
			for(Map.Entry m:hm.entrySet())
	    	{  
				int n = newhex.length();
	            int count=0;
	            for (int i = 1; i < n; i++)	
	            {
	            	if (newhex.charAt(i) != newhex.charAt(1)) 
	            	{
	                    break;
	                }
	            	count++;
	            }
	            
	            if (count == n-1) 
	            {
	            	System.out.println("Color is : "+ m.getKey()+" And its class name is : "+m.getValue());  
	            }
	            
	        }	    				
		}
	}
}

}*/




