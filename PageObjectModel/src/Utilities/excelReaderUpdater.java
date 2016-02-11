package Utilities;

import java.io.File;
import java.io.FileInputStream;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReaderUpdater {

	public XSSFSheet excelReader(String filepath, String Sheetname) throws Exception
	{
		File src = new File(filepath);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet Sheet = workbook.getSheet(Sheetname);
		workbook.close();
		return Sheet;
		
	}
	
	
	
}
