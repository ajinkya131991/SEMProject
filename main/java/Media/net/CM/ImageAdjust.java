package Media.net.CM;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class ImageAdjust 
{
	//public static void main (String [] args) throws Exception
	@Test
	public void Imagecheck()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//WebElement Image = driver.findElement(By.xpath("/html/body/div/div[1]/img"));
		//System.out.println(Image.getAttribute("src"));
		
		//WebElement container = driverfirefox.findElement(By.xpath("/html/body/div"));
		
		
	   	
		
				for (int i = 1; i <= 1000; i+=10) 
				  {   //i value increases
					
					String I = Integer.toString(i);
					   for (int j = 1; j <=1000; j+=10) 
					   {
					   //then j value increases 
						   String J = Integer.toString(j);
						  
						   driver.navigate().to("http://172.16.136.86/a/1/native-img%20(2).html?"+I+"?"+J+""); 
						   System.out.print(driver.getCurrentUrl());   
						   System.out.print("  --------- >>> Checked For Image Resolution : "+I+" X "+J+"");
						   System.out.println();
						   String size= ""+i+"X"+j+"";
						    
								File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
								try {
									String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\ScreenShot\\";
									File destFile = new File((String) reportDirectory +size+".png");
									File destFile1 = new File("C:\\xampp\\htdocs\\a\\NativeImageCheck\\Screenshots\\" +size+".png");
									
									
									FileUtils.copyFile(src, destFile);
									FileUtils.copyFile(src, destFile1);
									
									} catch (IOException e)
										{
										e.printStackTrace();
										}     	
					   }
				  }
	}
}