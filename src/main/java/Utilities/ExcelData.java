package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public String getExcelDataCellValue(int row, int col,String sheetName) throws IOException {
	File excelFile = new File(System.getProperty("user.dir")+"/Resources/excelData.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook excelWBook = new XSSFWorkbook(fis);
		int sheetCount = excelWBook.getNumberOfSheets();
		int sheetIndex=-1;
		for(int i = 0; i<sheetCount; i++)
		{
			if(excelWBook.getSheetName(i).equals(sheetName))
			{
				sheetIndex=i;
			}
		}	
		sheet = excelWBook.getSheetAt(sheetIndex);
		String cell =  sheet.getRow(row).getCell(col).toString();
		excelWBook.close();
		return cell;
	}
}
