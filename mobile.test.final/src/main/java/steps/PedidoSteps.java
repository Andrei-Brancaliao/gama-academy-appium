package steps;

import static utils.Utils.driver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PedidosPage;
import pageObjects.PerfilPage;
import pageObjects.QuadrinhoPage;

public class PedidoSteps {

	QuadrinhoPage pageQuadrinho = new QuadrinhoPage(driver);
	PerfilPage pagePerfil = new PerfilPage(driver);
	PedidosPage pagePedidos = new PedidosPage(driver);
	
	@When("o usuario entrar na lista de pedidos")
	public void oUsuarioEntrarNaListaDePedidos() throws InterruptedException {
		pageQuadrinho.clickPerfilButton();
		pagePedidos.clickPedidos();
		Thread.sleep(3000);
	}

	@Then("podera acessar o ultimo detalhe do pedido")
	public void poderaAcessarOUltimoDetalheDoPedido() throws InterruptedException {
		pagePedidos.clickOnLastDetailElement();
	}
}
