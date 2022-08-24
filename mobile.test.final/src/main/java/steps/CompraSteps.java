package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CompraPage;

import static utils.Utils.driver;

public class CompraSteps {

	CompraPage pageCompra = new CompraPage(driver);
	
	@When("inserir o {string} no campo numero do cartao")
	public void inserirONoCampoNumeroDoCartao(String string) {
		pageCompra.insertCardNumber(string);
	}

	@When("inserir o {string} no campo nome impresso")
	public void inserirONoCampoNomeImpresso(String string) {
		pageCompra.insertName(string);
	}

	@When("inserir a {string} no campo validade")
	public void inserirANoCampoValidade(String string) {	
		pageCompra.insertExpirationDate(string);
	}

	@When("inserir os {string} no campo codigo de seguranca")
	public void inserirOsNoCampoCodigoDeSeguranca(String string) {
		pageCompra.insertSafeCode(string);
	}

	@When("clicar no botao Pagar agora")
	public void clicarNoBotaoPagarAgora() {
		pageCompra.pressPayNowButton();
	}

	@Then("um popup sera exibido")
	public void umPopupSeraExibido() {
		pageCompra.verifyPopUpDialog();
	}

	@Then("tera o texto de Compra Finalizada")
	public void teraOTextoDeCompraFinalizada() {
		pageCompra.verifyTextoOnPopUpDialog();
		pageCompra.verifyTextOfAprovalPopUp();
	}
	
}
