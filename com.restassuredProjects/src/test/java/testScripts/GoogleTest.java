package testScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
		
		static
		{
			System.setProperty("webdriver.chrome.driver", "./driverExecutables/chromedriver.exe");
		}

		public static void main(String[] args) throws Throwable {
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			driver.findElement(By.name("q")).sendKeys("selenium");
			List<WebElement> allsugg = driver.findElements(By.xpath("//span[contains(text(),'selenium')]"));
			int count=allsugg.size();
			for(int i=0; i<count;i++) {
				String text=allsugg.get(i).getText();
				System.out.println(text);
			}
			allsugg.get(4).click();
	}

}
