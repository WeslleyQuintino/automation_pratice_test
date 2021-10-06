package pages;

import beans.ValuesHelper;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestDataReader;

import static Core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class CadastroPage extends BasePage{
	
	static TestDataReader dataTable = new TestDataReader();
	public CadastroPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Faker faker = new Faker();
	ValuesHelper helper = new ValuesHelper();
	// TEXTO

	@FindBy(className = "page-subheading")
	private WebElement titAccount;

	@FindBy(className = "info-account")
	private WebElement titInfoAccount;

	// BUTTON
	@FindBy(id = "SubmitCreate")
	private WebElement createAccount;

	@FindBy(id = "submitAccount")
	private WebElement btnRegister;
	
	@FindBy(xpath = "//a[@title='Log me out']")
	private WebElement btnLogOut;

	// RADIO BUTTON
	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement inputMaleGender;

	@FindBy(xpath = "//input[@id='id_gender2']")
	private WebElement inputFemaleGender;

	// SELECT
	@FindBy(id = "days")
	private WebElement selectDays;

	@FindBy(id = "months")
	private WebElement selectMonths;

	@FindBy(id = "years")
	private WebElement selectYears;

	@FindBy(id = "id_state")
	private WebElement selectState;

	@FindBy(id = "id_country")
	private WebElement selectCountry;

	// INPUT TEXT

	@FindBy(id = "email_create")
	private WebElement emailaddress;

	@FindBy(xpath = "//h3[text()='Your personal information']")
	private WebElement titinfoPersonal;

	@FindBy(name = "customer_firstname")
	private WebElement inputFirstName;

	@FindBy(name = "customer_lastname")
	private WebElement inputLastName;

	@FindBy(id = "email")
	private WebElement inputEmail;

	@FindBy(id = "passwd")
	private WebElement inputPassword;

	@FindBy(name = "firstname")
	private WebElement inputAddressFirstName;

	@FindBy(name = "lastname")
	private WebElement inputAdressLastName;

	@FindBy(id = "company")
	private WebElement inputCompany;

	@FindBy(id = "address1")
	private WebElement inputAddress;

	@FindBy(id = "city")
	private WebElement inputCity;

	@FindBy(id = "postcode")
	private WebElement inputZipCode;

	@FindBy(id = "other")
	private WebElement inputAdditionalInfo;

	@FindBy(id = "phone")
	private WebElement inputHomePhone;

	@FindBy(id = "phone_mobile")
	private WebElement inputMobilePhone;

	@FindBy(id = "alias")
	private WebElement inputAlias;

	// --- Methods ---- //

	public void validateRegistePage() {
		assertEquals("CREATE AN ACCOUNT", titAccount.getText());
		takeScreenshot("Tela de Cadastro");
	}

	@SuppressWarnings("static-access")
	public void insertEmail() {
		helper.setFirstName(faker.name().firstName());
		helper.setLastName(faker.name().lastName());
		helper.setEmail(helper.setEmail(helper.getFirstName().toLowerCase()+helper.getLastName().toLowerCase()+"@gmail.com"));
		emailaddress.sendKeys(helper.getEmail());
	}

	public void clickBtnCreateAccount() {
		createAccount.click();
	}

	public void validateInfoPersonal() {
		assertEquals("YOUR PERSONAL INFORMATION", titinfoPersonal.getText());
		takeScreenshot("Tela Informa��o pessoal ");
	}

	@SuppressWarnings("static-access")
	public void registerAccount(String dia, String mes,
			String ano, String estado,
			String cep) {
		takeScreenshot("Inicio Cadastro do usu�rio");
		helper.setPassword(helper.getFirstName()+"010203");
		inputMaleGender.click();
		inputFirstName.sendKeys(helper.getFirstName());
		inputLastName.sendKeys(helper.getLastName());
		inputEmail.clear();
		inputEmail.sendKeys(helper.getEmail());
		inputPassword.sendKeys(helper.getPassword());

		selectWithValue(selectDays, dia);
		selectWithValue(selectMonths, mes);
		selectWithValue(selectYears, ano);
	
		inputAddressFirstName.clear();
		inputAddressFirstName.sendKeys(helper.getFirstName());
		inputAdressLastName.clear();
		inputAdressLastName.sendKeys(helper.getLastName());
		takeScreenshot("Meio do cadastro do usu�rio");
		inputAddress.sendKeys(dataTable.getDt("in_Address"));
		inputCity.sendKeys(dataTable.getDt("in_City"));

		selectWithText(selectState, estado);

		inputZipCode.sendKeys(cep);
		inputHomePhone.sendKeys(dataTable.getDt("in_Home_Phone"));
		inputMobilePhone.sendKeys(dataTable.getDt("in_Mobile_Phone"));
		inputAlias.clear();
		inputAlias.sendKeys(dataTable.getDt("in_My_Address"));
		takeScreenshot("Fim do cadastro do usu�rio");
		btnRegister.click();
	}

	public void validarContaCriada() {
		Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",
				titInfoAccount.getText());
		takeScreenshot("Conta criada com sucesso");
	}
	public void logOutAccount() {
		btnLogOut.click();
	}

}
