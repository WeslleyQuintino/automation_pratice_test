package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;
import utils.TestDataReader;

import static Core.DriverFactory.getDriver;

public class PesquisaProdutoPage extends  BasePage{
    static TestDataReader dataTable = new TestDataReader();
    public PesquisaProdutoPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "search_query_top")
    private WebElement inpSearchProduct;

    @FindBy(name = "submit_search")
    private WebElement searchProduct;

    @FindBy(xpath = "//h1[contains(text(),'Search')]")
    private  WebElement titleSearchedProduct;

    @FindBy(xpath = "//h5[@itemprop='name']/a")
    private  WebElement product;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement titleProductName;

    @FindBy(xpath = "//p[@class='our_price_display']")
    private WebElement valueOffer;

    public void searchProduct(){
        assertTrue(inpSearchProduct.isDisplayed());
        inpSearchProduct.click();
        inpSearchProduct.sendKeys(dataTable.getDt("in_Pesquisa_Produto"));
        takeScreenshot("Produto "+dataTable.getDt("in_Pesquisa_Produto")+" digítado na barra de pesquisa");
        searchProduct.click();
    }
    public void validateSearchedProduct(){
        WebElement searchedProduct = getDriver().findElement(By.xpath("//span[contains(text(),'"+dataTable.getDt("in_Pesquisa_Produto")+"')]"));
        assertTrue(searchedProduct.isDisplayed());
        System.out.println(searchedProduct.getText());
        takeScreenshot("Pesquisa realizada do produto "+dataTable.getDt("in_Pesquisa_Produto"));
        assertEquals(dataTable.getDt("in_Pesquisa_Produto").toUpperCase(),searchedProduct.getText().replace("\"",""));
    }

    public void selectProduct() {
        assertTrue(product.isDisplayed());
        product.click();
        sleep(5000);
    }

    public void validateProductSelected(){
        assertTrue(titleProductName.getText().contains(dataTable.getDt("in_Pesquisa_Produto")));
        assertTrue(valueOffer.isDisplayed());
        takeScreenshot("Produto"+dataTable.getDt("in_Pesquisa_Produto")+ " visualizado");
    }
}
