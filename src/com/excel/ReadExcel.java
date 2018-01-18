package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[]args) {
	
		//provide File Location
		File inputFile = new File("C://tools//projects//workspace//JavaTraining//SeleniumTrainingSession//src//com//excel//SampleExcel.xlsx");
		readXlsx(inputFile);
		
	}	
	@SuppressWarnings("deprecation")
	public static void readXlsx(File inputFile) {
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));
			
			XSSFSheet sheet = wb.getSheet("Employee Data");
			
			Row row;
			Cell cell;
			
           Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
            	row = rowIterator.next();
            	
            	//for each row, iterate through each columns
            	Iterator<Cell> cellIterator = row.cellIterator();
            	
            	while(cellIterator.hasNext()) {
            		cell = cellIterator.next();
            		
            		switch(cell.getCellType()) {            		
            		case Cell.CELL_TYPE_BOOLEAN:
            			System.out.println(cell.getBooleanCellValue());
            			break;
            		case Cell.CELL_TYPE_NUMERIC:
            			System.out.println(cell.getNumericCellValue());
            			break;
            		case Cell.CELL_TYPE_STRING:
            			System.out.println(cell.getStringCellValue());
            			break;
            		case Cell.CELL_TYPE_BLANK:
            			System.out.println("Null");
            			break;
            			
            		default:	
            			System.out.println(cell);
            	}
            }
		}	
		
	}catch(Exception e) {
		System.err.println("Exception :" +e.getMessage());
		}
	}
}