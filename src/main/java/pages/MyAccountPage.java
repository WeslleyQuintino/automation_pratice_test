package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static Core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//h1[text()='My account']")
	private WebElement titleMyAccount;
	
	@FindBy(className="info-account")
	private WebElement lblWelcomeAccount;
	
	public void validateMyAccount(){
		assertTrue(titleMyAccount.isDisplayed());
	}
	
	public void validateWelcomeMessage() throws IOException{
		assertEquals(lblWelcomeAccount.getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
		takeScreenshot("Usu�rio logado");
	}
}
