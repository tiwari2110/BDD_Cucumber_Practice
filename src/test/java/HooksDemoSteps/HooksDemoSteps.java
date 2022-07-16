package HooksDemoSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HooksDemoSteps {
	
	WebDriver driver;
	
	@Before(order=0)
	public void browserSetup() {
		System.out.println("Inside Before: Browser setup");
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	@Before(order = 1)
	public void setup() {
		System.out.println("I am inside setup two");
	}
	
	@BeforeStep
	public void beforeStep() {
		System.out.println("Inside: before every step");
	}
	
	@AfterStep
	public void afterSteps() {
		System.out.println("Inside: After step");
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside: Login page");
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		System.out.println("Inside: user enter username and password");
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("Inside: click login button");
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("Inside: user on home page");
	}
	
	@After
	public void shutDown() {
		System.out.println("Shutdhown Test");
		driver.close();
		driver.quit();
		
	}

}
