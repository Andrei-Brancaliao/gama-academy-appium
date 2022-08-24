package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.QuadrinhoPage;

import static utils.Utils.driver;

public class QuadrinhoSteps {

	QuadrinhoPage pageQuadrinho = new QuadrinhoPage(driver);
	
	//verificacao de tela quadrinho - está na tela
	@Then("sera exibida a tela de quadrinhos para o usuario")
	public void seraExibidaATelaDeQuadrinhosParaOUsuario() {
		pageQuadrinho.verifyQuadrinhoPage();
	}
	
	@Given("tenha adicionado um item no carrinho")
	public void tenhaAdicionadoUmItemNoCarrinho() {
		pageQuadrinho.searchSpecificComicBook("fantastic");
		pageQuadrinho.selectComicBook();
		pageQuadrinho.addItemToCart(1);
	}
	
	
	
}
