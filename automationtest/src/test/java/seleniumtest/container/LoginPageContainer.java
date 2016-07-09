package seleniumtest.container;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageContainer {
	@FindBy(how = How.NAME, using="userName")
	private WebElement userNameInputText;
	
	@FindBy(how = How.NAME,using="password")
	private WebElement passWordInputText;
	
	@FindBy(how = How.NAME, using="memberPass")
	private WebElement memberPass;
	
	@FindBy(how = How.CLASS_NAME, using="pass-button-submit")
	private WebElement submit;

	public WebElement getUserNameInputText() {
		return userNameInputText;
	}

	public void setUserNameInputText(WebElement userNameInputText) {
		this.userNameInputText = userNameInputText;
	}

	public WebElement getPassWordInputText() {
		return passWordInputText;
	}

	public void setPassWordInputText(WebElement passWordInputText) {
		this.passWordInputText = passWordInputText;
	}

	public WebElement getMemberPass() {
		return memberPass;
	}

	public void setMemberPass(WebElement memberPass) {
		this.memberPass = memberPass;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}
	
	

}
