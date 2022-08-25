package pageObjects;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utils.Utils;

public class PedidosPage {
	
	public PedidosPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//formatador de data para comparação
	DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d/MM/yyyy");
	DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("h:m:s");
	
	//criar string de comparação de pedido
	String dataDoPedido = "Data: " + CompraPage.dataCompra.format(formatterDate) + " - " + CompraPage.dataCompra.format(formatterTime);
	
	//esse elemento tem tratamento no xpath para pegar sempre o ULTIMO da lista
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View[last()]/android.view.View/android.view.View/android.view.View/android.widget.Button[@text='Detalhes']")
	private MobileElement lastDetailButton;

	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View[last()-1]/android.view.View/android.view.View/android.view.View/android.view.View")
	private MobileElement comparativeElementOnBottom;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View[last()-1]/android.view.View/android.view.View/android.view.View/android.view.View")
	private MobileElement lastElementOnBottom;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]")
	private MobileElement purchaseDate;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]")
	private MobileElement totalValue;
	
	public void clickOnLastDetailElement() throws InterruptedException {
		scrollToBottomPedidosList(comparativeElementOnBottom);
		lastDetailButton.click();
	}
	
	public void verifyLastPurchase() {
		assertEquals(purchaseDate.getText(), dataDoPedido);
		assertEquals(CarrinhoPage.getTotalValue(), totalValue.getText());
	}
	
	@SuppressWarnings("rawtypes")
	public void scrollDown() throws InterruptedException {
		Thread.sleep(2000);
		
		Dimension size = Utils.driver.manage().window().getSize();
		System.out.println(size);
		int topY = (int) (size.height * 0.70);
		int bottomY = (int) (size.height * 0.30);
		int centerX = size.width / 2;

		TouchAction scrollMove = new TouchAction(Utils.driver);
		
		scrollMove.press(PointOption.point(centerX,topY))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(centerX,bottomY)).release().perform();

	}
	
	
	String textBottomElement = comparativeElementOnBottom.getText();
	
	public void scrollToBottomPedidosList(MobileElement elementOnBottomOfAPage) throws InterruptedException {
		
		boolean isTheSameElement = false;
			
		while (isTheSameElement == false){
			if(textBottomElement.equals("")) {
				isTheSameElement = true;
			}else {
				isTheSameElement = true;
//				scrollDown();
			}
		}
	}
}
