package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class QuadrinhoPage {
	
	public QuadrinhoPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Quadrinhos']")
	private MobileElement quadrinhoTextScreen;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='cart']")
	private MobileElement cartIcon;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
	private MobileElement searchField;
	
	@AndroidFindBy(xpath = "//android.widget.Image[@text='search']")
	private MobileElement searchIcon;
	
	@AndroidFindBy(xpath = "//android.widget.Image[@text='4bc66f11313e5']")
	private MobileElement fantasticComicBook;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='arrow back']")
	private MobileElement backArrowIcon;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Adicionar R$ 0']")
	private MobileElement addToCartButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='+']")
	private MobileElement increaseUnityButton;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='person Perfil']")
	private MobileElement perfilButton;
		
	public void verifyQuadrinhoPage() {
		assertTrue(quadrinhoTextScreen.isDisplayed());
		assertTrue(cartIcon.isDisplayed());
		assertTrue(searchField.isDisplayed());
		assertTrue(searchIcon.isDisplayed());
	}
	
	public void searchSpecificComicBook(String name) {
		searchField.sendKeys(name);
	}
	
	public void selectComicBook() {
		fantasticComicBook.click();
	}
	
	public void addItemToCart(int quantity) {
		for(int i = 0; i < quantity; i++) {
		increaseUnityButton.click();
		}
		addToCartButton.click();
	}
	
	public void clickPerfilButton() {
		perfilButton.click();
	}
}
