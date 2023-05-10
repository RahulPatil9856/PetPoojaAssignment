package com.sel.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.sel.qa.base.TestBase;
import com.sel.qa.pages.LoginPage;
import com.sel.qa.pages.OrderPage;

public class OrderPageTest extends TestBase {
	OrderPage Orderpage1;

	public static void main(String[] args) throws InterruptedException {
		OrderPageTest te = new OrderPageTest();
		te.setUp1();
		te.Amountvalidate();
		te.dateandtimevalidate();

	}

	public OrderPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp1() {
		initilization();
		Orderpage1 = new OrderPage();

	}

	@Test(priority = 1)
	public void Amountvalidate() throws InterruptedException {
		ExtentTest test2 = extent.createTest("TC2_Demo");

		String AmountofMalabar = Orderpage1.addItem();

		Assert.assertEquals(AmountofMalabar, "Rs60.00 Rs54.00");

	}

	@Test(priority = 2, dependsOnMethods = "Amountvalidate")
	public void dateandtimevalidate() throws InterruptedException {
		ExtentTest test3 = extent.createTest("TC3_Demo");

		String totleamount = Orderpage1.Proceed();
		System.out.println(totleamount);

		Assert.assertEquals(totleamount, "781.20");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
