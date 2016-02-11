package TestCases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utilities.Constants;
import Utilities.excelReaderUpdater;

public class NewTest {
  
	WebDriver driver;
	excelReaderUpdater read = new excelReaderUpdater();
	
	@Test
  public void f() throws Exception {
  XSSFSheet Sheet = read.excelReader(Constants.filepath, Constants.Sheetname);
	int rowCount = Sheet.getLastRowNum();
	System.out.println(rowCount);
	System.out.println(Sheet.getRow(1).getCell(0).getStringCellValue());
	
	}
}
