package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	public static Map<String,String> getExcelData(String fileName) throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/testinputs/" + fileName);
		XSSFWorkbook wb = new XSSFWorkbook(fis); 

		XSSFSheet sheet = wb.getSheetAt(0);
		System.out.println(sheet.getSheetName());

		Iterator<Row> rows = sheet.iterator();

		HashMap<String, String> map = new HashMap<String, String>();
		String key = null;
		String value = null;
		while (rows.hasNext()) {
			Row nextRow = rows.next(); 
			Iterator<Cell> cell = nextRow.cellIterator();
			key = nextRow.getCell(0).toString();
			value = nextRow.getCell(1).toString();
			map.put(key, value);
		}
		return map;

	}
}
