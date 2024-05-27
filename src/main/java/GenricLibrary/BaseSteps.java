package GenricLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps{
	

	public WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	static long implicitTimeOut = 1;

	// @Parameters("browsername")

	@BeforeClass(alwaysRun = true)
	public WebDriver openBrowser() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
		prop.load(fis);
		System.out.println("directory " + System.getProperty("user.dir"));

		String browsername = prop.getProperty("browser");

		// String browsername = null;
		if (browsername.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("successfully launched chrome browser");

		} else if (browsername.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			Reporter.log("sucessfully launched edge browser");
		} else if (browsername.contains("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log("successfully launched fire fox browser");

		} else if (browsername.contains("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			Reporter.log("sucessfully launched safari browser");

		} else {
			Reporter.log("please enter valid browser name");
		}
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized successfully", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public void navigateToApplication() throws IOException {
		String link = prop.getProperty("url");
		driver.get(link);

	}

	@AfterMethod(alwaysRun = true)
	public void closeTheBrowser() {
		driver.quit();
		Reporter.log("browser close successfully");
//
	}


}
