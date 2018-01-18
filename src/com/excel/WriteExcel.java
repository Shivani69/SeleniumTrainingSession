package com.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteExcel {
	public static void main(String[]args) {
		//blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Employee Data");
		
		//This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]> ();
		data.put("1", new Object[] {"ID", "Name", "Company"});
		data.put("2", new Object[] {1, "Anshul Chauhan", "Kronos inc"});
		data.put("3", new Object[] {2, "Shilpi Thakur","Expedia inc"});
		data.put("4", new Object[] {3, "Rohit Maurya", "Amdocs"});
		data.put("5", new Object[] {4, "Nishi Rajpoot","AIIMS"});
		data.put("6", new Object[] {5, "RaviRao Sharman","Adobe India"});
		
		//iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for(String key: keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr =data.get(key);
			int cellnum = 0;
			for (Object obj :objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String)obj); 
				else if (obj instanceof Integer)
					 cell.setCellValue((Integer)obj);
			}
		}
		try {
			//Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File ("C://tools//projects//workspace//JavaTraining//SeleniumTrainingSession//src//com//excel//SampleExcel.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("SampleExcel.xlsx written successfully on disk.");
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
