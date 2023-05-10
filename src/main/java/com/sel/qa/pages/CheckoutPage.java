package com.sel.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sel.qa.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutPage extends TestBase {

	OrderPage Contactpage1;

	@FindBy(xpath = "(//button[text()='Continue to checkout'])[2]")
	WebElement Continuetocheckout;

	@FindBy(xpath = "//div[text()='Your order has been Created.']")
	WebElement Ordersuceess;

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	public String CheckoutSuccees() throws InterruptedException {
		Contactpage1 = new OrderPage();
		Contactpage1.Proceed(); // It will Proceed Method
		Thread.sleep(1000);

		Continuetocheckout.click(); // It will Click on Continue to Checkout

		Thread.sleep(1000);

		String ordercreated = Ordersuceess.getText(); // It will Get Success Massage

		return ordercreated;
	}

}