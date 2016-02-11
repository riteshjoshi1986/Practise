/**
 * 
 */
package PageObjectModel;

import java.util.Properties;

import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

//import Utilities.Constants;
import Utilities.ObjectRepositoryReader;

/**
 * @author rj0844
 *
 */
public class loginPage {
	ObjectRepositoryReader obj = new ObjectRepositoryReader();
	Properties p;  
	WebDriver driver;
	By usrid = By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input");
	By pswd = By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input");
	By loginbtn = By.xpath("html/body/form/table/tbody/tr[3]/td[2]/input[1]");
	By resetbtn = By.xpath("html/body/form/table/tbody/tr[3]/td[2]/input[2]");
	
	public loginPage(WebDriver driver){
		this.driver = driver;
		}
	
	public void setUserName(String username) throws Exception{
	
		driver.findElement(usrid).sendKeys(username);
	}
	public void setpswd(String password){
		driver.findElement(pswd).sendKeys(password);
	}
	public void clickLogin(){
		driver.findElement(loginbtn).click();
	}
	public void clickReset(){
		driver.findElement(resetbtn).click();
	}

}
