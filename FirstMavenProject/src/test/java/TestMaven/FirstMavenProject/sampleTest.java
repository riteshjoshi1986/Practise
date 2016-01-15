package TestMaven.FirstMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class sampleTest {
	
	@Test
	public void launchBrowser(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://test1.absofttrainings.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
		
	}

}
