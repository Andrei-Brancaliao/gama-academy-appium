package steps;

import pageObjects.CarrinhoPage;
import pageObjects.PedidosPage;
import pageObjects.PerfilPage;
import pageObjects.QuadrinhoPage;
import pageObjects.CompraPage;

import static utils.Utils.driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CarrinhoSteps {

	
	CarrinhoPage pageCarrinho = new CarrinhoPage(driver);
	QuadrinhoPage pageQuadrinho = new QuadrinhoPage(driver);
	PerfilPage pagePerfil = new PerfilPage(driver);
	PedidosPage pagePedidos = new PedidosPage(driver);
	CompraPage pageCompra = new CompraPage(driver);
	
	
	@Given("esteja no carrinho de compras")
	public void estejaNoCarrinhoDeCompras() {
		pageCarrinho.verifyCarrinhoPage();
	}
	
	@When("clicar em fazer o pagamento")
	public void clicarEmFazerOPagamento() {
		pageCarrinho.clickOnPayment();
	}
	
	@Then("o pedido estara na aba de Pedidos do perfil")
	public void oPedidoEstaraNaAbaDePedidosDoPerfil() throws InterruptedException {
		pageCompra.clickOkButton();
		pageQuadrinho.clickPerfilButton();
		pagePedidos.clickPedidos();
		pagePedidos.clickOnLastDetailElement();
		pagePedidos.verifyLastPurchase();
		//vai falhar. estou tendo problemas com a verificação de horario, nao consigo acertar
		//o momento no qual esta sendo gerado, e por voltar em segundos, nao consigo fazer a
		//verificacao completa
	}
}
