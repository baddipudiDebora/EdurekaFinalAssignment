package com.goibibo.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.goibibo.pages.*;

public class BaseClass {
	private static ITestContext context;
	public static WebDriver driver;
//	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	public static String browser;
	// all page clases are declared here
	public LandingPage landingpageobj;
	public HotelSearchPage hotelBookingPageobj;
	public HotelsViewPage hotelsViewPageobj;
	public SingleHotelsViewPage singleHotelViewPageobj;
	public ProceedtoPaymentPage proceedtoPaymentPageobj;
	public PaymentPage paymentPageobj;
	public static ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
		iTestContext.setAttribute("driver", driver);
		return iTestContext;
	}

	@BeforeClass
	public void openBrowser(ITestContext iTestContext) {
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
			context = setContext(iTestContext, driver);
			}
		else if (Constants.browser.equals("ie")) {
			driver= new InternetExplorerDriver();
		}
		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// two page clases are instantiated here with a parameterized Constructor
		// passing the Webdriver reference
		landingpageobj = new LandingPage(driver);
		hotelBookingPageobj = new HotelSearchPage(driver);
		hotelsViewPageobj = new HotelsViewPage(driver);
		singleHotelViewPageobj = new SingleHotelsViewPage(driver);
		proceedtoPaymentPageobj = new ProceedtoPaymentPage(driver);
		paymentPageobj = new PaymentPage(driver);
	}

	@AfterClass()
	public void closeBrowser() {
		driver.close();
	}

	@AfterSuite()
	public void tearDown() {
		sendReportByGMail("YourMailID", "YourPassowrd", "Email1", "TestCase Report", "");
		sendReportByGMail("YourMailID", "YourPassowrd", "Email2", "TestCase Report", "");
		sendReportByGMail("YourMailID", "YourPassowrd", "Email3", "TestCase Report", "");

		}

	/**
	 * Send email using java
	 * 
	 * @param from
	 * @param pass
	 * @param to
	 * @param subject
	 * @param body
	 */
	private static void sendReportByGMail(String from, String pass, String to, String subject, String body) {
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			// Set from address
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set subject
			message.setSubject(subject);
			message.setText(body);

			BodyPart objMessageBodyPart = new MimeBodyPart();

			objMessageBodyPart.setText("Please Find The Attached Report File!");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(objMessageBodyPart);

			objMessageBodyPart = new MimeBodyPart();

			// Set path to the pdf report file
			String filename = System.getProperty("C:\\Users\\Deborah\\eclipse-workspace\\FinalAssignment\\test-output\\emailable-report.html");
			// Create data source to attach the file in mail
			DataSource source = new FileDataSource(filename);

			objMessageBodyPart.setDataHandler(new DataHandler(source));

			objMessageBodyPart.setFileName(filename);

			multipart.addBodyPart(objMessageBodyPart);

			message.setContent(multipart);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}

