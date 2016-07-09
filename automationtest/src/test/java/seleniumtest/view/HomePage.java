package seleniumtest.view;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumtest.BrowserDriver;
import seleniumtest.container.HomePageContainer;

public class HomePage {
	private static String TITLE = "百度一下，你就知道";
	private static final Logger LOGGER = Logger.getLogger(HomePage.class.getName());
	private static HomePageContainer homePageContainner = null;

	public static HomePageContainer getHomePageContainer(WebDriver driver) {
		if (homePageContainner == null) {
			homePageContainner = PageFactory.initElements(driver, HomePageContainer.class);
		}
		return homePageContainner;
	}

	public static void refresh(WebDriver driver) {
		homePageContainner = PageFactory.initElements(driver, HomePageContainer.class);
	}

	public static WebElement isLoaded(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[3]/a[7]"));
			}
		});

	}

	public static WebElement isLogedin(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.id("s_username_top"));
			}
		});
	}

	public static boolean isOpen(WebDriver currentDriver) {
		
		return currentDriver.getTitle().equals(TITLE);
	}

}
