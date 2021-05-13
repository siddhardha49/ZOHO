package com.apps.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.apps.utilities.ExcelReader;
import com.apps.utilities.ExtentManager;
import com.apps.utilities.TestUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	
	public  static WebDriver driver;
	public static TopMenu topMenu;
	
	/*
	 * Logs
	 * Property files-or,config
	 * ExtentReports
	 * Excel
	 * ReportNG
	 * Jenkins
	 * implicit wait
	 * 
	 * 
	 * 
	 * 
	 */

	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = LogManager.getLogger(Page.class);
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\app\\excel\\Data.xlsx");
	public ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser; 
	
	public Page() {
		
		if(driver==null) {
			
			try {

				fis = new FileInputStream(System.getProperty("user.dir")+
						"\\src\\test\\resources\\com\\app\\properties\\config.properties");
				log.info("properties file Input stream object created");
				System.out.println("properties file Input stream object created");
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			try {
				config.load(fis);

				log.info("loaded the config properties file");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(System.getProperty("user.dir")+
						"\\src\\test\\resources\\com\\app\\properties\\or.properties");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				or.load(fis);

				log.info("loaded the or properties file");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//jenkin browser filter config
		/*	if(System.getenv("browser")!=null && ! System.getenv("browser").isEmpty()) {
				browser=System.getenv("browser");
			}else {
				browser=config.getProperty("browser");
			}
			config.setProperty("browser", browser);*/
			
			if (config.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				

				log.info("chrome browser launched");

		
			Map<String, Object> prefs = new HashMap<String, Object>();
			
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
		
	
		driver=new ChromeDriver(options);
		} else if (config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

			log.info("firefox browser launched");

		} else if (config.getProperty("browser").equals("ie")) {
			WebDriverManager.iedriver().setup();

			driver = new InternetExplorerDriver();
			log.info("IE browser launched");

		}
System.out.println("came here");
System.out.println();
			driver.get(config.getProperty("testSiteUrl"));
			log.info("loaded URL");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	

		
	
		topMenu=new TopMenu(driver);
		
		
		}
		
		
	}
	
public static void verifyEquals(String expected,String actual) throws IOException {
		
		try {
			
			Assert.assertEquals("abc", "xyz");
			
		}catch(Throwable t) {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			TestUtil.captureScreenshot();
			Reporter.log("<br>"+"Verification Failure : "+t.getMessage()+"<br>");
			Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+"><img scr="+TestUtil.screenShotName+" height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			
			//Extent Reports
			test.log(LogStatus.FAIL, "Verification Failed with Exception : "+t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenShotName));
			
		}
		
	}
	public void click(String locator) {
		
		if(locator.endsWith("_CSS")) {
		log.info("entered");
		driver.findElement(By.cssSelector(or.getProperty(locator))).click();
		}else if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(locator))).click();
		}else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(or.getProperty(locator))).click();
		}else if(locator.endsWith("_LinkTEXT")) {
			driver.findElement(By.linkText(or.getProperty(locator))).click();
		}
		test.log(LogStatus.INFO, "Clicking on : "+locator);
		
	}
	
	public void type(String locator,String value) {
		
		if(locator.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
		}else if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
		}else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
		}
		test.log(LogStatus.INFO, "typing in : "+locator+"Entered value is :"+value);
	}
	static WebElement dropDown;
	public void select(String locator,String value) {
		
		if(locator.endsWith("_CSS")) {
			dropDown=driver.findElement(By.cssSelector(or.getProperty(locator)));
		}
		else if(locator.endsWith("_XPATH")) {
			dropDown=driver.findElement(By.xpath(or.getProperty(locator)));
			
		}else if(locator.endsWith("_ID")) {
			dropDown=driver.findElement(By.id(or.getProperty(locator)));
		}
		
		Select select=new Select(dropDown);
		select.selectByVisibleText(value);
		
		//test.log(LogStatus.INFO, "Selecting from dropdwon :"+locator+"  value is "+value);
		
	}
	
	public static void tearDown() {
		driver.close();
	}
	public boolean isElementPresent(By by) {

		try {
			
			driver.findElement(by);

			return true;
			
		} catch (NoSuchElementException e) {

			return false;
		}

	}
	
	

}
