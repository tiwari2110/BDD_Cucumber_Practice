package BackgroundDemoSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.HomePage_PF;
import PageFactory.LoginPage_PF;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BackgroundDemoStepDefinition {
	
	LoginPage_PF login;
	HomePage_PF home;
	WebDriver driver;
	
	@Before
	public void setup() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		if(driver != null) {
			login = new LoginPage_PF(driver);
			home = new HomePage_PF(driver);
		}
		driver.navigate().to("https://example.testproject.io/web/");

		
	}

	@Then("User is able to see logout button")
	public void user_is_able_to_see_logout_button() {
		System.out.println("Inside step user is able to see logout");
		home.verifyLogout();
	}
	
	@Then("User is able to see save button")
	public void user_is_able_to_see_save_button() throws InterruptedException {
		System.out.println("Inside step user is able to see save");
		home.verifySave();
		Thread.sleep(2000);
	}
	

	@Given("^User (.*) is logged in$")
	public void user_username_is_logged_in(String username) throws InterruptedException {
		login.enterUsername(username);
		Thread.sleep(2000);
		login.enterPassword("12345");
		Thread.sleep(2000);
		login.clickLogin();
		Thread.sleep(2000);
		
		home.verifyLogout();
	}
	
	@After
	public void shutdown() {
		
		driver.close();
		driver.quit();
	}







}
