package Media.net.CM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.PageFactory;

import Testbase.TestBase;

public class firefoxprofile extends TestBase {

	WebDriver dr;

	public firefoxprofile(WebDriver dr)
	{
		this.dr = dr;
		PageFactory.initElements(dr, this);  //this - refers current class objects
	}
	
	public void firefox() throws InterruptedException, IOException 
	{
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("LoginForAdmin");
		WebDriver dr = new FirefoxDriver(myprofile);
		dr.manage().window().maximize();
		
		Properties CMOR = new Properties();
		File CMfile = new File("C:\\Users\\ajinkya.bh\\workspace\\CM\\src\\main\\java\\Configfile\\CMconfig.properties");
		FileInputStream cmconfig = new FileInputStream(CMfile);
		CMOR.load(cmconfig);
		
		dr.get(CMOR.getProperty("url"));
		dr.manage().window().maximize();
		
		
		//dr.get("https://cm.reports.mn/template/framework/preview.php?frm_id=800060160&pagename=keywords-only-800x175.html&isiframe");
		Thread.sleep(5000);
		

	}

}
