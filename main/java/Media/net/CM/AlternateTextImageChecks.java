package Media.net.CM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AlternateTextImageChecks 
{
	 WebDriver dr;
	 
		public AlternateTextImageChecks(WebDriver dr)
		{
			this.dr = dr;
			PageFactory.initElements(dr, this);  //this - refers current class objects
		}
	
	public void AlternateImageText()
	{
	List<WebElement> lwe = dr.findElements(By.cssSelector("img"));
	int count =0;
	int count1 =0;
	
	//System.out.println(ImageUrl +"Alt Text for this Image is ----> " + AltImage); //will get you all the image urls on the page  
	System.out.println("No Alternate text present for below images path : ");
	Reporter.log("No Alternate text present for below images path : ");
	Reporter.log(" ");
	
	for(WebElement imageFromList:lwe){
		 count++;
	     String ImageUrl=imageFromList.getAttribute("src");
	     String AltImage = imageFromList.getAttribute("alt");
	     if(AltImage.isEmpty())
	     {
	    	 System.out.println(ImageUrl);  // Will print in console.
	    	 Reporter.log(ImageUrl);   // This will print in emailable report.
	     }		    
	}
	
	System.out.println(" Total Numbers of Image present on this site is : " + count);
	Reporter.log(" ");
	Reporter.log(" Total Numbers of Image present on this site is : " + count);
	
}
}

