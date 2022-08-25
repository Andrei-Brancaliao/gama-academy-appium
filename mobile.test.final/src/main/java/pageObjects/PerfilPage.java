package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PerfilPage {
	
	public PerfilPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Pedidos']")
	private MobileElement pedidosListButton;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Senha']")
	private MobileElement senhaListButton;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Sobre']")
	private MobileElement sobreListButton;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Logout']")
	private MobileElement logoutListButton;
	
	public void clickPedidos() {
		pedidosListButton.click();
	}
}
