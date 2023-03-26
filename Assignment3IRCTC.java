package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment3IRCTC {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
		ChromeDriver Driver =new ChromeDriver(options);
		Driver.get("https://www.irctc.co.in/nget/train-search");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Driver.findElement(By.xpath("//i[@class='fa fa-align-justify']")).click();
		
		Driver.findElement(By.xpath("//label[text()='FLIGHTS']/parent::a")).click();
		
		System.out.println("Main webpage title : " + Driver.getTitle());
		
		Set<String> sites = Driver.getWindowHandles();
		
		List<String> websites = new ArrayList<String>(sites);
		
		Driver.switchTo().window(websites.get(1));
		
		System.out.println("Secondary Webpage title : " + Driver.getTitle());
		
		
	
	}

}

