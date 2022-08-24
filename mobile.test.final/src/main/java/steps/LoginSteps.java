package steps;

import pageObjects.LoginPage;
import pageObjects.QuadrinhoPage;

import static utils.Utils.driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class LoginSteps {
	
	LoginPage pageLogin = new LoginPage(driver);
	QuadrinhoPage pageQuadrinho = new QuadrinhoPage(driver);
	
	@When("digitar seu {string} no campo Login")
	public void digitarSeuNoCampoLogin(String string) {
		pageLogin.insertEmail(string);
	}

	@When("digitar a {string} no campo Senha")
	public void digitarANoCampoSenha(String string) {
		pageLogin.insertPassword(string);
	}

	@When("clicar no botao Login")
	public void clicarNoBotaoLogin() {
		pageLogin.clickLoginBtn();
	}

	//logar usuario
	@Given("que o usuario esteja logado")
	public void queOUsuarioEstejaLogado() {
		pageLogin.insertEmail("andreibrancaliao@gmail.com");
		pageLogin.insertPassword("123456");
		pageLogin.clickLoginBtn();
		pageQuadrinho.verifyQuadrinhoPage();
	}
}
