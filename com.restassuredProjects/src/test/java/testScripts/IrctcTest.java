package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IrctcTest {

		static
		{
			System.setProperty("webdriver.chrome.driver","./driverExecutables/chromedriver.exe");
		}
		public static void main(String[] args) {
			
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");
			
			WebDriver driver=new ChromeDriver(opt);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.irctc.co.in/nget/train-search");
			//driver.switchTo().alert().dismiss();
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			
			

	}

}
