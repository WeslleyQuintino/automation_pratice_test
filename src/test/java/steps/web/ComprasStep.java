package steps.web;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.*;

import java.io.IOException;


public class ComprasStep {
	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	MyAccountPage myAccount = new MyAccountPage();
	ComprasPage shoppingPage = new ComprasPage();
	OrderPage order = new OrderPage();
	CadastroPage cadastro = new CadastroPage();
	
	@Dado("que esteja logado na pagina inicial")
	public void que_esteja_logado_na_pagina_inicial() throws IOException {
		login.loginWithValidData("automatomati@gmail.com", "12345");
		myAccount.validateWelcomeMessage();
		home.backToHome();
	}
	
	@Dado("que esteja na home page")
	public void que_esteja_na_home_page() {
		home.backToHome();
	}

	@E("adicione compras ao carrinho")
	public void adicione_ao_carrinho() throws Exception {
		home.buyShopping();
	}

	@Quando("prosseguir com a compra ate o checkout")
	public void prosseguir_com_a_compra_ate_o_checkout() throws InterruptedException {
		order.clickProceedToCheckout();
	}
	
	@Entao("realizar cadastro para prosseguir com a compra  via {string}")
	public void realizar_cadastro_para_prosseguir_com_a_compra(String payment) {
		cadastro.validateRegistePage();
		cadastro.insertEmail();
		cadastro.clickBtnCreateAccount();
		cadastro.registerAccount("2", "8", "1992", "Florida", "71660");
		order.btnProceedToCheckout();
		order.validateDelivery();
		order.validatePayment(payment);
	}
	
	@Entao("a compra e realizada com sucesso via {string}")
	public void a_compra_e_realizada_com_sucesso(String payment) throws InterruptedException {
		order.validateAddress();
		order.validateDelivery();
		order.validatePayment(payment);
	}
}
