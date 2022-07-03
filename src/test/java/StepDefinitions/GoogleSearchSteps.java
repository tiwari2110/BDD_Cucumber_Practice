package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver driver = null;


	@Given("Browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step : open browser");
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() throws InterruptedException {
		System.out.println("Inside Step : user on google search page");
		driver.navigate().to("https://google.com");
		Thread.sleep(2000);
	}

	@When("user enter tet in search box")
	public void user_enter_tet_in_search_box() throws InterruptedException {
		System.out.println("Inside Step : user enter text in search");
		driver.findElement(By.name("q")).sendKeys("facebook");
		Thread.sleep(2000);
	}

	@And("Hit Enter")
	public void hit_enter() throws InterruptedException {
		System.out.println("Inside Step : User hit enter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("user is navigated to search result")
	public void user_is_navigated_to_search_result() throws InterruptedException {
		System.out.println("Inside Step : Search result");
		driver.getPageSource().contains("Sign Up For Facebook®");
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
