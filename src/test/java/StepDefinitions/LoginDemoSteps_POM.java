package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginDemoSteps_POM {

    WebDriver driver = null;
    LoginPage login = null;
    
	@Given("Chrome Browser is open")
	public void chrom_browser_is_open() {
		System.out.println("Inside Step : open browser");
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@And("user is landed on Test project login page")
	public void user_is_on_test_project_login_page() throws InterruptedException {
		driver.navigate().to("https://example.testproject.io/web/");
		login = new LoginPage(driver);
		Thread.sleep(2000);
	}

	@When("^into login form User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		login.enterUsername(username);
		login.enterPassword(password);
	}
	
	@When("user clicks on login button in form")
	public void user_clicks_on_login_button() throws InterruptedException {
		Thread.sleep(2000);
		login.clickLogin();
	}

	@Then("User is navigated to home page and able to see logout")
	public void user_is_navigated_to_home_page() throws InterruptedException {
		login.verifyLogout();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
