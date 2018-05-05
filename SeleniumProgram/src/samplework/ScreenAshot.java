package samplework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenAshot {
	public static String ImageName = "TestImage";
	public static WebDriver driver;

	@BeforeTest
	public void launchApp() {
		System.setProperty("webdriver.chrome.driver", "E://PC_BACKUP//Jar Access//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-form/");

	}

	@Test
	public void getScreenshot(String ImageN) throws IOException {
		File Image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String ImageLocation = "E://PC_BACKUP//Jar Access//Screen";
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		String ActualImage = ImageLocation + ScreenAshot.ImageName + "_" + format.format(calender.getTime()) + ".jpg";
		FileUtils.copyFile(Image, new File(ActualImage));

	}
}
