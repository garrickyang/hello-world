package seleniumtest.container;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;;

public class HomePageContainer {
	@FindBy(how = How.XPATH, using="/html/body/div[3]/div[1]/div/div[3]/a[7]")
	//@FindBy( how = How.NAME, using = "tj_login")
	private WebElement logInButten;
	
	@FindBy( how = How.ID, using = "s_username_top")
	private WebElement userlink;
	
	public WebElement getUserlink() {
		return userlink;
	}

	public WebElement getLogInButten() {
		return logInButten;
	}
	
	
}
