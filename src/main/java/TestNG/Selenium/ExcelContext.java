package TestNG.Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelContext {
	public static List<String> getContextValue() throws IOException
	{
		FileInputStream f=new FileInputStream("D:\\Maven_Workspace\\ObsquraSelenium\\src\\main\\resources\\Context.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(f);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowSize=sheet.getLastRowNum()+1;
		List<String> list=new ArrayList<String>();
		for(int i=0;i<rowSize;i++)
		{
			String cellValue=sheet.getRow(i).getCell(0).getStringCellValue();
			list.add(cellValue);
			
		}
		return list;
	}


}
