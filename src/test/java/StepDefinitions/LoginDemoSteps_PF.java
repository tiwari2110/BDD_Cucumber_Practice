package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.HomePage_PF;
import PageFactory.LoginPage_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDemoSteps_PF {

    WebDriver driver = null;
    LoginPage_PF login = null;
    HomePage_PF home=null;
    
	@Given("Page factory Chrome Browser is open")
	public void chrom_browser_is_open() {
		System.out.println("Inside Step : open browser");
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@And("Page factory user is landed on Test project login page")
	public void user_is_on_test_project_login_page() throws InterruptedException {
		driver.navigate().to("https://example.testproject.io/web/");
		
		Thread.sleep(2000);
	}

	@When("^Page factory into login form User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		login = new LoginPage_PF(driver);
		login.enterUsername(username);
		login.enterPassword(password);
	}
	
	@When("Page factory user clicks on login button in form")
	public void user_clicks_on_login_button() throws InterruptedException {
		Thread.sleep(2000);
		login.clickLogin();
	}

	@Then("Page factory User is navigated to home page and able to see logout")
	public void user_is_navigated_to_home_page() throws InterruptedException {
		home = new HomePage_PF(driver);
		home.verifyLogout();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
