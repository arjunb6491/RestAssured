package testScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.config.SSLConfig;

public class SkillraryTest {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driverExecutables/chromedriver.exe");
	}

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.skillrary.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		WebElement gears = driver.findElement(By.xpath("//span[text()='GEARS']"));
		//WebElement demoapp = driver.findElement(By.xpath("//span[text()='GEARS']/ancestor::a/following-sibling::ul/descendant::a[text()=' SkillRary Demo APP']"));
		Actions a=new Actions(driver);
		a.moveToElement(gears).perform();
		driver.findElement(By.xpath("//span[text()='GEARS']/ancestor::a/following-sibling::ul/descendant::a[text()=' SkillRary Demo APP']")).click();
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> itr=window.iterator();
				String ParentID=itr.next();
				String ChildID=itr.next();
				driver.switchTo().window(ChildID);
				
				WebElement drop = driver.findElement(By.xpath("//select[@class='chosen-select']"));
				Select s=new Select(drop);
				s.selectByValue("category.php?category=testing");
				driver.findElement(By.xpath("//b[.='INR 500.00']/ancestor::div[@class='col-sm-4']/descendant::a[text()='Selenium Training']")).click();
				driver.findElement(By.id("quantity")).sendKeys(Keys.CONTROL+"ax");
				driver.findElement(By.id("quantity")).sendKeys("5");
				driver.findElement(By.xpath("//button[@ondblclick='addtocart()']")).click();
			
				//Thread.sleep(3000);
				driver.switchTo().alert().accept();
				driver.quit();
				
				
		
	}

}
