package com.sel.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.sel.qa.base.TestBase;
import com.sel.qa.pages.CheckoutPage;

public class CheckoutPageTest extends TestBase {

	CheckoutPage Checkout;

	public static void main(String[] args) throws InterruptedException {
		CheckoutPageTest te1 = new CheckoutPageTest();

		te1.setUp2();
		te1.successfullyorder();

	}

	public CheckoutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp2() {
		initilization();
		Checkout = new CheckoutPage();

	}

	@Test(priority = 1)
	public void successfullyorder() throws InterruptedException {
		ExtentTest test4 = extent.createTest("TC4_Demo");
		String ordercreated = Checkout.CheckoutSuccees();
		System.out.println(ordercreated);

		Assert.assertEquals(ordercreated, "Your order has been Created.");
   //+++++++++++++++++++++++++++++++
	}
}
