package org.qa.winApp_automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class Win_App_Automation {

	public static WindowsDriver driver= null;
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platform", "windows10");
		cap.setCapability("DeviceName", "DELL");
		
		try {
			driver= new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void openHelpAboutNotepad() {
		driver.findElementByName("Help").click();
		driver.findElementByName("About Notepad").click();
		driver.findElementByName("OK").click();
		}
	@Test(priority=2)
	public void sendTextTest() {
		driver.findElementByName("Text Editor").sendKeys("this is my notepad automation");
		driver.findElementByName("Text Editor").clear();
	}
	
	
}
