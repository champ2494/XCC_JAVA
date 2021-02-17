package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ExtentManager.extentManager;
import com.aventstack.extentreports.Status;

import Driver.xccDriver;
import Excel.TestData;


public class BaseClass {
	public static WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	
	@BeforeSuite
	public void BeforeSuite() {
		extentManager.setExtent();
	}

	@AfterSuite
	public void AfterSuite() {
		extentManager.endReport();
	}
	@BeforeMethod
	public void setup() throws IOException {
		
		prop = new Properties();
		String path = System.getProperty("user.dir") + "\\" + "src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "chromedriver.exe");
		
		driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\" + "geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		wait=new WebDriverWait(driver,60);

		

		
	}

	public void Login() throws IOException
	{
		xccDriver.getExcelData().readExcel(0, "Login");
		
		extentManager.test.log(Status.INFO,"[Navigate to URL]");
		driver.get(prop.getProperty("url"));
		extentManager.test.log(Status.PASS,"[Navigated to URL]"+" " +":"+ prop.getProperty("url"));
		
		extentManager.test.log(Status.INFO,"[Pass the Username]");
		xccDriver.getLogin().userName.sendKeys(TestData.username_value);
		extentManager.test.log(Status.PASS,"[UserName is Passed]");
		
		extentManager.test.log(Status.INFO,"[Pass the Password]");
		xccDriver.getLogin().Password.sendKeys(TestData.Password_value);
		extentManager.test.log(Status.PASS,"[Password is passed]");
		
		extentManager.test.log(Status.INFO,"[Click the signIn button]");
		xccDriver.getLogin().loginbtn.click();
		extentManager.test.log(Status.PASS,"[Clicked the signIn button]");
		
			}
		
	@AfterMethod
	public void tearDown() throws IOException {
		//driver.close();
	}

	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateName + ".png";
		
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return destination;
	}

	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

}
