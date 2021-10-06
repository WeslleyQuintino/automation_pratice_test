package pages;

import beans.ValuesHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.DriverFactory.getDriver;

public class ComprasPage extends BasePage {
	public ComprasPage() {
		PageFactory.initElements(getDriver(), this);
	}

	static ValuesHelper helper = new ValuesHelper();

	@FindBy(xpath = "//h1[@itemprop='name']")
	private WebElement productTile;

	@FindBy(id = "our_price_display")
	private WebElement unitaryValue;
	
	@FindBy(id = "quantity_wanted")
	private WebElement inputQuantity;
	
	@FindBy(xpath = "//span[@class='ajax_block_cart_total'][contains(text(),'$')]")
	private WebElement totalValue;

	@FindBy(id = "group_1")
	private WebElement selectSize;

	@FindBy(name = "Submit")
	private WebElement btnAddToCart;

	@FindBy(xpath = "(//h2)[1]")
	private WebElement successCartMessage;

	@FindBy(id = "layer_cart_product_title")
	private WebElement productName;

	@FindBy(id = "layer_cart_product_price")
	private WebElement unitaryPriceCart;

	@FindBy(xpath = "//span[@class='ajax_cart_shipping_cost']")
	private WebElement shippingValueCart;

	@FindBy(xpath = "//span[@class='ajax_block_cart_total']")
	private WebElement totalValueCart;

	@FindBy(xpath = "//span[@title='Continue shopping']")
	private WebElement btnProceedToContinueShopping;

	// --- MET�DOS --- //

	@SuppressWarnings({ "static-access"})
	public void validateProductInformations() throws Exception {
		// Assert.assertEquals(nomeProduto, tituloProduto.getText());
		if (Integer.parseInt(helper.getInputQuantity()) > 1) {
			float totalValueRefactor = Float.parseFloat(unitaryValue.getText().replace("$", ""));
			float sum = Float.parseFloat(helper.getTotalValue());
			String totalValue = String.format("%.2f", totalValueRefactor + sum).replace(",", ".");
			helper.setProductValue(totalValue);
		} else
			helper.setProductValue(unitaryValue.getText().replace("$", ""));
		
		
	}
	
	@SuppressWarnings("static-access")
	public void calculateTotalValueProducts() {
			WebElement 
			totalProductsValue = getDriver().findElement(By.xpath("//span[@class='ajax_block_products_total'][contains(text(),'$')]")),
			shippingCost = getDriver().findElement(By.xpath("//span[@class='ajax_cart_shipping_cost'][contains(text(),'$')]"));
			
			float totalValue = Float.parseFloat(totalProductsValue.getText().replace("$", ""));
			float shippingValue = Float.parseFloat(shippingCost.getText().replace("$", ""));
			String recalculateTotalValue = String.format("%.2f", totalValue+shippingValue);
			helper.setTotalValue(recalculateTotalValue);
	}
	@SuppressWarnings("static-access")
	public void enterPurchaseInformation() throws InterruptedException {
		sleep(1000);
		inputQuantity.click();
		inputQuantity.clear();
		if (productTile.getText().equals("Blouse")) {
			inputQuantity.sendKeys("2");
			helper.setInputQuantity("2");
		} else {
			inputQuantity.sendKeys("1");
		}
		
		selectPerText(selectSize, "M");
		if (productTile.getText().equals("Printed Chiffon Dress")) {
			WebElement cor = getDriver().findElement(By.xpath("//a[@name='Green']"));
			cor.click();
		}else if(productTile.getText().equals("Faded Short Sleeve T-shirts")){
			WebElement cor = getDriver().findElement(By.xpath("//a[@name='Blue']"));
			cor.click();
		}
		takeScreenshot("Alteracao do produto"+" "+helper.getNameProduct()+" "+"com sucesso");
		btnAddToCart.click();
		Thread.sleep(3000);
		calculateTotalValueProducts();
		System.out.println(helper.getTotalValue());
	}

	public void validateProductAddedToCart() {
		sleep(5000);
		Assert.assertEquals(helper.getTotalValue().replace(",", "."), totalValue.getText().replace("$", ""));
		takeScreenshot("Produto"+" "+helper.getNameProduct()+" "+"adicionado ao carrinho");
		btnProceedToContinueShopping.click();
	}
}
