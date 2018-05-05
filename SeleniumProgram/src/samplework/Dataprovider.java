package samplework;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class Dataprovider {

	@DataProvider
	public static Object[][] getLogin() throws RuntimeException, InvalidFormatException, IOException {
		Object[][] readdata = ExcelRead.getData(ExcelRead.path, ExcelRead.Sheet);
		return (readdata);
	}

}
