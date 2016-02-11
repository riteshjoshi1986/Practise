package library;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UIoperations {
	
	WebDriver driver;
	public UIoperations(WebDriver driver){
		this.driver = driver;		
	}
	
	public void perform(Properties p, String operation, String objectType, String objectname, String value){
		
		try {
			switch (operation){
				case "GOTOURL":
					//goto the url
					driver.get(value);
					break;
				case "SETTEXT":
					driver.findElement(this.getObject(p, objectType, objectname)).sendKeys(value);
					break;
				case "CLICK":
					driver.findElement(this.getObject(p, objectType, objectname)).click();
					break;		
				case "SELECT" :
					Select drpdwn = new Select(driver.findElement(this.getObject(p, objectType, objectname)));
					drpdwn.selectByVisibleText(value);
					break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong"+e.getLocalizedMessage());
		}	
		
	}
	
	
	private By getObject(Properties p, String objectType, String objectname) throws Exception{
		//Find by XPATH
		if (objectType.equalsIgnoreCase("XPATH")){
			return By.xpath(p.getProperty(objectname));
		}
		//Find by ID
		else if (objectType.equalsIgnoreCase("ID")){
			return By.id(p.getProperty(objectname));
		}
		//Find by NAME
		else if (objectType.equalsIgnoreCase("NAME")){
			return By.name(p.getProperty(objectname));
		}
		//Find by CSS
		else if (objectType.equalsIgnoreCase("CSS")){
			return By.cssSelector(p.getProperty(objectname));
		}
		//find by link
        else if(objectType.equalsIgnoreCase("LINK")){
             
            return By.linkText(p.getProperty(objectname));
             
        }
        //find by partial link
        else if(objectType.equalsIgnoreCase("PARTIALLINK")){
             
            return By.partialLinkText(p.getProperty(objectname));
             
        }else
        {
            throw new Exception("Wrong object type");
        }
	}
	
}
