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

		loginPage.Order(); // This Method Will Call Login method

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", AddMalabar); // It will click on Malabar Parata Add Button

		Thread.sleep(2000);
		Increase.click(); // It will Increase 1 Value 1+1= 2
		Thread.sleep(2000);
		String AmountofMalabar1 = Amount.getText();
		System.out.println(AmountofMalabar1);

		Decrease.click(); // It will Decrease 1 Value 2-1=1
		String AmountofMalabar = Amount.getText();
		System.out.println(AmountofMalabar);

		Thread.sleep(2000);
		Pizzas.click(); // It will Click On Pizza & Sizes button

		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(AddforVegPizza).click().perform(); // It will add Vege Garden Loaded Piza
		Thread.sleep(3000);

		action.moveToElement(Inch).click().perform(); // it Will Add 13 inch Pizza

		AddforInch.click(); // it Will Add 13 inch Pizza add Button

		Basket.click(); // It Will Click On Basket

		Thread.sleep(1000);
		String s = Keys.chord(Keys.CONTROL, "a");
		AddNo.sendKeys(s);
		AddNo.sendKeys(Keys.DELETE);
		AddNo.sendKeys("3"); // It will Add 3 Pizza

		Addmoreitm.click(); // It will Click On Add more Iteam
		// Thread.sleep(1000);
		AddApple.click(); // It will add 1 Apple
		Basket.click(); // Again It comes to Basket

		js.executeScript("arguments[0].value='Thanks for your order'", Notes); // It will Write Note

		Thread.sleep(2000);
		Checkout.click(); // It will Click On Checkout

		return AmountofMalabar;

	}

	public String Proceed() throws InterruptedException {

		this.addItem(); // It will call AddItem Button
		Thread.sleep(2000);

		Name.sendKeys("Rahul Patil"); // It will Send Name
		Mobileno.sendKeys("9638100056"); // Its Send Mobile No.

		Proceed.click(); // It will Proceed Further

		String totleamount = TotleAmount.getText(); // it will get Title amount

		return totleamount;
	}

}
