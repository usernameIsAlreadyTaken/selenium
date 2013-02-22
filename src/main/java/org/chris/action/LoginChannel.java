package org.chris.action;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginChannel extends Thread {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public void run() {
		driver = new FirefoxDriver();
		baseUrl = "http://www.wsi.com.cn/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.wsi.com.cn/channelwse/");
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("sh1.17190.cn");
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("02230");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("Image2")).click();
		String crul = driver.getCurrentUrl();
		System.out.println("current url: " + crul);
		for(int i=0;i<3;i++){
			driver.get(crul);
		}
		//System.out.println("page source: " + driver.getPageSource());

		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	// private boolean isElementPresent(By by) {
	// try {
	// driver.findElement(by);
	// return true;
	// } catch (NoSuchElementException e) {
	// return false;
	// }
	// }

	// private String closeAlertAndGetItsText() {
	// try {
	// Alert alert = driver.switchTo().alert();
	// if (acceptNextAlert) {
	// alert.accept();
	// } else {
	// alert.dismiss();
	// }
	// return alert.getText();
	// } finally {
	// acceptNextAlert = true;
	// }
	// }

}
