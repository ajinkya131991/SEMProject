package TeamCM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.PageFactory;

public class IdentifyingUnitDetails 
{
	WebDriver dr;	 
	public IdentifyingUnitDetails(WebDriver dr)
	{
		this.dr = dr;
		PageFactory.initElements(dr, this);  //this - refers current class objects
	}
	
	public void Identify() throws InterruptedException
	{
		//ProfilesIni profile = new ProfilesIni();
		//FirefoxProfile myprofile = profile.getProfile("LoginForAdmin");
		//WebDriver dr = new FirefoxDriver(myprofile);
		//dr.manage().window().maximize();
		
		//dr.get("https://cm.reports.mn/template/framework/preview.php?frm_id=800022585&pagename=keywords-only-641x481.html&isiframe");
		Thread.sleep(5000);				
		String currentURL = dr.getCurrentUrl();		
		String iframe = "&isiframe";
		String newURL = null;
		if(!currentURL.contains(iframe))
		{
			 newURL = currentURL+iframe;
		}
		else { newURL = currentURL;}				
		dr.get(newURL); 
		
		// Unit Type
		
		String[] unit = {"keywords-only","ads-only","hybrid","results"};
		
		for(int i = 0; i<unit.length ; i++ )
		{
			if(newURL.contains(unit[i]))
			{
			System.out.println("Type of unit is : " +unit[i]+ " page");
			}
		}
		
		// Identify size
		
		String lastsize = null;
		
		for(int i = 1; i<=8888 ; i++ )
		{
			for(int j = 1; j<=9999 ; j++ )
			{	
				if(newURL.contains(i+"x"+j))
				{
					lastsize = i+"x"+j;					
				}		
			}
		}
		
		if(!(lastsize==null))
		{			
			System.out.println("Size of unit is : " +lastsize);			
		}
		else 
		{
			System.out.println("Size of unit is : " + " Full screen size");
		}
		
		
		// Identifying Sub units (Interstitials and imagizers) 
		
		/*String interstitials[] = {"641x481","642x482","249x300"};   // Interstitials
		
		for(int a=0; a<interstitials.length; a++)
		{
			if(newURL.contains(interstitials[a]))
			{
			System.out.println("Unit identified is : INTERSTITIAL Unit" );
			}
		}	
		*/
		
		try {
			if(dr.findElement(By.xpath("//*[contains(@onclick,'.close();')]")).isDisplayed());   //Considering all interstitials uses tag 'onclick' and has common value '.close();'
			{
				System.out.println("Unit identified is : INTERSTITIAL Unit");
			}
		} 
		catch (RuntimeException  e) 
		{
			if(e.toString().contains("NoSuchElementException"))
			{
				
			}
		}
		
		
		String Dockedunit[] = {"316x50","316x150"};   //Docked
		
		for(int b=0; b<Dockedunit.length; b++)
		{
			if(newURL.contains(Dockedunit[b]))
			{
				System.out.println("Unit identified is : DOCKED Unit");
			}					
		}
		
		try {
			if(dr.findElement(By.xpath("//*[contains(@id,'kbb_bgimg_1')]")).isDisplayed());    //Considering all imagizers uses tag 'kbb_bgimg_1'
			{
				System.out.println("Unit identified is : IMAGIZER Unit");
			}
		} 
		catch (RuntimeException  e) 
		{
			if(e.toString().contains("NoSuchElementException"))
			{
				
			}
		}
		
		
		//............

		// PLEASE find same elements for each type of unit and create logic for the same (Like above code)
		
		//............
		
		
		// Identifying Units for Fixed or Full Responsive width
		
		
		
		
		
		
		
	}


public static void main (String args[]) throws InterruptedException
{
	//sample s = new sample(dr);
	//s.newsample();
}	

}
