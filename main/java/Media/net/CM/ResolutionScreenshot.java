package Media.net.CM;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ResolutionScreenshot {
	WebDriver dr;   // remove static public 


		public ResolutionScreenshot(WebDriver dr)
		{
			this.dr = dr;
			PageFactory.initElements(dr, this);  //this - refers current class objects
		}
		
		public void SSResolutions() throws IOException, InterruptedException
		//public static void main(String args[]) throws InterruptedException, IOException
		{
			
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
		//dr = new ChromeDriver();
		//dr.get("http://www.health.online/");
	    //Thread.sleep(5000);
	    dr.manage().window().maximize();
			
	  
	    int width = dr.manage().window().getSize().getWidth();
        int height = dr.manage().window().getSize().getHeight();
        
        
        int sizes[] = {320,480,720,1080,width};
    
        
        for(int i=0 ; i<sizes.length; i++)
        {
        	
        	int resolution = sizes[i];
        	Dimension d = new Dimension(resolution,height);
        	int h = d.getHeight();
    	    int w = d.getWidth();
    	    Reporter.log("SCREENSHOT FOR SIZE : " +w+"X"+h);
    	    //System.out.println(w+"X"+h);
    	    String destFile = "C:\\Users\\ajinkya.bh\\workspace\\CM\\src\\main\\java\\ScreenShot\\"+w+"X"+h+".png";
    	    String ServerdestFile = "//172.16.140.179//File//QA//SeleniumScreenshots//"+w+"X"+h+".png";
    	    dr.manage().window().setSize(d);
    	    File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);	 
    	    FileUtils.copyFile(src, new File(destFile));
    	    FileUtils.copyFile(src, new File(ServerdestFile));
    	    Reporter.log("<a href="+"file:" + ServerdestFile + "><img src=/screenshots/" + ServerdestFile + " style=width:100px;height:100px;/>" + ServerdestFile + "</a><br/>");
    	    //System.out.println("<a href="+"file:" + ServerdestFile + "><img src=/screenshots/" + ServerdestFile + " style=width:100px;height:100px;/>" + ServerdestFile + "</a><br/>");
        	
    	    d = null;
    	    h= 0;
    	    w = 0;
    	    Reporter.log(" ");
    	    
        }
        
        
        
            
         
  	   /* Dimension d = new Dimension(320,height);
	    int h = d.getHeight();
	    int w = d.getWidth();
	    String destFile = "C:\\Users\\ajinkya.bh\\workspace\\CM\\src\\main\\java\\ScreenShot\\"+w+"X"+h+".png";
	    String ServerdestFile = "//172.16.140.179//File//QA//SeleniumScreenshots//"+w+"X"+h+".png";
	    dr.manage().window().setSize(d);
	    File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);	  
	    FileUtils.copyFile(src, new File(destFile));
	    FileUtils.copyFile(src, new File(ServerdestFile));
	    Reporter.log("<a href="+"file:" + ServerdestFile + "><img src=/screenshots/" + ServerdestFile + " style=width:100px;height:100px;/>" + ServerdestFile + "</a><br/>");
	    System.out.println("<a href="+"file:" + ServerdestFile + "><img src=/screenshots/" + ServerdestFile + " style=width:100px;height:100px;/>" + ServerdestFile + "</a><br/>");*/
	   
	    
	    
	    
	    
	    
	       
	    /*String destFile1 = "C:\\Users\\ajinkya.bh\\workspace\\CM\\src\\main\\java\\Screenshot\\480.png "; 
	    Dimension d1 = new Dimension(480,height);
	    dr.manage().window().setSize(d1);
	    File src1 = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src1, new File(destFile1));
	    
	    String destFile2 = "C:\\Users\\ajinkya.bh\\workspace\\CM\\src\\main\\java\\ScreenShot\\1080.png "; 
	    Dimension d2= new Dimension(1080,height);
	    dr.manage().window().setSize(d2);
	    File src2= ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src2, new File(destFile2));
	    
	    String destFile3 = "C:\\Users\\ajinkya.bh\\workspace\\CM\\src\\main\\java\\ScreenShot\\FullPage.png"; 
	    Dimension d3= new Dimension(width,height);
	    dr.manage().window().setSize(d3);
	    File src3 = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src3, new File(destFile3));
	    	    
		//Resize the current window to the given dimension
	    dr.manage().window().setSize(d);
		//driver.close();
*/	}
}
