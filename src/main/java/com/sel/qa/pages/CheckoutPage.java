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

	// div[text()='Your order has been Created.']

	@FindBy(xpath = "//div[text()='Your order has been Created.']")
	WebElement Ordersuceess;

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	public String CheckoutSuccees() throws InterruptedException {
		Contactpage1 = new OrderPage();
		Contactpage1.Proceed();
		Thread.sleep(1000);

		Continuetocheckout.click();

		Thread.sleep(1000);

		String ordercreated = Ordersuceess.getText();

		return ordercreated;
	}

}