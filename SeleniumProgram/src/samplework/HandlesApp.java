package samplework;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlesApp {

	public static WebDriver driver;

	@BeforeTest
	public void getLaunch() {
		System.setProperty("webdriver.chrome.driver", "E://PC_BACKUP//Jar Access//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		String s1 = driver.getTitle();
		System.out.println(s1);

	}

	@Test
	public void getWindow() {
		String Handle1 = driver.getWindowHandle();
		System.out.println(Handle1);
		driver.findElement(By.id("button1")).click();
		Set<String> Handle2 = driver.getWindowHandles();
		
		for(String Handle3: Handle2) {
			System.out.println(Handle2);
			System.out.println(Handle3);
		}

	}

}
