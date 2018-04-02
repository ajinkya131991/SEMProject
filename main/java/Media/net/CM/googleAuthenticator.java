package Media.net.CM;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleAuthenticator {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("ajinkyabhobad@gmail.com");
		driver.findElement(By.cssSelector("#identifierNext > content > span")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys("@jinkyA99");
		//driver.findElement(By.className("Xb9hP")).clear(); //.sendKeys("@jinkyA99");
		driver.findElement(By.cssSelector("#passwordNext > content")).click();
		
		
	
	}
}
