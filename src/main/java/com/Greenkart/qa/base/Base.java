package com.Greenkart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Greenkart.qa.util.TestUtil;

public class Base {

	public static WebDriver driver;
	public static Properties pro;

	public Base() {

		pro = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:/Users/Rushikesh/Desktop/JavaByPatilJavaWorkBanch/GreenKart.com/src/main/java/com/Greenkart/qa/config/config.properties");
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void intilization() {
		String path = System.getProperty("user.dir");
		String browser = pro.getProperty("browser");
		String url = pro.getProperty("url");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "/driver/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdrievr.gecko.driver", path + "/drive/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", path + "/driver/MicroSoftDriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(url);

	}

}
