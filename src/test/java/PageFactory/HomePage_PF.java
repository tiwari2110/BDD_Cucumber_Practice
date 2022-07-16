package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PF {

	@FindBy(id = "logout")
	WebElement btn_logout;
	
	@FindBy(id ="save")
	WebElement btn_save;
	
	WebDriver driver;
	
	public HomePage_PF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public void verifyLogout() {
		btn_logout.isDisplayed();
	}
	
	public void verifySave() {
		btn_save.isDisplayed();
	}
	
}
