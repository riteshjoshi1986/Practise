package library;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
	
	

	public XSSFSheet readExcel(String filepath, String filename, String sheetname) throws IOException{
		
		File source = new File(filepath+"\\"+filename);
		FileInputStream fis = new FileInputStream(source);
		XSSFWorkbook Workbook = new XSSFWorkbook(fis);
		XSSFSheet Sheet = Workbook.getSheet(sheetname);
		Workbook.close();
		return Sheet;
		}
	
	/*public void writeExcel(String Result, int row, int cell, String path) throws Exception
	{
	Sheet.getRow(row).createCell(cell).setCellValue(Result);	
	FileOutputStream fout = new FileOutputStream(path);
	Workbook.write(fout);
	}*/
}
