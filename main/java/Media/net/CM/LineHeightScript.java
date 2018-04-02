package Media.net.CM;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class LineHeightScript {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
	    //driver = new ChromeDriver();
	    driver = new HtmlUnitDriver();
	    driver.get("http://www.health.online/");
	    driver.manage().window().maximize();
	    Thread.sleep(5000);
	    
	    List<WebElement> foundFontTags = driver.findElements(By.xpath(".//*"));
	    for (WebElement foundFontTag : foundFontTags)
	    {
	    String get = foundFontTag.getCssValue("line-height");
	    
	    String element = foundFontTag.getAttribute("class");

	    	if(get.contains("em")||get.contains("px"))    //||get.contains("em"))
	    	{    	
	    		String newget = get;
	    		String newelement = element;
	    		String finduniques = (newget +"  "+ newelement);
	    		
	    		/*List<String> list = new ArrayList<String>();
	    		list.add(finduniques);
	    		
	    		Set<String> set = new HashSet<String>(list);
	    		list.clear();
	    		list.addAll(set);
	    		
	    		//ArrayList<String> uniqueList = new ArrayList<String>(set);
	    		System.out.println(list);*/
	    		
	    		
	    		HashMap<String, String> hm = new HashMap<String,String>();
	    	    hm.put(newget,element);
	    		
	    		for(Map.Entry m:hm.entrySet())
	    		{ 	    		
	    			//System.out.println("Line Height is : "+ m.getKey()+" And its class name is : "+m.getValue()); 	
	    			String result = m.getKey() +" "+m.getValue();
	    			
	    			List<String> list = new ArrayList<String>();
		    		list.add(result);
		    		
		    		Set<String> set = new HashSet<String>(list);
		    		set.addAll(set);
		    		System.out.println(set);
		    		
		    		ArrayList<String> uniqueList = new ArrayList<String>(set);
		    		//System.out.println(uniqueList);
	    			
	    			
	    		}
	    	//}	    		    	
	    }
	}
}
}





















/*List<WebElement> foundFontTags = driver.findElements(By.xpath(".//*"));
for (WebElement foundFontTag : foundFontTags)
{
String get = foundFontTag.getCssValue("line-height");

String element = foundFontTag.getAttribute("class");
//String element1 = foundFontTag.getAttribute("a");

	 
//if(!(get==null)){
	if(get.contains("em")||get.contains("px"))    //||get.contains("em"))
	{    	
		String newget = get;
		String newelement = element;
		String finduniques = (newget +"  "+ newelement);
		
		List<String> list = new ArrayList<String>();
		list.add(finduniques);
		
		Set<String> set = new HashSet<String>(list);
		list.clear();
		list.addAll(set);
		
		//ArrayList<String> uniqueList = new ArrayList<String>(set);
		System.out.println(list);
		
		
		HashMap<String, String> hm = new HashMap<String,String>();
	    hm.put(newget,element);
		
		for(Map.Entry m:hm.entrySet())
		{ 	    		
			//System.out.println("Line Height is : "+ m.getKey()+" And its class name is : "+m.getValue()); 	    		
		}
	//}	    		    	
}
}
}
}*/