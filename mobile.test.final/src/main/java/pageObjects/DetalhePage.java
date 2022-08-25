package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DetalhePage {
	
	public DetalhePage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath = "(//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1])")
	private MobileElement comicBookNameOnDetail;
	
	@AndroidFindBy(xpath = "(//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2])")
	private MobileElement quantityOfComicBooks;
	
	@AndroidFindBy(xpath = "(//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3])")
	private MobileElement priceOneComicBook;
	
	@AndroidFindBy(xpath = "(//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4])")
	private MobileElement dateOfPurchase;
	
	@AndroidFindBy(xpath = "(//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5])")
	private MobileElement totalAmount;



	public void verifyDetails() throws InterruptedException {
		Thread.sleep(500);
		assertEquals(comicBookNameOnDetail.getText(), CarrinhoPage.comicBookName);
		assertEquals(quantityOfComicBooks.getText(), CarrinhoPage.quantityOfComics);
		assertEquals(priceOneComicBook.getText(), CarrinhoPage.priceByComic);
		assertEquals(totalAmount.getText(), CarrinhoPage.totalAmount);
	}
	
}
