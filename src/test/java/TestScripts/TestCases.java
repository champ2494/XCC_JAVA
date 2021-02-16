package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ExtentManager.extentManager;
import com.aventstack.extentreports.Status;

import Driver.xccDriver;
import Excel.TestData;
import Pages.setup_Education;
import autoitx4java.AutoItX;
import resources.BaseClass;

public class TestCases extends BaseClass {
	@Test

	public void loginPageTest() throws Exception {

		//wait till image loads and how to pass path dynamically-tmrw
		extentManager.test.log(Status.INFO, "[Start the test by logging in]");
		Login();
		extentManager.test.log(Status.PASS, "[Successfully logging in]");

		extentManager.test.log(Status.INFO, "[wait till the page loads]");
		wait.until(ExpectedConditions.presenceOfElementLocated(setup_Education.wait_Home()));
		extentManager.test.log(Status.PASS, "[Home page loaded]");

		extentManager.test.log(Status.INFO, "[click the setup dropdown]");
		xccDriver.getEducation().setupMenu.click();
		extentManager.test.log(Status.PASS, "[clicked the setup dropdown]");

		extentManager.test.log(Status.INFO, "[click the setup menu from the dropdown]");
		wait.until(ExpectedConditions.presenceOfElementLocated(setup_Education.wait_setup())).click();
		extentManager.test.log(Status.PASS, "[clicked the setup menu from the dropdown]");

		extentManager.test.log(Status.INFO, "[wait till org page displayed]");
		wait.until(ExpectedConditions.presenceOfElementLocated(setup_Education.wait_org()));
		extentManager.test.log(Status.PASS, "[org page displayed]");

		extentManager.test.log(Status.INFO, "[scroll till the educational resource is found]");
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", xccDriver.getEducation().EducationalResource_setup);
		xccDriver.getEducation().EducationalResource_setup.click();
		extentManager.test.log(Status.PASS, "[scrolled till the educational resource is found]");

		extentManager.test.log(Status.INFO, "[wait till the add button is present and click that button]");
		wait.until(ExpectedConditions.presenceOfElementLocated(setup_Education.wait_ER_add())).click();
		extentManager.test.log(Status.PASS, "[Add button is clicked]");

		extentManager.test.log(Status.INFO, "[wait till the add page is opened");
		wait.until(ExpectedConditions.presenceOfElementLocated(setup_Education.wait_ER_addpage_open()));
		extentManager.test.log(Status.PASS, "[Add page is opened]");

		extentManager.test.log(Status.INFO, "[Verify the page header");
		String header = xccDriver.getEducation().EducationalResource_header.getText();
		Assert.assertEquals(header.trim(), "Educational Resource Details");
		extentManager.test.log(Status.PASS, "[Page header verified]" + " " + header.trim());

		extentManager.test.log(Status.INFO, "[Call the excel function");
		xccDriver.getExcelData().readExcel(0, "ER");
		extentManager.test.log(Status.PASS, "[Excel function is called]");

		extentManager.test.log(Status.INFO, "[Pass value to the educational resource id]");
		xccDriver.getEducation().EResource_id.sendKeys(TestData.ER_id);
		extentManager.test.log(Status.PASS, "[Passed values to the educational resource id]");

		extentManager.test.log(Status.INFO, "[Pass value to the educational resource displayName]");
		xccDriver.getEducation().EResource_displayName.sendKeys(TestData.ER_displayName);
		extentManager.test.log(Status.PASS, "[Passed values to the educational resource displayName]");

		extentManager.test.log(Status.INFO, "[Click the file radio button]");
		xccDriver.getEducation().EResource_File_radiobtn.click();
		extentManager.test.log(Status.PASS, "[Clicked the file radio button]");

		extentManager.test.log(Status.INFO, "[Pass the path of the file]");
		js.executeScript("arguments[0].click();", xccDriver.getEducation().EResource_File_upload);
		Thread.sleep(5000);
		Runtime.getRuntime().exec("E:\\script_at\\upload.exe");
		Thread.sleep(8000);
		extentManager.test.log(Status.PASS, "[File path is passed]");

		extentManager.test.log(Status.INFO, "[click save]");
		xccDriver.getEducation().EResource_save.click();
		extentManager.test.log(Status.PASS, "[clicked save]");

		extentManager.test.log(Status.INFO, "[Verify the status message");
		String added_msg = wait.until(ExpectedConditions.presenceOfElementLocated(setup_Education.wait__ER_add_statusMsg())).getText();		
		Assert.assertEquals(added_msg.trim(), "Educational resource saved successfully.");
		extentManager.test.log(Status.PASS, "[status message verified]" + " " + added_msg.trim());

	}

}
