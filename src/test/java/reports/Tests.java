package reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Listeners({AllureListener.class})
public class Tests extends BaseClass {
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	
		BaseClass bs = new BaseClass();
		driver = bs.initialize_driver();
		driver.get("https://demo.nopcommerce.com/");
		
		
	}
	
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1,description = "Verify Logo presense on Home Page")
	@Description("Verify Logo presense on Home Page.......")
	@Epic("EP001")
	@Feature("Feature1 : Logo")
	@Story("Story : Logo Presence")
	@Step("Verify logo Presence")
	
	public void logoPresence() throws InterruptedException{
		boolean disStatus = driver.findElement(By.xpath("//img[contains(@alt,'nopCommerce demo store')]")).isDisplayed();
		Assert.assertEquals(disStatus, true);
	}
	
	
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=2, description="Verify login")
	@Description("Verify login with Valid Credentials........")
	@Epic("EP001")
	@Feature("Feature2 : Login")
	@Story("Story: Valid Login")
	@Step("Verify login")
	
	public void loginTest() throws InterruptedException  {
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("mdimranzama3110@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Huss@1n");
		driver.findElement(By.xpath("//button[contains(@class,'button-1 login-button')]")).click();
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store Login");
		
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3, description="Verify user Registration")
	@Description("Verify user Registration........")
	@Epic("EP001")
	@Feature("Feature3 : Registration")
	@Story("Story :user registration")
	
	
	public void registrationTest() {
		
		throw new SkipException("Skipping this Test");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
