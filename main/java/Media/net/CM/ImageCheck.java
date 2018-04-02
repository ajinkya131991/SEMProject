package Media.net.CM;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageCheck {

	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
	      	driver.get("http://172.16.136.161/a/300x250_kw/300x250_kw.html");

	      	//WebElement frame = driver.findElement(By.cssSelector("#_mN_main_353259147_0_n"));
	      	
	      	Thread.sleep(5000);
			driver.switchTo().frame("_mN_main_353259147_0_n");
			Thread.sleep(5000);
			
			WebElement image = driver.findElement(By.id("kbb_img_1"));
			
			String width = image.getCssValue("width");
			String newwidth= width.replaceAll("[^0-9]", "");		
			//System.out.println("Image Height is : " + newwidth);
			double newwidth1 = Double.parseDouble(newwidth);
			System.out.println("Image Height is : " + newwidth1);
			
			String height = image.getCssValue("height");
			String newheight= height.replaceAll("[^0-9]", "");		    			
			double newheight1 = Double.parseDouble(newheight);
			System.out.println("Image width is : " + newheight1);
			
			String naturalWidth = image.getAttribute("naturalWidth");
			System.out.println("Image naturalWidth is : " + naturalWidth);
			//double newnaturalWidth = Double.parseDouble(naturalWidth);
			
			
			String naturalHeight = image.getAttribute("naturalHeight");
			System.out.println("Image naturalHeight is : " + naturalHeight);
			//double newnaturalHeight = Double.parseDouble(naturalHeight);
			
			
			double d= newwidth1/newheight1;
			
			double[] ratio = {0.92 , 1 , 1.08 , 1.26 , 1.27 , 1.3 , 1.33, 1.34 , 1.39, 1.42 , 1.5 , 1.63 , 1.67, 1.76, 1.84, 2 , 2.07,2.72,2.88,3.03,3.26};
			
			/*if(d==1)
			{
				int natwidth = 140;
				int natheight = 140;
				Assert.assertEquals(newnaturalWidth, natwidth );
				Assert.assertEquals(newnaturalHeight, natheight );
			}*/
		} 
	}


