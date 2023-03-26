package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment1Windowhandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
		ChromeDriver Driver =new ChromeDriver(options);
		Driver.get("https://www.leafground.com/window.xhtml");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowhandles = Driver.getWindowHandles();
				
		List<String> convert = new ArrayList<String>(windowhandles);
		String parent = convert.get(0);
		
		if(convert.size() >0)
		{
			System.out.println("Yes, new window is opened");
			for(String s: windowhandles)
			{
				System.out.println(s);
			}
			
		}
		else
		{
			System.out.println("No, new window is opened");
		}
		
//		System.out.println(Driver.getTitle());
//		
//		Driver.switchTo().window(convert.get(1));
		Thread.sleep(2000);
//		System.out.println(Driver.getTitle());
//		Driver.close();
//		
				
		Driver.switchTo().window(parent);
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		Set<String> newwindow = Driver.getWindowHandles();
		
		System.out.println("Number of windows opened are : " + newwindow.size());
			
		Driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		
		Set<String> currenttabs = Driver.getWindowHandles();
		
		List<String> openedtabs = new ArrayList<String>(currenttabs);
		
		String primary = openedtabs.get(0);
		
		for(String s:openedtabs)
		{
			if(!s.contains(primary))
			{
				Driver.switchTo().window(s);
				Driver.close();
			}
		}
		
		Driver.switchTo().window(primary);
		Driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		
		
		Thread.sleep(5000);
		Driver.quit();
		
		
		
	}

}
