package com.sel.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
  public  ExtentReports extent ;
  public  ExtentSparkReporter sparkreporter ;
    
   @BeforeSuite
   public void Beforesuite()
   {
	   extent = new ExtentReports();
	    sparkreporter = new ExtentSparkReporter("Report.html");
	   extent.attachReporter(sparkreporter);    
   }
    @AfterSuite
    public void Aftersuite()
    {
       extent.flush();
    }
	
	
   
	public TestBase()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/sel/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initilization()
	{
		String browserName=prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    WebDriverManager.chromedriver().setup();
	      driver = new ChromeDriver(options);
		}else if(browserName.equalsIgnoreCase("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// wait=new WebDriverWait(driver,10);
		
		
		driver.get(prop.getProperty("url"));
	}

}
