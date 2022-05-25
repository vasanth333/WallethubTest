package com.wallethub.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	

	public static  String exceldata(String testID,String columnvalue) throws IOException {
		int colindex=0;
	 	File classpathRoot = new File(System.getProperty("user.dir"));
	 	File app = new File(classpathRoot, "/Data/TestInputData.xlsx");
        FileInputStream fis=new FileInputStream(app);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		int noofrows=wb.getSheet("TestData").getLastRowNum();
		//System.out.println("Noof rows :"+noofrows);
		int noofcolumns=wb.getSheet("TestData").getRow(0).getLastCellNum();
		//System.out.println("No of columns : "+noofcolumns);
		for(int j=0;j<noofcolumns;j++) {
		if(wb.getSheet("TestData").getRow(0).getCell(j).getStringCellValue().equals(columnvalue)) {
		colindex=j;
		}
		}
		for(int i=0;i<=noofrows;i++) {
		if((wb.getSheet("TestData").getRow(i).getCell(0).getStringCellValue()).equals(testID)) {

		String colname=wb.getSheet("TestData").getRow(i).getCell(colindex).getStringCellValue();
		//System.out.println("Colname : "+colname);
		return colname;
		}
		}
		return null;
		}
}
