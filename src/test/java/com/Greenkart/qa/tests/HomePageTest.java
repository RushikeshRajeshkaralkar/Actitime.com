package com.Greenkart.qa.tests;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Greenkart.qa.base.Base;
import com.Greenkart.qa.pages.HomePage;
import com.Greenkart.qa.util.TestUtil;

public class HomePageTest extends Base {
	HomePage homePage;

	SoftAssert soft_assert = new SoftAssert();

	public HomePageTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() {
		intilization();

	}

	@Test(priority = 3)
	public void logoValidate() {

		homePage = new HomePage();
		boolean logo = homePage.validate_Logo();
		soft_assert.assertEquals(logo, true, "Logo Not Display !! ");
		soft_assert.assertAll();

	}

	@Test(priority = 2)
	public void search_vegitable() {
		homePage = new HomePage();
		String vegitablename = pro.getProperty("vegitablename");

		homePage.searchVegitable(vegitablename);
		TestUtil.sleep(5000);

	}

	@Test(priority = 1)
	public void addToCartProduct() {
		homePage = new HomePage();
		String vegitablename = pro.getProperty("vegitablename");
		homePage.searchVegitable(vegitablename);
		TestUtil.sleep(5000);
		homePage.addToCartVegitable(vegitablename);
		TestUtil.sleep(5000);
	}

	@Test(priority = 0)
	public void add_Multipli_Vegitable_TO_Cart() {
		homePage = new HomePage();
		String vegitablename = pro.getProperty("vegitablename");
		homePage.searchVegitable(vegitablename);
		TestUtil.sleep(5000);
		homePage.add_Multiple_Product_To_Cart(vegitablename, 0);
		TestUtil.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
