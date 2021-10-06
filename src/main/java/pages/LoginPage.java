package pages;

import beans.ValuesHelper;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestDataReader;

import java.io.IOException;
import java.util.List;

import static Core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage{
	
	static TestDataReader dataTable = new TestDataReader();
	 ValuesHelper helper = new ValuesHelper();
	 
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//h1[text()='Authentication']")
	private WebElement titleAuthentication;
	
	 @FindBy(id = "SubmitLogin")
	    private WebElement btnSignIn;

	    @FindBy(id = "email")
	    private WebElement inputEmail;

	    @FindBy(name = "passwd")
	    private WebElement inputPassword;

	    @FindBy(id = "SubmitLogin")
	    private WebElement btnLogIn;

	    @FindBy(className = "page-heading")
	    private WebElement titleMyAccount;

	    @FindBy(className = "info-account")
	    private WebElement textLoginWelcome;

	
	public void validarSignInPage() {
		assertTrue(titleAuthentication.isDisplayed());
	}
	
	public void accessUrl() {
		getDriver().get("http://automationpractice.com/index.php");
	}
	
	public void accessLoginPage() {
		btnSignIn.click();
	}
	public void loginWithValidData(String email, String senha) throws IOException{
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(senha);
		takeScreenshot("Usuario realizando login");
		btnSignIn.click();
	}
	 public void login(DataTable table){
	        List<List<String>> data = table.asLists();

	        inputEmail.sendKeys(dataTable.getDt("in_Nome"));
	        inputPassword.sendKeys(dataTable.getDt("in_Senha"));
	        takeScreenshot("Login de usu�rio");
	        btnLogIn.click();
	    }

	    public void validateSucessfullyLogin() {
	        Assert.assertEquals("MY ACCOUNT", titleMyAccount.getText());
	        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", textLoginWelcome.getText());
	        takeScreenshot("Login realizado com sucesso");
	    }
	    
	    public void loginWithAccountCreated() {
	    	inputEmail.sendKeys(helper.getEmail());
	        inputPassword.sendKeys(helper.getPassword());
	        btnLogIn.click();
	        takeScreenshot("Login realizado com sucesso");
	    }
}
