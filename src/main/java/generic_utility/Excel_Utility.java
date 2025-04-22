package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * this method is used to fetech the data from excel sheet
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 * @author anshul
	 */
	
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String excelData = cell.getStringCellValue();
		return excelData;
	}
	
	public String getExcelDataFormatter(String sheetname,int rownum,int cellnum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheetname).getRow(rownum).getCell(cellnum));
		return data;
	}
	
	public Object[][] readMultipleData(String sheetname) throws Throwable{
		FileInputStream fis=new FileInputStream("src/test/resources/exceldata.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet(sheetname);
		int lastRow = sheet.getLastRowNum()+1;//The getLastRowNum() method in Apache POI's Sheet class returns the index of the last row in the Excel sheet, not the total number of rows. The value it returns is zero-based, meaning the first row has an index of 0, the second row has an index of 1, and so on.
		
		System.out.println(lastRow);
		int lastCell=sheet.getRow(0).getLastCellNum();
		System.out.println(lastCell);
		
		Object[][] obj=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
		
		
	}
}
