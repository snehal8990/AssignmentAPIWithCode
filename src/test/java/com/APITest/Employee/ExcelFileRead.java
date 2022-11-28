package com.APITest.Employee;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileRead {

	public static String readExcel(int rowNum,int colNum) throws Exception {
		// TODO Auto-generated method stub
		String pathOfFile = "./TestData.xlsx";
		File file=new File(pathOfFile);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook hwb = new XSSFWorkbook(fis);
		XSSFSheet Hsh = hwb.getSheet("Sheet1");
		XSSFRow hrow = Hsh.getRow(rowNum);
		return hrow.getCell(colNum).getStringCellValue();
		
	}

}
