package Media.net.CM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessBrowser {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
		driver = new HtmlUnitDriver();
	    driver.get("http://www.health.online/");
	    Thread.sleep(5000);
	    driver.manage().window().maximize();
	   
	    
	    
	    System.out.println(driver.findElement(By.xpath("//*[@id='bads_body']/section/div/div[1]/div/div[2]")).getCssValue("color"));

	}

}
