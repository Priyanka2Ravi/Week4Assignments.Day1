package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment1MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("–disable-notifications");
        options.addArguments("--remote-allow-origins=*");
		ChromeDriver Driver =new ChromeDriver(options);
		Driver.get("http://leaftaps.com/opentaps/control/login");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		Driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(3000);
		Driver.findElement(By.className("decorativeSubmit")).click();
		Driver.findElement(By.partialLinkText("CRM/SFA")).click();
		Thread.sleep(2000);	
		
		Driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		String parent = Driver.getWindowHandle();
		Set<String> handles = Driver.getWindowHandles();
		List<String> multipleWin = new ArrayList<String>(handles);
		
		Driver.switchTo().window(multipleWin.get(1));
		//System.out.println(Driver.getTitle());
		
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//a[@class='linktext']")).click();
		
		Driver.switchTo().window(parent);
		
		Driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> handles2 = Driver.getWindowHandles();
		List<String> multipleWin2 = new ArrayList<String>(handles2);
		
		Driver.switchTo().window(multipleWin2.get(1));
		//System.out.println(Driver.getTitle());
		
		Thread.sleep(2000);
		Driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		
		Driver.switchTo().window(parent);
		Driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		Driver.switchTo().alert().accept();
		
		String s = Driver.getTitle();
		
		if(s.contains("View Contact"))
		{
			System.out.println("Yes, Tiltle of the page is valid");
		}
		else
		{
			System.out.println("No, Tiltle of the page is not valid");
		}
	}

}
