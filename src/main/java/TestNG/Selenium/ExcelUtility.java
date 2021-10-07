package TestNG.Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static List<String> getStringValue() throws IOException {
		FileInputStream	f = new FileInputStream(System.getProperty("D:\\Maven_Workspace\\ObsquraSelenium\\src\\main\\resources\\Company.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(f);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowNum = sheet.getLastRowNum() + 1;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < rowNum; i++) {
			String cellValue = sheet.getRow(i).getCell(0).getStringCellValue();
			list.add(cellValue);
		}
		return list;
	}
	
	}


