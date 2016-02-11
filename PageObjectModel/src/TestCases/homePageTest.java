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
import org.testng.annotations.Test;

import PageObjectModel.homePage;
import PageObjectModel.loginPage;
import Utilities.Constants;
import Utilities.excelReaderUpdater;
import Utilities.screenshots;

public class homePageTest {
	
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
	public void testNewCustLinks() throws Exception{
		XSSFSheet Sheet = read.excelReader(Constants.filepath, "Configuration");
		loginPage login = new loginPage(driver);
		login.setUserName(Sheet.getRow(1).getCell(2).getStringCellValue());
		login.setpswd(Sheet.getRow(1).getCell(3).getStringCellValue());
		login.clickLogin();
		//click Links on next page
		homePage homepage = new homePage(driver);
		homepage.newCustLink();
		String text = driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p")).getText();
		Assert.assertEquals("Add New Customer", text);
		screenshots.captureScreen(driver, "TC_01");
	} 
	
	
	
	@Test
	public void testEditCustLinks() throws Exception{
		XSSFSheet Sheet = read.excelReader(Constants.filepath, "Configuration");
		loginPage login = new loginPage(driver);
		login.setUserName(Sheet.getRow(1).getCell(2).getStringCellValue());
		login.setpswd(Sheet.getRow(1).getCell(3).getStringCellValue());
		login.clickLogin();
		//click Links on next page
		homePage homepage = new homePage(driver);
		homepage.editCustLink();
		String text = driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p")).getText();
		Assert.assertEquals("Edit Customer Form", text);
		screenshots.captureScreen(driver, "TC_02");
	} 
	
	
	@Test
	public void testdeleteCustLinks() throws Exception{
		
		XSSFSheet Sheet = read.excelReader(Constants.filepath, "Configuration");
		loginPage login = new loginPage(driver);
		login.setUserName(Sheet.getRow(1).getCell(2).getStringCellValue());
		login.setpswd(Sheet.getRow(1).getCell(3).getStringCellValue());
		login.clickLogin();
		//click Links on next page
		homePage homepage = new homePage(driver);
		homepage.deleteCustLink();
		String text = driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p")).getText();
		Assert.assertEquals("Delete Customer Form", text);
		screenshots.captureScreen(driver, "TC_03");
	} 
	
	@AfterMethod
	public void browserClose(){
		driver.quit();
		
	}

}
