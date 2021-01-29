
package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritetoExcel { 

	public static void logData(String data, int i, int j) throws IOException {
		File file=new File("./fileUtilities/reports/dataLog.xlsx");  //Creation of the excel file
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("TestLog"); 
		//Entering data to the created sheet TestLog
		sheet.createRow(i).createCell(j).setCellValue("Result");  //
		sheet.getRow(i).createCell(j+1).setCellValue(data);
		/*sheet.createRow(i+1).createCell(j).setCellValue("Result");
		sheet.getRow(i+1).createCell(j+1).setCellValue("Does not meet my requirements");*/
		FileOutputStream fout=new FileOutputStream(file);  //Instatiating fileoutputstream class for writting inside the excel sheet.
		wb.write(fout);
		wb.close();
	}
	
	public static void writeToExcel(Hashtable<String, String> data, String fileName) throws IOException {

		File file=new File("./reports/"+fileName+".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Output");

		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			String value = data.get(key);
			int cellnum = 0;
			
			Cell cell1 = row.createCell(cellnum++);
			sheet.autoSizeColumn(cellnum);
			cell1.setCellValue(key);
			 
			Cell cell2 = row.createCell(cellnum++);
			sheet.autoSizeColumn(cellnum);
			cell2.setCellValue(value);

		}

		FileOutputStream fout=new FileOutputStream(file);  //Instatiating fileoutputstream class for writting inside the excel sheet.
		workbook.write(fout);
		fout.close();

	}
}
