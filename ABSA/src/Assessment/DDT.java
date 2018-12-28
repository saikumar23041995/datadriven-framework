package Assessment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Test.utility.TestUtil;

public class DDT {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
          driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		
		
	}
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData=TestUtil.getDataFromExcel();
		return testData.iterator();
		
	}
	
	@Test(dataProvider="getTestData")
	public void assessment(String FirstName,String LastName,String UserName,String Password,String Email,String Cell) {
		
		  driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button")).click();
		  
		  driver.findElement(By.name("FirstName")).sendKeys(FirstName);
		  
		  driver.findElement(By.name("LastName")).sendKeys(LastName);
		  
		  driver.findElement(By.name("UserName")).sendKeys(UserName);
		  
		  driver.findElement(By.name("Password")).sendKeys(Password);
		  
          driver.findElement(By.xpath("//input[@value='15']")).click();
		  
		  driver.findElement(By.xpath("//option[text()='Customer']")).click();
		  
		  driver.findElement(By.name("Email")).sendKeys(Email);
		  
		  driver.findElement(By.name("Mobilephone")).sendKeys(Cell);
		  
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  
		 /*  WebElement teeest = driver.findElement(By.xpath("//input[@class='pull-right ng-pristine ng-valid']"));
		  
		   teeest.sendKeys("Fname1");
		   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		   teeest.sendKeys(Keys.ENTER);
		   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		   teeest.sendKeys(Keys.CONTROL + "a");
		   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		   teeest.sendKeys(Keys.DELETE);*/
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}


