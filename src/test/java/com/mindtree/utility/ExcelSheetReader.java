package com.mindtree.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetReader {
	public static ArrayList<String> getData(String testcaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				"./TestData/Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);// to access excel sheet

		int sheets = workbook.getNumberOfSheets(); // to get no. of sheets

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i); // to access particular sheet
				Iterator<Row> rows = sheet.iterator(); // to access all rows
				Row firstrow = rows.next();
				Iterator<Cell> cells = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (cells.hasNext()) // to find column no.
				{
					Cell value = cells.next();

					if (value.getStringCellValue().equalsIgnoreCase(testcaseName)) {
						column = k;
					}
					k++;

				}
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						Cell c = cv.next();
						
						while (cv.hasNext()) {
							
							c = cv.next();
							a.add(c.getStringCellValue());
							
						}

					}
				}
			}
		}
		return a;
	}

}
