package pages;

import beans.ValuesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static Core.DriverFactory.getDriver;
import static Core.DriverFactory.refreshPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage {

	ValuesHelper helper = new ValuesHelper();
	ComprasPage shoppingPage = new ComprasPage();
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(className = "login")
	private WebElement btnSignIn;
	
	@FindBy(xpath="//div[@id='layer_cart']//h2[contains(., 'Product successfully added to your shopping cart')]")
	private WebElement lblAddedProduct;
	
	@FindBy(xpath = "//span[ends-with(text(), 'Proceed to checkout')]")
	private WebElement btnProceedCheckout;
	
	@FindBy(xpath = "//a[@title='My Store']")
	private WebElement btnBackToHome;
	
	public void validateAccess() {
		assertEquals("My Store", getDriver().getTitle());
	}

	public void loginAccess() {
		btnSignIn.click();
	}
	
	@SuppressWarnings("static-access")
	public void buyShopping() throws Exception{

		Actions actions = new Actions(getDriver());		
		
			ArrayList<String> products = new ArrayList<String>();	
			
			//products.add("Blouse");
			//products.add("Printed Chiffon Dress");
			products.add("Faded Short Sleeve T-shirts");
			//products.add("Printed Dress");
			
			for(int i = 0; i< products.size(); i++) {
				refreshPage();
				Thread.sleep(1000);
				scrollDown();
				scrollDown();
				scrollDown();
				helper.setNameProduct(products.get(i).toString());
				
				takeScreenshot("Produto a ser adicionado ao carrinho: "+products.get(i)+"");
				if(products.get(i).equals("Blouse")) {
					WebElement productBlouseTShirt = getDriver().findElement(By.xpath("//li[contains(@class, 'last-item-of-mobile-line')]//a[contains(text(), 'Blouse')]"));
					productBlouseTShirt.click();
					takeScreenshot("Produto"+" "+products.get(i)+" "+"selecionado");
				}
				else if(products.get(i).equals("Printed Chiffon Dress")) {
					WebElement productPrintedChiffon = getDriver().findElement(By.xpath("//li[contains(@class, 'last-mobile-line')]//a[contains(text(), 'Chiffon')]"));
					productPrintedChiffon.click();
					takeScreenshot("Produto"+" "+products.get(i)+" "+"selecionado");
				}
				
				else if(products.get(i).equals("Printed Dress")) {
					WebElement productPrintedDress = getDriver().findElement(By.xpath("(//a[contains(text(), 'Printed Dress')])[1]"));
					productPrintedDress.click();
					takeScreenshot("Produto"+" "+products.get(i)+" "+"selecionado");
				}
				else if(products.get(i).equals("Faded Short Sleeve T-shirts")) {
					WebElement productFadedShort = getDriver().findElement(By.xpath("(//a[contains(text(), 'Faded Short')])[1]"));	
					productFadedShort.click();
					takeScreenshot("Produto"+" "+products.get(i)+" "+"selecionado");
				}
				
				shoppingPage.enterPurchaseInformation();
				shoppingPage.validateProductAddedToCart();
				btnBackToHome.click();
			}
			
	
	}
	
	public void validateItemAddedToCart(){
		assertTrue(lblAddedProduct.isDisplayed());
	}
	
	public void clickToProceedCheckout(){
		btnProceedCheckout.click();
	}
}
