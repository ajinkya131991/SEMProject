package Testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class TestBase 
{
	public WebDriver dr;
	Properties OR = new Properties();
	Properties CMOR = new Properties();
	Properties SEM_OR = new Properties();
	
	public void selectBrowser(String browser)     // For Browsers
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");	
		    dr = new ChromeDriver();	    
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\jars\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		    dr = new FirefoxDriver();		    
		}
	}
		
	public void loadData() throws IOException 
	{   // To create Static objects 		
		File file = new File("C:\\Users\\ajinkya.bh\\workspace\\SEM\\src\\main\\java\\Configfile\\Config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);						
	}
	
	public void SEMloadData() throws IOException 
	{   // To create Static objects 		
		File HomepagePath = new File("C:\\Users\\ajinkya.bh\\workspace\\SEM\\src\\main\\java\\Configfile\\Homepage.properties");
		File CategoryPath = new File("C:\\Users\\ajinkya.bh\\workspace\\SEM\\src\\main\\java\\Configfile\\CategoryPage.properties");
		File ResultPath = new File("C:\\Users\\ajinkya.bh\\workspace\\SEM\\src\\main\\java\\Configfile\\Result.properties");
		
		FileInputStream HomepageFile = new FileInputStream(HomepagePath);
		FileInputStream CategoryFile = new FileInputStream(CategoryPath);
		FileInputStream ResultFile = new FileInputStream(ResultPath);
		
		SEM_OR.load(HomepageFile);
		SEM_OR.load(CategoryFile);
		SEM_OR.load(ResultFile);
	}
	
	public void getUrl(String url)   //URL
	{ 
		dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.get(url);								
	}
	
	public void init() throws IOException    // Main method for initialising browser / URL / Log.class
	{
		loadData();
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
	}
	
	public void SEM_homepageinit() throws IOException    // Main method for initialising browser / URL / Log.class
	{
		SEMloadData(); 
		selectBrowser(SEM_OR.getProperty("Homepagebrowser"));
		getUrl(SEM_OR.getProperty("Homepageurl"));
	}
	
	public void SEM_Categoryinit() throws IOException    // Main method for initialising browser / URL / Log.class
	{
		SEMloadData(); 
		selectBrowser(SEM_OR.getProperty("Categorybrowser"));
		getUrl(SEM_OR.getProperty("Categoryurl"));
	}
	
	public void SEM_Resultinit() throws IOException    // Main method for initialising browser / URL / Log.class
	{
		SEMloadData(); 
		selectBrowser(SEM_OR.getProperty("Resultbrowser"));
		getUrl(SEM_OR.getProperty("Resulturl"));
	}
	
	
	
	
	public void CMinit() throws IOException, InterruptedException 
	{				
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("LoginForAdmin");
		dr = new FirefoxDriver(myprofile);
		dr.manage().window().maximize();
		
		Properties CMOR = new Properties();
		File CMfile = new File("C:\\Users\\ajinkya.bh\\workspace\\CM\\src\\main\\java\\Configfile\\CMconfig.properties");
		FileInputStream cmconfig = new FileInputStream(CMfile);
		CMOR.load(cmconfig);
		
		dr.get(CMOR.getProperty("url"));
		//dr.get("https://cm.reports.mn/template/framework/preview.php?frm_id=800060160&pagename=keywords-only-800x175.html&isiframe");
		Thread.sleep(5000);
	}
	
	public static void main(String []args) throws IOException, InterruptedException
	{
		TestBase test = new TestBase();
		//test.init();
		test.CMinit();		
		//test.selectBrowser("chrome");
		//System.out.println(test.CMOR.getProperty("url"));		
	}
	
	public void closeBrowser()
	{
		dr.close();
		dr.quit();
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*

	public WebDriver driver;
	Properties OR = new Properties();
	String browser = "chrome";
	String url="http://www.health.online/";
	
	public void init() throws IOException    // Main method for initialising browser / URL / Log.class
	{
		loadproperties(); 
		selectBrowser(OR.getProperty("browser"));		
		getUrl(OR.getProperty("url"));	   
	}
	
	public void loadproperties() throws IOException 
	{
		//File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\Configfile\\Config.properties");		
		File file = new File("C:\\Users\\ajinkya.bh\\workspace\\CM\\src\\main\\java\\Configfile\\Config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);		
	}
	
	public void selectBrowser(String browser)
	{
		if(System.getProperty("os.name").contains("window")) 
		{				
			if(browser.equalsIgnoreCase("chrome"))
			{				
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{				
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\jars\\geckodriver-v0.18.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		else if(System.getProperty("os.name").contains("Mac"))   //For Mac (changes .exe should be removed from path)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver");
				driver = new ChromeDriver();
			}
				else if(browser.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.marionette", System.getProperty("user.dir")+"\\src\\jars\\geckodriver-v0.18.0-win64\\geckodriver");
					driver = new FirefoxDriver();	
				}	
			}		
		  }
	    }
	
	public void getUrl(String url)   //URL
	{ 
		driver.get(url);		
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
	}
	
	
	
	public static void main(String args[]) throws IOException
	{
		TestBase test = new TestBase();
		
		test.loadproperties();
		System.out.println(test.OR.getProperty("browser"));
		
		//test.selectBrowser("chrome");
		System.out.println(test.OR.getProperty("url"));
		
		
		//test.init();
		System.out.println("Here");
	}
	
	
	
}
*/