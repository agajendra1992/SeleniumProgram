package ExcelTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelWrite1 {

	public static File f;
	public static FileInputStream fis;
	public static org.apache.poi.ss.usermodel.Cell c;
	public static org.apache.poi.ss.usermodel.Sheet sh;
	public static String path = "E://PC_BACKUP//JijuFlderBackup//ExcelFile//Book1.xls";
	public static String SheetN = "Sheet1";
	public static Workbook wb;

	public void getFile(String path) throws EncryptedDocumentException, InvalidFormatException, IOException {
		f = new File(path);
		fis = new FileInputStream(f);
		 wb = WorkbookFactory.create(fis);
	}

	public boolean getWrite(String Sheet, String columnName, int RowNum, String Value) throws IOException {

		int col_num = 1;
		sh = wb.getSheet(SheetN);
		Row row = sh.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(columnName)) {
				col_num = i;

			}
		}

		sh.autoSizeColumn(col_num);
		row = sh.getRow(RowNum - 1);
		if(row==null) {
			row = sh.createRow(RowNum-1);
			
		}
	if(c == null) {
		c = row.createCell(col_num);
		c.setCellValue(Value);
	
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
return true;
	}
	@Test
public void getalldata() throws EncryptedDocumentException, InvalidFormatException, IOException {
	ExcelWrite1 ex = new ExcelWrite1();
	ex.getFile(ExcelWrite1.path);
	ex.getWrite(ex.SheetN, "result", 2, "Fail");
}
}
