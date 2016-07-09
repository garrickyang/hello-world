package seleniumtest.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumtest.container.HomePageContainer;
import seleniumtest.container.LoginPageContainer;

public class LoginPage {
	static private LoginPageContainer loginPageContainer = null;

	public static LoginPageContainer getLoginPageContainer(WebDriver driver) {
		if (loginPageContainer == null) {
			loginPageContainer = PageFactory.initElements(driver, LoginPageContainer.class);
		}
		return loginPageContainer;
	}

	public static void refresh(WebDriver driver) {
		loginPageContainer = PageFactory.initElements(driver, LoginPageContainer.class);
	}
	
	public static WebElement isLoaded(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("userName"));
			}
		});
	}

}
