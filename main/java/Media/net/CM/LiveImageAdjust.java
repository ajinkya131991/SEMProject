package Media.net.CM;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LiveImageAdjust 
{
	@Test
	public void Imagecheck()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
				for (int i = 1; i <= 1000; i+=10) 
				  {   //i value increases
					
					String I = Integer.toString(i);
					   for (int j = 1; j <=1000; j+=10) 
					   {
					   //then j value increases 
						   String J = Integer.toString(j);
						   
						   driver.navigate().to("http://c8stage.keywordblocks.com/test_template.html?template_key=TME27JV&size=300x250&v=30&image_width="+I+"&image_height="+J+""); 
						   
						   try{
							   Thread.sleep(5000);
							  }
						   catch (InterruptedException ix)
						   	  {
							    ix.printStackTrace();
							  } 
						   
						   System.out.print(driver.getCurrentUrl());   
						   System.out.print("  --------- >>> Checked For Image Resolution : "+I+" X "+J+"");
						   System.out.println();
						   String size= ""+i+" X "+j+"";
						    
								File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
								try {
									String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\ScreenShot\\";
									File destFile = new File((String) reportDirectory +size+".png");
									File destFile1 = new File("Y:\\Personal Spaces\\Ajinkya.Bh\\LiveImageCheck\\Screenshots\\" +size+".png");									
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
