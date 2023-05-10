package com.sel.qa.pages;

import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sel.qa.base.TestBase;

public class OrderPage extends TestBase {
	public String AmountofMalabar;

	LoginPage loginPage = new LoginPage();

	@FindBy(xpath = "//a//p[text()='Pizzas & Sides']")
	WebElement Pizzas;

	@FindBy(xpath = "//li[@class='foodmenu grid-item bg-white z-depth-1 d-flex FIT_2785644']//button[@class='btn btn-primary btn-sm waves-effect waves-light colorcodeclass additem colorcodeclass']")
	WebElement AddMalabar;

	@FindBy(xpath = "(//div[@class='fa fa-sort-up'])[2]")
	WebElement Increase;

	@FindBy(xpath = "(//div[@class='fa fa-sort-down'])[2]")
	WebElement Decrease;

	@FindBy(xpath = "(//span[@class='foodpric display-block mr-1'])[2]")
	WebElement Amount;

	@FindBy(xpath = "//button[@data-id='IT_1242510053']")
	WebElement AddforVegPizza;

	@FindBy(xpath = "//input[@data-id='1242510057']")
	WebElement Inch;

	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary colorcodeclass  model-dxtop-btn submitbtnform']")
	WebElement AddforInch;

	@FindBy(xpath = "//i[@class='fa fa-shopping-bag fa-2x']")
	WebElement Basket;

	@FindBy(xpath = "//input[@data-id='1242510053']")
	WebElement AddNo;

	@FindBy(xpath = "//div[@class='suggestionNots']//textarea[@id='cart_special_notes']")
	WebElement Notes;

	@FindBy(xpath = "//p[@aria-label='Close']")
	WebElement Addmoreitm;

	@FindBy(xpath = "//li[@class='foodmenu grid-item bg-white z-depth-1 d-flex IT_1235299584']//button[@class='btn btn-primary btn-sm waves-effect waves-light colorcodeclass additem colorcodeclass'][normalize-space()='Add']")
	WebElement AddApple;

	@FindBy(xpath = "//div[@class='cartFot']/child::div/span")
	WebElement Checkout;

	@FindBy(xpath = "//input[@id='checkout_user_name']")
	WebElement Name;

	@FindBy(xpath = "//input[@name='mobile']")
	WebElement Mobileno;

	@FindBy(xpath = "//span[text()='Proceed Further']")
	WebElement Proceed;

	@FindBy(xpath = "//span[@class='total_amount']")
	WebElement TotleAmount;

	public OrderPage() {
		PageFactory.initElements(driver, this);
	}

	public String addItem() throws InterruptedException

	{

		loginPage.Order();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", AddMalabar);

		Thread.sleep(2000);
		Increase.click();
		Thread.sleep(2000);
		String AmountofMalabar1 = Amount.getText();
		System.out.println(AmountofMalabar1);

		Decrease.click();
		String AmountofMalabar = Amount.getText();
		System.out.println(AmountofMalabar);

		Thread.sleep(2000);
		Pizzas.click();

		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(AddforVegPizza).click().perform();
		Thread.sleep(3000);

		action.moveToElement(Inch).click().perform();

		AddforInch.click();

		Basket.click();

		Thread.sleep(1000);
		String s = Keys.chord(Keys.CONTROL, "a");
		AddNo.sendKeys(s);
		AddNo.sendKeys(Keys.DELETE);
		AddNo.sendKeys("3");

		Addmoreitm.click();
		//Thread.sleep(1000);
		AddApple.click();
		Basket.click();

		js.executeScript("arguments[0].value='Thanks for your order'", Notes);

		Thread.sleep(2000);
		Checkout.click();

		return AmountofMalabar;

	}

	public String Proceed() throws InterruptedException {

		this.addItem();
		Thread.sleep(2000);

		Name.sendKeys("Rahul Patil");
		Mobileno.sendKeys("9638100056");

		Proceed.click();

		String totleamount = TotleAmount.getText();

		return totleamount;
	}

}
