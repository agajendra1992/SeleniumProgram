package samplework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadSample {

	public static WebDriver driver;

	@BeforeTest
	public void LaucnhApp() {
		System.setProperty("webdriver.chrome.driver", "E://PC_BACKUP//Jar Access//chromedriver.exe");
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// driver.get("http://store.demoqa.com/");
		driver.get("http://toolsqa.com/automation-practice-form/");
	}

	@Test
	public void getUploadFile() throws AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("photo")).click();
		StringSelection strSel = new StringSelection("E:\\PC_BACKUP\\JijuFlderBackup\\ExcelFile\\testlist.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
		Robot robot = new Robot();
		robot.setAutoDelay(10);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
