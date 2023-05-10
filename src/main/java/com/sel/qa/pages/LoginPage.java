package com.sel.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sel.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory-OR
	@FindBy(xpath = "//label[normalize-space()='Pickup']")
	WebElement Pickup;

	@FindBy(xpath = "//button[@id='ordernowbtnadvance']")
	WebElement Orderforlatter;

	@FindBy(xpath = "//select[@id='future_day']")
	WebElement Day;

	@FindBy(xpath = "//select[@id='future_time']")
	WebElement Time;

	@FindBy(xpath = "//button[@id='ordernowbtnfinal']")
	WebElement Finalorder;

	@FindBy(xpath = "//button[@aria-label='Bookmark this page']")
	WebElement bookmark;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String Order() {
		Pickup.click();
		Orderforlatter.click();
		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='future_day']"))).click();

		Select dropdown = new Select(Day);
		dropdown.selectByVisibleText("Sunday (14th May, 23)");

		Select dropdown1 = new Select(Time);
		dropdown1.selectByVisibleText("03:00 PM");

		Finalorder.click();

		String title = driver.getTitle();
		return title;

	}

	public String bookmarksite() throws InterruptedException

	{
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("d").keyUp(Keys.CONTROL).build().perform();

		bookmark.click();

		WebElement nameField = driver.findElement(By.name("name"));
		nameField.sendKeys("blackknight");

		WebElement doneButton = driver.findElement(By.xpath("//button[text()='Done']"));
		doneButton.click();

		return null;

	}

}
