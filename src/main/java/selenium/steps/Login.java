package selenium.steps;

import org.openqa.selenium.By;

import selenium.util.SeleniumConfig;

/**
 * 
 * @author prototype360
 *
 */
public class Login extends SeleniumConfig {

	public Login(){
		
	}

	public void loginSteps() {
		inputText("test test", "//textarea[@title='Search']");
		clickButton("//button");
	}
	
	private void clickButton(String xpath) {
		wait.until(d->{
			driver.findElement(By.xpath(xpath)).click(); 
		return true;});
		
	}
	
	private void inputText(String input, String xpath) {
		wait.until(d->{
			driver.findElement(By.xpath(xpath)).sendKeys(input); 
		return true;});
		
	}
}
