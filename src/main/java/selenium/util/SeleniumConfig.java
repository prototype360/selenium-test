package selenium.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author prototype360
 *
 */

public class SeleniumConfig {
	private static String propertiesFile = System.getProperty("user.dir") + "/src/test/resources/test.properties";
	public static WebDriver driver;
	public static Wait<WebDriver> wait;

	public SeleniumConfig(){
		
	}
	
	public static void startBrowser() throws FileNotFoundException, IOException {
		Properties pf = new Properties();
		pf.load(new FileInputStream(propertiesFile));
		
		System.setProperty("webdriver.chrome.driver", pf.getProperty("driver"));
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("disable-infobars"); 
		options.addArguments("--disable-extensions"); 
		options.addArguments("--disable-gpu"); 
		options.addArguments("--disable-dev-shm-usage"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--remote-debugging-port=9222");
		options.addArguments("--ignore-certificate-errors"); 
		boolean isHeadless = Boolean.parseBoolean(pf.getProperty("headless"));
		if(isHeadless) {
			options.addArguments("--headless");
		}
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		wait = new WebDriverWait(driver, 3000);

	}
	
	public void closeBrowser() throws IOException {
		driver.manage().deleteAllCookies();
		driver.quit();
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
	}
	
	public void writeResults() throws IOException {
		//FileUtils.touch(file);
		File file = new File( "/" + "audit.txt");
		FileUtils.write(file, "\n************* Total number of scenarios is " +  " *************",
				"UTF-8", true);

	}
		
}
