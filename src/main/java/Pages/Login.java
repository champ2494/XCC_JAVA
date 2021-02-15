package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import resources.BaseClass;

public class Login {

public Login() {
		
		PageFactory.initElements(BaseClass.driver, this);
	}

	@FindBy(how = How.ID, using = "txtLoginID")
	public WebElement userName;

	@FindBy(how = How.ID, using = "txtLoginAuthentication")
	public WebElement Password;
	
	@FindBy(how = How.ID, using = "btnLogin")
	public WebElement loginbtn;
	
	

	
	  
	//  public static By wait_signIn() {return By.xpath("//button[@title='Sign in']");}

}
