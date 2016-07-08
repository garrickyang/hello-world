package seleniumtest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import seleniumtest.view.HomePage;
import seleniumtest.view.LoginPage;

public class LoginStepdefs {
	@Given("^open site page '(.+)'$")
	public void open_site_page(String site) throws Throwable {
		BrowserDriver.loadPage(site);
		Assert.assertTrue(HomePage.isOpen(BrowserDriver.getCurrentDriver()));
		LoginPage.getLoginPageContainer(BrowserDriver.getCurrentDriver());
		}

	@When("^type name '(.+)' and  passowrd '(.+)'$")
	public void type_name_and_passowrd(String name, String password) throws Throwable {
		HomePage.isLoaded(BrowserDriver.getCurrentDriver()).getText();
		HomePage.getHomePageContainer(BrowserDriver.getCurrentDriver()).getLogInButten().click();
		LoginPage.isLoaded(BrowserDriver.getCurrentDriver());
		
		LoginPage.getLoginPageContainer(null).getUserNameInputText().sendKeys(name);
		LoginPage.getLoginPageContainer(null).getPassWordInputText().sendKeys(password);
		LoginPage.getLoginPageContainer(null).getSubmit().click();
		
	}

	@Then("^I shoud see my name '(.+)'$")
	public void i_shoud_see_my_name(String name) throws Throwable {
		//BrowserDriver.getCurrentDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage.isLogedin(BrowserDriver.getCurrentDriver());
		Assert.assertTrue(HomePage.getHomePageContainer(null).getUserlink().getText().equals(name));
	}

}
