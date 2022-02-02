package com.athma.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;


import com.athma.qa.base.TestBase;

public class GeneralUtils extends TestBase 
{
	
	public static long common_wait = 30;
	static Workbook book;
	static Sheet sheet;
	public static String data_sheet = "";

	public GeneralUtils() throws IOException
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Object[][] getPatientdetails(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = null;
		try {
			
			fis  = new FileInputStream("C:\\Users\\339154\\Downloads\\NewPatients1.xlsx");
			System.out.println();
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
			
			
		} catch (InvalidFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i<  sheet.getLastRowNum();i++) 
		{
			 for(int j = 0; j < sheet.getRow(0).getLastCellNum();j++) 
			 {
				 data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				 
			 }
		
			
		}
		return data;
		
		
	}
	
	
	

}