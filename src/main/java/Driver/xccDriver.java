package Driver;

import Excel.TestData;
import Pages.Login;
import Pages.setup_Education;

public class xccDriver {
	
	public static Login getLogin()
	{
		return new Login();
	}
	
	public static TestData getExcelData()
	{
		return new TestData();
	}
	
	public static setup_Education getEducation()
	{
		return new setup_Education();
	}

}
