package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

	private static WebDriver driver = null;
	private static final String FIREFOX_DRIVER_DIRECTORY = "webdriver.gecko.driver";
	public static WebDriver getDriver() {

		if (driver == null) {
			switch (BrowserSettings.browser) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.silentOutput", "true");
				driver = new ChromeDriver();
				break;
				case FIREFOX:
					System.setProperty(FIREFOX_DRIVER_DIRECTORY,"src/test/resources/drivers/geckodriver.exe");
					driver = new FirefoxDriver();
					break;
			case HEADLESS:
				ChromeOptions options = new ChromeOptions();
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void refreshPage() {
		driver.navigate().refresh();
	}
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
