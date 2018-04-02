package Media.net.CM;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleError {

	public static WebDriver dr;
	public static void main(String[] args) throws InterruptedException 
	{
		ConsoleError error = new ConsoleError();
		error.chromeerror();
	}	
	
		public void chromeerror() throws InterruptedException
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");	
	    dr = new ChromeDriver();
			    
		dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		dr.get("https://economictimes.indiatimes.com/definition/software-testing");
		Thread.sleep(5000);
		dr.manage().window().maximize();

		LogEntries logEntries = dr.manage().logs().get(LogType.BROWSER);
			for (LogEntry entry : logEntries) 
			{
				String newentry = entry.toString();
					
				if(!(newentry==null))
				{	
					if(newentry.contains("SEVERE"))
					{
						System.out.println(entry); 
					}
					else {}
				}
				else {System.out.println("2No Errors in Chrome");}
			}
		}
		
		public void firefoxerror()
		{
			
		}
		
	}


