package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CompraPage {
	
	public CompraPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public static LocalDateTime dataCompra = LocalDateTime.now();
	
	//Mobile Elements location
		
	@AndroidFindBy(xpath = "//android.view.View[@text='Pagamento']")
	private MobileElement pagamentoScreenText;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='arrow back']")
	private MobileElement arrowBackButton;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='0'][1]")
	private MobileElement cardNumberField;

	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private MobileElement nameField;
	
	@AndroidFindBy(xpath = "//android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private MobileElement expirationField;
	
	@AndroidFindBy(xpath = "//android.view.View[4]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private MobileElement safeCodeField;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Pagar agora!']")
	private MobileElement pagarAgoraButton;
	
	@AndroidFindBy(xpath = "//android.app.Dialog/android.view.View[2]/android.view.View[1]")
	private MobileElement popUpWithMessage;
	
//	MobileElement testeTextoDialogo = (MobileElement) Utils.driver.findElementById("alert-2-hdr");
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Compra finalizada!']")
	private MobileElement textOnDialogScreen;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Obrigado! Sua compra foi realizada com sucesso.']")
	private MobileElement subTextOnDialogScreen;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement okDialogButton;

	//	MobileElement teste = (MobileElement) Utils.driver.findElementsByXPath("//android.widget.EditText[@index='0']").get(0);
	
	public void verifyPaymentScreen() {
		assertTrue(pagamentoScreenText.isDisplayed());
		assertTrue(arrowBackButton.isDisplayed());
		assertTrue(cardNumberField.isDisplayed());
		assertTrue(nameField.isDisplayed());
		assertTrue(expirationField.isDisplayed());
		assertTrue(safeCodeField.isDisplayed());
		assertTrue(pagamentoScreenText.isDisplayed());
	}
	
	public void insertCardNumber(String cardNumber) {
		cardNumberField.sendKeys(cardNumber);
	}
	
	public void insertName(String name) {
		nameField.sendKeys(name);
	}
	
	public void insertExpirationDate(String expirationDate) {
		expirationField.sendKeys(expirationDate);
	}
	
	public void insertSafeCode(String safeCode ) {
		safeCodeField.sendKeys(safeCode);
	}
	
	public void pressPayNowButton() {
		pagarAgoraButton.click();
		dataCompra = LocalDateTime.now();
		System.out.println(dataCompra);
	}
	
	public void verifyPopUpDialog() {
		assertTrue(popUpWithMessage.isDisplayed());
	}
	
	public void verifyTextoOnPopUpDialog() {
		assertTrue(textOnDialogScreen.isDisplayed());
	}
	
	public void verifyTextOfAprovalPopUp() {
		assertEquals(textOnDialogScreen.getText(), "Compra finalizada!");
		assertEquals(subTextOnDialogScreen.getText(), "Obrigado! Sua compra foi realizada com sucesso.");
	}
	
	public void clickOkButton() {
		okDialogButton.click();
	}
	
}
