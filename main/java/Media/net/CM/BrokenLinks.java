package Media.net.CM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinks {

	WebDriver dr;
	 
	public BrokenLinks(WebDriver dr)
	{
		this.dr = dr;
		PageFactory.initElements(dr, this);  //this - refers current class objects
	}
	
	public void BrokenLink()
	{
	    String homePage = dr.getCurrentUrl();
	    String sametab = dr.getCurrentUrl()+"//#";   
	    String url = "";
	    HttpURLConnection huc = null;
	    int respCode = 200;
	    int count = 0;
	        
	    //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\jars\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		//driver = new FirefoxDriver();
	    
	    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        //driver.get(homePage);
        //Thread.sleep(5000);
        //driver.manage().window().maximize();
	   
        List<WebElement> links = dr.findElements(By.tagName("a"));
        System.out.println("Total links present on this sites are:  "+links.size());
        Reporter.log(" ");
        
        Iterator<WebElement> it = links.iterator();        
        while(it.hasNext())
        {            
        	count++;
            url = it.next().getAttribute("href");
            //System.out.println(url);
            if(url == null || url.isEmpty())
            {
            		System.out.println(url + " : URL is either not configured for anchor tag or it is empty");
            		Reporter.log(url + " : URL is either not configured for anchor tag or it is empty");
            		
                    continue;
            }            
            if(!url.startsWith(homePage))
            {
                System.out.println(url + " : URL belongs to another domain, skipping it.");
                Reporter.log(url + " : URL belongs to another domain, skipping it.");
                
                continue;
            }
            if(url == sametab)
           	{
            	System.out.println(url + " : URL is directing to same page URL");
            	Reporter.log(url + " : URL is directing to same page URL");
            	
           	}
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                huc.setConnectTimeout(2000);
                huc.setRequestMethod("HEAD");                
                huc.connect();                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400)
                {
                    System.out.println(url+" :  is a Broken link");
                    Reporter.log(url+" :  is a Broken link");
                    
                }
                else
                {
                    System.out.println(url+" : is a Valid link");
                    Reporter.log(url+" : is a Valid link");
                   
                }
                    
            } 
            catch (MalformedURLException e) 
            {                
            e.printStackTrace();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }            
        }
        Reporter.log(" ");
        System.out.println("Total Links checked : "+count);
        Reporter.log("Total Links checked : "+count);
        dr.close();
       
    }
}
