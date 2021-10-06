package steps.web;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CadastroPage;
import pages.LoginPage;

public class CadastroStep {
	CadastroPage cadastro = new CadastroPage();
	LoginPage login = new LoginPage();
	@Dado("que eu esteja na pagina de cadastro")
	public void queEuEstejaNaPaginaDeCadastro() {
		cadastro.validateRegistePage();
	}

	@Quando("realizo meu cadastro com os dados corretos")
	public void realizoMeuCadastroComOsDadosCorretos() {
		cadastro.insertEmail();
		cadastro.clickBtnCreateAccount();
		cadastro.registerAccount("2", "8", "1992", "Florida", "71660");
	}

	@Entao("o cadastro e realizado com sucesso")
	public void oCadastroERealizadoComSucesso() {
		cadastro.validarContaCriada();
		cadastro.logOutAccount();
	}
	
	@E("realizo login com a conta criada")
	public void realizoLoginComAContaCriada() {
	   login.loginWithAccountCreated();
	   login.validateSucessfullyLogin();
	}
}
