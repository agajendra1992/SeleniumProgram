package samplework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

	public class SampleAction {
	public static WebDriver driver;

	public Actions getAction() {
		Actions action = new Actions(driver);
		return action;
	}

	public Select getSelect() {
		Select select = new Select(driver.findElement(By.id("")));
		return select;
	}

}
