package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import resources.BaseClass;

public class setup_Education {
public setup_Education() {
		
		PageFactory.initElements(BaseClass.driver, this);
	}


	@FindBy(how = How.CSS, using = "a[title='Setup menu']")
	public WebElement setupMenu;
	
	@FindBy(how = How.CSS, using = "#rpisubEducationalResources")
	public WebElement EducationalResource_setup;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Educational Resource Details')]")
	public WebElement EducationalResource_header;
	
	@FindBy(how = How.CSS, using = "#txtEducationalResourceID")
	public WebElement EResource_id;
	
	@FindBy(how = How.CSS, using = "#txtDisplayName")
	public WebElement EResource_displayName;

	@FindBy(how = How.CSS, using = "#rbFile")
	public WebElement EResource_File_radiobtn;
	
	@FindBy(how = How.ID, using = "ctl00_ConfigureMainContent_asUploadKeyfile0")
	public WebElement EResource_File_upload;
	
	@FindBy(how = How.ID, using = "btnSave")
	public WebElement EResource_save;
	


	
	
	 public static By wait_setup() {return By.cssSelector("#ctl00_mnuUserMenu_i0_i0_btnUserMenuSetup");}
	 public static By wait_ER_remove() {return By.cssSelector("input[value='Remove']");}
	 public static By wait_ER_addpage_open() {return By.cssSelector("#h1tag");}
	 public static By wait_Home() {return By.xpath("(//span[@class='rmText rmExpandDown'])[2]");}
	 public static By wait_org() {return By.xpath("//h1[contains(text(),'Organizations')]");}
	 public static By wait_ER_add() {return By.id("ctl00_ConfigureMainContent_rgEducationalResource_ctl00_ctl02_ctl00_btnAdd");}
	 public static By wait__ER_add_statusMsg() {return By.id("lblStatusMessage");}

}
