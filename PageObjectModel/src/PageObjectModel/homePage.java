package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {

	WebDriver driver;
	By mgrLink = By.xpath("html/body/div[2]/div/ul/li[1]/a");
	By newCust = By.xpath("html/body/div[2]/div/ul/li[2]/a");
	By editCust = By.xpath("html/body/div[2]/div/ul/li[3]/a");
	By deleteCust = By.xpath("html/body/div[2]/div/ul/li[4]/a");
	By newAcc = By.xpath("html/body/div[2]/div/ul/li[5]/a");
	By editAcc = By.xpath("html/body/div[2]/div/ul/li[6]/a");
	By deleteAcc = By.xpath("html/body/div[2]/div/ul/li[7]/a");
	By deposit = By.xpath("html/body/div[2]/div/ul/li[8]/a");
	By withdrawal = By.xpath("html/body/div[2]/div/ul/li[9]/a");
	By fundTransfer = By.xpath("html/body/div[2]/div/ul/li[10]/a");
	By chgpswd = By.xpath("html/body/div[2]/div/ul/li[11]/a");
	By balancetrns = By.xpath("html/body/div[2]/div/ul/li[12]/a");
	By miniState = By.xpath("html/body/div[2]/div/ul/li[13]/a");
	By CustState = By.xpath("html/body/div[2]/div/ul/li[14]/a");
	By logout = By.xpath("html/body/div[2]/div/ul/li[15]/a");

	public homePage (WebDriver driver){
		this.driver= driver;
	}
	
	public void mgrLink() {
		driver.findElement(mgrLink).click();
	}

	public void newCustLink() {
		driver.findElement(newCust).click();
	}
	
	public void editCustLink() {
		driver.findElement(editCust).click();
	}
	public void deleteCustLink() {
		driver.findElement(deleteCust).click();
	}
	public void newAccLink() {
		driver.findElement(newAcc).click();
	}
	public void editAccLink() {
		driver.findElement(editAcc).click();
	}
	public void deleteAccLink() {
		driver.findElement(deleteAcc).click();
	}
	public void depositLink() {
		driver.findElement(deposit).click();
	}
	public void withdrawalLink() {
		driver.findElement(withdrawal).click();
	}
	
	public void fundTransferLink() {
		driver.findElement(fundTransfer).click();
	}
	public void chgpswdLink() {
		driver.findElement(chgpswd).click();
	}
	public void balancetrnsLink() {
		driver.findElement(balancetrns).click();
	}
	public void miniStateLink() {
		driver.findElement(miniState).click();
	}
	public void CustStateLink() {
		driver.findElement(CustState).click();
	}
	public void logoutLink() {
		driver.findElement(logout).click();
	}
}
