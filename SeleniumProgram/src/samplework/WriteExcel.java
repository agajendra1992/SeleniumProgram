package samplework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {
	public static void main(String[] args) throws InvalidFormatException, IOException{
	FileInputStream fis=new FileInputStream("E:\\PC_BACKUP\\JijuFlderBackup\\ExcelFile\\testlist.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("Input");
	Row row=sh.getRow(8);
	Cell cell=row.createCell(1);
	cell.setCellType(cell.CELL_TYPE_STRING);
	cell.setCellValue("Selenium");
	FileOutputStream fos=new FileOutputStream("E:\\PC_BACKUP\\JijuFlderBackup\\ExcelFile\\testlist.xlsx");
	wb.write(fos);
	fos.close();
	System.out.println("Excel File Written.");
	}
}
