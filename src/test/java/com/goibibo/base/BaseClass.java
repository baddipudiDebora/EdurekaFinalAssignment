package com.goibibo.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.goibibo.pages.HotelBookingPage;
import com.goibibo.pages.LandingPage;



public class BaseClass {
	public static WebDriver driver;
//	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	public static String browser;
	// three page clases are declared here
	public LandingPage landingpageobj;
	public HotelBookingPage hotelBookingPageobj;
	

	@BeforeTest
	public void openBrowser() {
		if (Constants.browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
			// log.debug("Launching Chrome");
		} 
	
		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// two page clases are instantiated here with a parameterized Constructor
		// passing the Webdriver reference
		landingpageobj = new LandingPage(driver);
		hotelBookingPageobj  = new HotelBookingPage(driver);
	}

}
