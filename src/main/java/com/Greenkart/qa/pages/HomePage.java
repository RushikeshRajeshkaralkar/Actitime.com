package com.Greenkart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Greenkart.qa.base.Base;

public class HomePage extends Base {

	public HomePage() {

		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[contains(@class,'brand ')]")
	WebElement greenkart_logo;

	@FindBy(xpath = "//input[contains(@class,'search')]")
	WebElement txt_vegitable_search;

	public boolean validate_Logo() {
		return greenkart_logo.isDisplayed();

	}

	public void searchVegitable(String vegitablename) {

		boolean txt_search = txt_vegitable_search.isDisplayed();
		if (txt_search) {

			txt_vegitable_search.sendKeys(vegitablename);

		} else {
			System.out.println("search filed not display !! ");
		}

	}

	public void addToCartVegitable(String vegitablename) {
		boolean txt_search = txt_vegitable_search.isDisplayed();
		if (txt_search) {

			String AddCartXpath = "//h4[contains(text(),'" + vegitablename
					+ "')]/parent::div/div[@class='product-action']//button[text()='ADD TO CART']";

			driver.findElement(By.xpath(AddCartXpath)).click();

		} else {
			System.out.println("search filed not display !! ");
		}

	}

	public void add_Multiple_Product_To_Cart(String vegitablename, int Quantity)

	{
		String AddCartXpath = "//h4[contains(text(),'" + vegitablename
				+ "')]/parent::div/div[@class='product-action']//button[text()='ADD TO CART']";
		String incrementbutton = "//h4[contains(text(),'" + vegitablename
				+ "')]/parent::div/div[@class='stepper-input']//a[@class='increment']";

		boolean add_to_cart_button = driver.findElement(By.xpath(AddCartXpath)).isDisplayed();
		boolean incermentbuttondisplay = driver.findElement(By.xpath(incrementbutton)).isDisplayed();
		if (incermentbuttondisplay) {

			for (int unit = 1; unit <= Quantity; unit++) {
				driver.findElement(By.xpath(incrementbutton)).click();
			}

		}

		if (add_to_cart_button) {
			driver.findElement(By.xpath(AddCartXpath)).click();
		}

	}

}
