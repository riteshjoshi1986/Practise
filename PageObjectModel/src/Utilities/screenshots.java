/**
 * 
 */
package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author rj0844
 * This class is created to capture and save screenshots during test case execution
 */
public class screenshots {

	WebDriver driver;
	public static void captureScreen(WebDriver driver, String scrName ){
		try {
		TakesScreenshot capture = (TakesScreenshot)driver;
		File scr = capture.getScreenshotAs(OutputType.FILE);
		
			FileUtils.copyFile(scr, new File("./Screenshots/"+scrName+".png") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Captured Screenshot!!!");
	}
	
}
