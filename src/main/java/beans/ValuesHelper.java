package beans;

import io.restassured.response.Response;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValuesHelper {

	public static Response response;
	private static String scenarioName;
	private String productValue;
	private static String shippingValue;
	private static String totalValue;
	private static String addressNameDelivery;
	private static String inputQuantity;
	private static String nameProduct;
	private static String firstName;
	private static String lastName;
	private static String email;
	private static String password;
	
	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		ValuesHelper.scenarioName = scenarioName;
	}

	public  String getProductValue() {
		return productValue;
	}

	public  void setProductValue(String valorProduto) {
		this.productValue = valorProduto;
	}

	public static String getShippingValue() {
		return shippingValue;
	}

	public static void setValueShipping(String valorFrete) {
		ValuesHelper.shippingValue = valorFrete;
	}

	public static String getTotalValue() {
		return totalValue;
	}

	public static void setTotalValue(String valorTotal) {
		ValuesHelper.totalValue = valorTotal;
	}

	public static String getAddressNameDelivery() {
		return addressNameDelivery;
	}

	public static void setAddressNameDelivery(String nomeEnderecoEntrega) {
		ValuesHelper.addressNameDelivery = nomeEnderecoEntrega;
	}
	public Float sumTotalValue(String valorProduto, String valorFrete) {
		return Float.parseFloat(valorProduto) + Float.parseFloat(valorFrete);
	}

	public static String getInputQuantity() {
		return inputQuantity;
	}

	public static void setInputQuantity(String inputQuantity) {
		ValuesHelper.inputQuantity = inputQuantity;
	}

	public static String getNameProduct() {
		return nameProduct;
	}

	public static void setNameProduct(String nameProduct) {
		ValuesHelper.nameProduct = nameProduct;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		ValuesHelper.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		ValuesHelper.lastName = lastName;
	}

	public static String getEmail() {
		return email;
	}

	public String setEmail(String email) {
		return this.email = email;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		ValuesHelper.password = password;
	}
	

}