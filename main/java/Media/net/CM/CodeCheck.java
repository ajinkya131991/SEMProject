package Media.net.CM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CodeCheck {   // Need to add All code..........

	 WebDriver dr;


		public CodeCheck(WebDriver dr)
		{
			this.dr = dr;
			PageFactory.initElements(dr, this);  //this - refers current class objects
		}
	
		public void checkingcodeDLA()
		{
			    
	    String stored_report = dr.getPageSource();
	    
	    String[] checks = {"getDomainFromCurrentCalledResource","loadJSAsyncOnHead","readyCallback()","getGAId","getDataLayerVariablesJson","jsonToUrlParam","replaceEvents","fireSafePixels","setLanderTitle","getResolvedParam","get_browser","getDefaultData","sendDataForAnalytics","sendAmplitudeData","getAllParam"};
	    int count=0;
	    for(String check:checks)
	    {
	    	boolean checking = stored_report.contains(check);
	    	count++;
	    	if(count>1)
	    	{
	    		System.out.println(check+ " has repeated /" + count + "/  times in the code");
	    	}
	    	/*if(checking == false)
	    	{
	    		System.out.println(check+ " --> Text not present in the code");
	    	}*/	    
	    }}
	    
	    public void checkingcodeSEM()
		{
			    
	    String stored_report = dr.getPageSource();
	    
	    String[] checks = {"getDomainFromCurrentCalledResource","loadJSAsyncOnHead","readyCallback()","getGAId","getDataLayerVariablesJson","jsonToUrlParam","replaceEvents","fireSafePixels","setLanderTitle","getResolvedParam","get_browser","getDefaultData","sendDataForAnalytics","sendAmplitudeData","getAllParam"};
	    int count=0;
	    for(String check:checks)
	    {
	    	boolean checking = stored_report.contains(check);
	    	count++;
	    	if(count>1)
	    	{
	    		System.out.println(check+ " has repeated /" + count + "/  times in the code");
	    	}
	    	if(checking == false)
	    	{
	    		System.out.println(check+ " --> Text not present in the code");
	    	}	    
	    	}
		}
	    
	    public void checkingcodeCM()
		{
			    
	    String stored_report = dr.getPageSource();	
	    String[] beincode = {"viewport"," formatViewAfterLoad()"};	    
	    String[] notbeincode = {"woff2","trans.png","Detecttext()","EmulateIE7","AdChoices.png","AdChoice.png","ad_choice_v4.png",".ads"};
	    		
	   
	    for(String check:beincode)
	    {
	    	boolean Present = stored_report.contains(check);	    
	    	
	    	if(Present == false)
	    	{
	    		System.out.println(check+ " --> Text need to be present in the code");
	    	}
	    }
	    
		for(String check2:notbeincode)
		 {
		  	boolean NeedtoPresent = !stored_report.contains(check2);	
	    	
	    	if(NeedtoPresent == false)
	    	{
	    		System.out.println(check2+ " --> Text should not be present in the code");
	    	}
	    }
	    
	    
	    
	    
	    //driver.close();
	 
	    /*File f = new File("C:\\Users\\Ajinkya.Ajinkya-HP.000\\Desktop\\code.txt");
	    FileWriter writer = new FileWriter(f,true);
	    writer.write(stored_report);
	    System.out.println("Report Created is in Location : " + f.getAbsolutePath());
	    writer.close();*/
       
        //driver.get(homePage);
        //driver.manage().window().maximize();

	}
}
