package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;

import constant.FileConstant;

public class ExcelFileReader {
	public  static String username;
	public static String password;
	public static int totalRows,totalColumn;
	
 public ExcelFileReader() throws IOException {
	 	File file = new File(FileConstant.EXCELFILE_PATH);
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("loginData");
		 totalRows = sh.getLastRowNum() + 1;
		 totalColumn = sh.getRow(1).getLastCellNum();
		
		 username = sh.getRow(1).getCell(0).getStringCellValue();
		 password = sh.getRow(1).getCell(1).getStringCellValue();
		
}
	
	static List <String> list = new ArrayList <String>();
	
	public static void getLoginUsername() {
		list.add(username);
	}
	
	public static void getLoginPassword() {
		list.add(password);
	}
	

}
