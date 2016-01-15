package testingPackage;

//import java.io.IOException;

import library.UIoperations;
import library.Utility;
import library.excelReader;
import library.objectReader;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class createAccount {
    
	WebDriver driver = null;
	@BeforeMethod
			public void launchBrowser()
			{
				String browser = "Chrome";
		
				if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();//launch firefox
				}else if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();//launch Chrome
				}else if (browser.equalsIgnoreCase("IE") ){
					System.setProperty("webdriver.ie.driver", "C:\\Users\\User1\\Documents\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();//launch IE
				}	
				driver.get("http://www.gcrit.com/build3/index.php");
				driver.manage().window().maximize();
			}
	
			@Test
			public void account() throws Exception{
		
		
				Logger logs = Logger.getLogger("createAccount");
				PropertyConfigurator.configure("log4j.properties");
		
		
				excelReader readexcel = new excelReader();
				objectReader readObject = new objectReader();
				UIoperations operate = new UIoperations(driver);
				Utility scr = new Utility();
				//String path = "C:\\Ritesh\\KeyWordDrivenFramework\\KeywordSheet.xlsx";
				logs.info("Objects creation complete");
		
		
				XSSFSheet Sheet = readexcel.readExcel("C:\\Ritesh\\KeyWordDrivenFramework\\", "KeywordSheet.xlsx", "Executor_2");
				logs.info("Keyword file read complete");
				int rowCount = Sheet.getLastRowNum();
				System.out.println("value is"+rowCount);
			
				for (int i =1; i<=rowCount; i++){
					logs.info("Inside the loop");
					String keyword = Sheet.getRow(i).getCell(2).getStringCellValue();
					System.out.println(keyword);
				String objectType = Sheet.getRow(i).getCell(4).getStringCellValue();
				System.out.println(objectType);
				String objectname = Sheet.getRow(i).getCell(3).getStringCellValue();
				System.out.println(objectname);
				String value = Sheet.getRow(i).getCell(5).getStringCellValue();
				System.out.println(value);
				String scrname = Sheet.getRow(i).getCell(6).getStringCellValue();
				System.out.println(scrname);
			
				if (keyword.equalsIgnoreCase("CLICK")){
				operate.perform(readObject.getObjectRepository(), keyword, objectType, objectname, value);
				scr.captureScreenShot(driver, scrname);
				logs.info("CLICK operation complete");
				//readexcel.writeExcel("Pass", i, 7, path);
				}else if (keyword.equalsIgnoreCase("SETTEXT")){
				operate.perform(readObject.getObjectRepository(), keyword, objectType, objectname, value);
				scr.captureScreenShot(driver, scrname);
				logs.info("SETTEXT operation complete");
				}else if (keyword.equalsIgnoreCase("GOTURL")){
				operate.perform(readObject.getObjectRepository(), keyword, objectType, objectname, value);
				scr.captureScreenShot(driver, scrname);
				logs.info("GOTOURL operation complete");
				} else if (keyword.equalsIgnoreCase("SELECT")){
				operate.perform(readObject.getObjectRepository(), keyword, objectType, objectname, value);
				scr.captureScreenShot(driver, scrname);
				logs.info("SELECT operation complete");
				} 
				}
				String confirmation_text = driver.findElement(By.xpath(".//*[@id='bodyContent']/h1")).getText();
				Assert.assertEquals(confirmation_text, "Your Account Has Been Created!");
		
				//if (confirmation_text.equalsIgnoreCase("Your Account Has Been Created!"))
					
					
	}
			

			@AfterMethod
			public void closeBrowser(){
				driver.quit();
			}
	
	
	
	
}
