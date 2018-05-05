package samplework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelWrite {
	public static org.apache.poi.ss.usermodel.Cell c;
	public static org.apache.poi.ss.usermodel.Sheet sh;
	public static String path = "E://PC_BACKUP//JijuFlderBackup//ExcelFile//acttime.xls";
	public static String Sheet = "Sheet1";
	public static File f;
	public static FileInputStream fis;
	public static FileOutputStream fio;
	public static Workbook wb;

	public static Object[][] GetData(String pathout, String Sheet)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		f = new File(path);
		fis = new FileInputStream(f);
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(Sheet);
		String[][] readdata = null;
		int Row = sh.getLastRowNum();
		Row r = sh.getRow(0);
		int column = r.getLastCellNum();
		readdata = new String[Row][column];
		int ci, cj;
		ci = 0;
		for (int i = 1; i <= Row; i++, ci++) {
			cj = 0;
			for (int j = 0; j < column; j++, cj++) {

				readdata[ci][cj] = getCellData(i, j);
			}
		}
		return readdata;
	}

	public static String getCellData(int RowNum, int ColNum) {
		c = sh.getRow(RowNum).getCell(ColNum);
		if (c == null || c.getCellType() == c.CELL_TYPE_BLANK) {
			return "";
		} else {
			String CellData = c.getStringCellValue();
			return CellData;
		}
	}

	}

