package pages;

import beans.ValuesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static Core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderPage extends BasePage{	
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	static ValuesHelper helper = new ValuesHelper();
	
	@FindBy(id = "total_price_container")
	private WebElement lblTotalProducts;
	
	@FindBy(id = "total_price")
	private WebElement lblTotalValue;
	
	@FindBy(id = "total_shipping")
	private WebElement lblShippingValue;
	
	@FindBy(xpath = "(//span[contains(text(), 'Proceed to checkout')])[2]")
	private WebElement btnProceedToCheckout;
	
	@FindBy(xpath = "//h3[text() = 'Your delivery address']")
	private WebElement titleDeliveryAddress;
	
	@FindBy(xpath = "//ul[@id='address_delivery']//li")
	private List<WebElement> listDeliveryAddress;

	@FindBy(id = "id_address_delivery")
	private WebElement selectAddress;
	
	@FindBy(xpath = "(//p[@class='carrier_title'])[1]")
	private WebElement titleTransport;
	
	@FindBy(id = "cgv")
	private WebElement checkboxTermsOfDelivery;
	
	@FindBy(xpath = "//div[@class = 'delivery_option_price']")
	private WebElement deliveryOptionPrice;
	
	@FindBy(xpath = "//a[@title='View my shopping cart']")
	private WebElement accessShoppingCart;
	
	@FindBy(xpath= "(//span[contains(text(),'Proceed to checkout')])[2]")
	private WebElement btnProceedCheckout;
	
	@FindBy(xpath="//a[@class='bankwire']")
	private WebElement selectBankWirePayment;
	
	@FindBy(xpath="//a[@class='cheque']")
	private WebElement selectCheckPayment;
	
	@FindBy(xpath="//h3[text()='Check payment']")
	private WebElement titleCheckPaymentConfirm;
	
	@FindBy(xpath="//h3[contains(text(),'Bank-wire payment')]")
	private WebElement titleBankWirePaymentConfirm;
	
	@FindBy(xpath="//p[@class='cheque-indent']/strong")
	private WebElement subTitlePaymentElement;
	
	@FindBy(xpath= "//div[@class='box cheque-box']/p/span")
	private WebElement totalValueConfirmation;
	
	@FindBy(xpath="//button[@type='submit']/span[contains(text(),'I confirm my order')]")
	private WebElement confirmPayment;
	
	@FindBy(xpath="//h1[contains(text(),'Order confirmation')]")
	private WebElement titleOrderConfirmation;
	
	@FindBy(xpath="//p/strong[contains(text(),'Your order')]")
	private WebElement subTitleOrderConfirmation;
	
	@FindBy(xpath="//span[@class='price']")
	private WebElement orderConfirmationPrice;
	
	public boolean deliveryAddressValidator() {
		List<String> addressDeliveryExpected = new ArrayList<String>();
		int cont = 0;
		
		addressDeliveryExpected.add("YOUR DELIVERY ADDRESS");
		addressDeliveryExpected.add("AutomaToma Ti");
		addressDeliveryExpected.add("rua 1234t5 SUITE 421682");
		addressDeliveryExpected.add("South Salt Lake, Utah 84119");
		addressDeliveryExpected.add("United States");
		addressDeliveryExpected.add("+1 (572) 183-3681");
		addressDeliveryExpected.add("+55 11 999999999");
				
		for(int i = 0; i < listDeliveryAddress.size()-1; i++) {
			if(listDeliveryAddress.get(i).getText().equals(addressDeliveryExpected.get(i))) {
				cont++;
			}
		}
		boolean validator = (cont == 7) ? true : false;
		return validator;
	}
	
	public void clickProceedToCheckout() {
		accessShoppingCart.click();
		takeScreenshot("Pop-up Carrinho apresentado");
		scrollDown();
		takeScreenshot("Tela de Carrinho apresentado");
		btnProceedToCheckout.click();
	}
	
	public void validateAddressDelivery() throws InterruptedException {
		assertTrue(deliveryAddressValidator());
		scrollDown();
		takeScreenshot("Tela de endere�o apresentado");
		btnProceedToCheckout.click();
	}
	
	
	public void validateAddress() throws InterruptedException {
		validateAddressDelivery();

	}
	public void selectAddress() {
		selectFirst(selectAddress);
		WebElement addressSelected = selectAddress.findElement(By.xpath("//option[@selected='selected']"));
		helper.setAddressNameDelivery(addressSelected.getText());
		scrollDown();
		btnProceedCheckout.click();
	}
	
	public void validateDelivery() {
		 assertTrue("casinha hmmm", titleTransport.getText().contains("casinha"));
		helper.setValueShipping(deliveryOptionPrice.getText().trim().replace("$", ""));
		acceptTermsOfShipping();
		takeScreenshot("Tela de Frete apresentado");
		btnProceedToCheckout.click();
	}
	
	public void acceptTermsOfShipping() {
		checkboxTermsOfDelivery.click();
		takeScreenshot("Termos de frete aceito");
	}
	
	public void btnProceedToCheckout() {
		scrollDown();
		btnProceedToCheckout.click();
	}
	public void validatePayment(String payment) {
		takeScreenshot("Tela de Pagamento apresentado");
		assertEquals(helper.getTotalValue().replace(",", "."), lblTotalProducts.getText().trim().replace("$", ""));
		assertEquals(helper.getShippingValue(), lblShippingValue.getText().trim().replace("$", ""));
		scrollDown();
		scrollDown();
		
		takeScreenshot("M�todos de pagamento");
		if(payment.equals("bank wire")) {
			selectBankWirePayment.click();
			takeScreenshot("Pagamento por Transfer�ncia banc�ria selecionado");
			assertEquals("BANK-WIRE PAYMENT.", titleBankWirePaymentConfirm.getText());
			assertEquals("You have chosen to pay by bank wire. Here is a short summary of your order:",subTitlePaymentElement.getText());
			assertEquals(helper.getTotalValue().replace(",", "."), totalValueConfirmation.getText().replace("$", ""));
			
			confirmPayment.click();
			takeScreenshot("Tela de pagamento com sucesso");
			assertEquals("ORDER CONFIRMATION", titleOrderConfirmation.getText());
			assertEquals("Your order on My Store is complete.", subTitleOrderConfirmation.getText());
			assertEquals(helper.getTotalValue().replace(",", "."),orderConfirmationPrice.getText().replace("$", ""));
		}
		
	}
}

