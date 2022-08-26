package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CarrinhoPage {

	public CarrinhoPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.Button[@text='Fazer Pagamento'])")
	private MobileElement fazerPagamentoButton;
	
	@AndroidFindBy(xpath = "(//android.view.View[@text='Carrinho'])")
	private MobileElement carrinhoScreenText;
	
	@AndroidFindBy(xpath = "(//android.widget.Button[@text='arrow back'])")
	private MobileElement arrowBackButton;

	@AndroidFindBy(xpath = "(//android.widget.Image[@text='close'])")
	private MobileElement closeButton;

	@AndroidFindBy(xpath = "(//android.view.View[2]/android.view.View/android.view.View[2])")
	private static MobileElement totalValue;
			
	//elementos do quadrinho na lista de carrinho
	@AndroidFindBy(xpath = "(//android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View)")
	private static MobileElement comicBookNameOnCart;
	
	@AndroidFindBy(xpath = "(//android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.widget.TextView)")
	private static MobileElement quantityOfComicBooks;
	
	@AndroidFindBy(xpath = "(//android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View[3])")
	private static MobileElement totalAmountByComics;

	@AndroidFindBy(xpath = "(//android.view.View[2]/android.view.View/android.view.View[2])")
	private static MobileElement totalAmountTotal;
		
	public static String comicBookName = "";
	public static String quantityOfComics = "";
	public static String priceByComic = "";
	public static String totalAmount = "";
	
	public void verifyCarrinhoPage() {
		assertTrue(carrinhoScreenText.isDisplayed());
		assertTrue(arrowBackButton.isDisplayed());
	}
	
	public void clickOnPayment() {
		fazerPagamentoButton.click();
	}

	public static String getTotalValue() {
		return totalValue.getText();
	}
	
	public void carrinhoStringTreatment() {
		//tratamento de string para comparacao nos detalhes
		comicBookName = "\"" + comicBookNameOnCart.getText() + "\"";
		quantityOfComics = "Qtd: " + quantityOfComicBooks.getText();
		priceByComic = "R$ " + totalAmountByComics.getText();
		totalAmount = totalAmountTotal.getText();
	}
}
