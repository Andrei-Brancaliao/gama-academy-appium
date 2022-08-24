package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	public LoginPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.EditText[@index='0'])[1]")
	private MobileElement emailField;
		
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Senha']")
	private MobileElement passwordField;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='MARVELOPÉDIA']")
	private MobileElement homeText;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
//	@AndroidFindBy(accessibility = "Login")
	private MobileElement btnLogin;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Crie uma conta']")
	private MobileElement btnCreateAccount;
	
	//methods used on login page
	public void verifyHomeScreen() {
		assertTrue(homeText.isDisplayed());
		assertTrue(emailField.isDisplayed());
		assertTrue(passwordField.isDisplayed());
		assertTrue(btnCreateAccount.isDisplayed());
	}
 	
	public void insertEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void insertPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		btnLogin.click();
	}

}
