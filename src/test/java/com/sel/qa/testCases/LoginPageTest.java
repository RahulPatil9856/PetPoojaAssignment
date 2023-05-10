package com.sel.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.sel.qa.base.TestBase;
import com.sel.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;

	public static void main(String[] args) {
		LoginPageTest te = new LoginPageTest();
		te.setUp();
		te.loginPageTitleTest();

	}

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		ExtentTest test1 = extent.createTest("TC1_Demo");

		String title1 = loginPage.Order();
		System.out.println(title1);
		Assert.assertEquals(title1, "My web site");
	}

	@Test(priority = 2, enabled=false)
	public void Bookmark() throws InterruptedException {
		ExtentTest test5 = extent.createTest("TC5_Demo");
		String title1 = loginPage.bookmarksite();
	}
//	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
