package com.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class WriteExcel1 {
	public static void main(String[]args) {
		//blank workbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//create a blank sheet
		HSSFSheet sheet = workbook.createSheet("Employee Data");
		
		//This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]> ();
		data.put("1", new Object[] {"firstname", "lastname", "address1", "address2","city","state","zipcode", "emailaddress"});
		data.put("2", new Object[] {1, "Tom","Peter", "12 new street","Sunnyvale","California","01181","test1.email.com"});
		data.put("3", new Object[] {2, "Reshma","S", "13 new street","Sunnyvale","California","01181","test2.email.com"});
		data.put("4", new Object[] {1, "Ashish","D", "14 new street","Sunnyvale","California","01181","test3.email.com"});
		data.put("5", new Object[] {1, "Amreen","T", "15 new street","Sunnyvale","California","01181","test4.email.com"});
		data.put("6", new Object[] {1, "Sindhu","D", "16 new street","Sunnyvale","California","01181","test5.email.com"});
		
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
			FileOutputStream out = new FileOutputStream(new File ("C://tools//projects//workspace//JavaTraining//SeleniumTrainingSession//src//com//excel//HalfEbayTestData.xls"));
			workbook.write(out);
			out.close();
			System.out.println("HalfEbayTestData.xls written successfully on disk.");
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
