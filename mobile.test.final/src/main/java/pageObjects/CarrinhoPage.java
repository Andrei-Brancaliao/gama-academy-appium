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
	
}
