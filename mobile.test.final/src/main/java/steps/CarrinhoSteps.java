package steps;

import pageObjects.CarrinhoPage;

import static utils.Utils.driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class CarrinhoSteps {

	CarrinhoPage pageCarrinho = new CarrinhoPage(driver);
	
	@Given("esteja no carrinho de compras")
	public void estejaNoCarrinhoDeCompras() {
		pageCarrinho.verifyCarrinhoPage();
	}
	
	@When("clicar em fazer o pagamento")
	public void clicarEmFazerOPagamento() {
		pageCarrinho.clickOnPayment();
	}
}
