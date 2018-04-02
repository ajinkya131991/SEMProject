package Media.net.CM;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HorizontalScroll {

	 WebDriver dr;


	public HorizontalScroll(WebDriver dr)
	{
		this.dr = dr;
		PageFactory.initElements(dr, this);  //this - refers current class objects
	}
	
	
	//public static void main(String[] args) throws InterruptedException {
	public void scrollsss(){
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
		//driver = new ChromeDriver();
	    //driver.get("http://www.health.online/");
	    
	   // driver.get("http://theringlord.com/cart/shopdisplayproducts.asp?id=232&cat=Shield+Scale+Kits");
	    //Thread.sleep(5000);

	   // driver.manage().window().maximize();
        
		 
	    
        int width = dr.manage().window().getSize().getWidth();
        int height = dr.manage().window().getSize().getHeight();
        
        for(int i= width; i>=320 ; i-- )
        {
        	Dimension d = new Dimension(i,height);
        	dr.manage().window().setSize(d);        	
        	JavascriptExecutor javascript = (JavascriptExecutor) dr;
    	    Boolean horzscrollStatus = (Boolean) javascript.executeScript
    	    		("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
        	
        	if(horzscrollStatus == false)
        	{
        		//do nothing	
        	}
        	else
        	{
        		System.out.println("Horizontal Scroll Present at resolution : " +d);
        		Reporter.log("Horizontal Scroll Present at resolution : " +d);
        	}
        }
        
        dr.manage().window().maximize();
       
	    
	}

}
