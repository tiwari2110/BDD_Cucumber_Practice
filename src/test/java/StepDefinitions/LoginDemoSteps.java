package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDemoSteps {

    WebDriver driver = null;
    
	@Given("Chrom Browser is open")
	public void chrom_browser_is_open() {
		System.out.println("Inside Step : open browser");
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@And("user is on Test project login page")
	public void user_is_on_test_project_login_page() throws InterruptedException {
		driver.navigate().to("https://example.testproject.io/web/");
		Thread.sleep(2000);
	}

	@When("^User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@When("user clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("login")).click();
	}

	@Then("User is navigated to home page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
		driver.findElement(By.id("logout")).isDisplayed();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
