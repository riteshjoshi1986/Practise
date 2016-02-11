/**
 * 
 */
package TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectModel.loginPage;
import Utilities.Constants;
import Utilities.excelReaderUpdater;
import Utilities.screenshots;

/**
 * @author rj0844
 * This is the test case class to execute the POM
 */
public class loginTest {

		/**
	 * @param args
	 */
	 
	WebDriver driver;
	excelReaderUpdater read = new excelReaderUpdater();
	
	@BeforeMethod
	//@Parameters("browser")
	public void browserLaunch() throws Exception{
		XSSFSheet Sheet = read.excelReader(Constants.filepath, "Configuration");
		String browser = Sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(browser);
		String url = Sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(url);
		if (browser.equalsIgnoreCase("firefox"))
		{
		driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\User1\\Documents\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screenshots.captureScreen(driver, "browser");
		
		
	}
	
	@Test
	public void login() throws Exception {
		// TODO Auto-generated method stub
		
		//launch firefox browser
		
		
		loginPage login = new loginPage(driver);
		login.setUserName("mngr27900");
		login.setpswd("hUrenYd");
		login.clickLogin();
		
		String homepagetext = driver.findElement(By.xpath("html/body/div[1]/h2")).getText();
		System.out.println(homepagetext);
		String mgrtext = driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
		Assert.assertEquals("Guru99 Bank", homepagetext);
		Assert.assertEquals("Manger Id : mngr27900", mgrtext);
	}
	
	@AfterMethod
	public void browserClose(){
		driver.close();
	}

}
