package testingPackage;


import java.io.IOException;

import library.UIoperations;
import library.excelReader;
import library.objectReader;

import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class loginGetvalues {

	WebDriver driver;
	
	@BeforeTest
	public void openBrowser(){
		String browser = "Chrome";
		
		if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();//launch firefox
		}else if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rj0844\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();//launch Chrome
		}else if (browser.equalsIgnoreCase("IE") ){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\rj0844\\Documents\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();//launch IE
		}	
		driver.get("http://www.gcrit.com/build3/index.php");
	}
	
	
	@Test
	public void loginTest() throws IOException {
		
		
		// TODO Auto-generated method stub
		//WebDriver driver = null;//create Webdriver object
		
		excelReader readexcel = new excelReader();
		objectReader readObject = new objectReader();
		UIoperations operate = new UIoperations(driver);
		
		XSSFSheet Sheet = readexcel.readExcel("C:\\Users\\rj0844\\workspace\\Selenium\\KeyWordDrivenFramework", "KeywordSheet.xlsx", "Executor_1");
		int rowCount = Sheet.getLastRowNum();
		System.out.println("value is"+rowCount);
		
		for (int i =2; i<rowCount; i++){
			String keyword = Sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(keyword);
			String objectType = Sheet.getRow(i).getCell(3).getStringCellValue();
			System.out.println(objectType);
			String objectname = Sheet.getRow(i).getCell(2).getStringCellValue();
			System.out.println(objectname);
			String value = Sheet.getRow(i).getCell(4).getStringCellValue();
			System.out.println(value);
			
			if (keyword.equalsIgnoreCase("CLICK")){
				operate.perform(readObject.getObjectRepository(), keyword, objectType, objectname, value);
			}else if (keyword.equalsIgnoreCase("SETTEXT")){
				operate.perform(readObject.getObjectRepository(), keyword, objectType, objectname, value);
			}else if (keyword.equalsIgnoreCase("GOTURL")){
				operate.perform(readObject.getObjectRepository(), keyword, objectType, objectname, value);
			} 
		}
		
	
		//driver.quit();
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.quit();
	}
		
		
}

