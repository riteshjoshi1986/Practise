package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {

	//WebDriver driver;
	
	public void captureScreenShot(WebDriver driver, String scrName) {
		
		try {
			TakesScreenshot capture = (TakesScreenshot)driver;

			File source = capture.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/"+scrName+".png") ); 
			System.out.println("Captured Screenshot!!!");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
