package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
	protected WebDriver driver;
	private WebElement element;
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitUntilVisibility(By locator){
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected WebElement  findWebElement(By locator){
		waitUntilVisibility(locator);
		element = driver.findElement(locator);
		return element;

	}

	protected List<WebElement>  findWebElements(By locator){
		waitUntilVisibility(locator);
		List<WebElement> elements = driver.findElements(locator);
		return elements;

	}
	protected void fillInInputField(By locator, String email){
		element = findWebElement(locator);
		element.sendKeys(email);
	}

	protected void clickWebElement(By locator){
		element = findWebElement(locator);
		element.click();
	}

	protected void selectElement(By locator, String option){
		element = findWebElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}

	public void visitUrl(String url){
		driver.get(url);
	}

	public String getPageURL(){
		return driver.getCurrentUrl();
	}

	public Boolean isTextDisplayed(String text){
		By locator = By.xpath("//*[contains(text(),\""+ text +"\")]");
		element = findWebElement(locator);
		return element.isDisplayed();
	}

	public int haveContentCount(String text){
		By locator = By.xpath("//*[contains(text(),\""+ text +"\")]");
		return findWebElements(locator).size();
	}


	public void waitFor(int seconds){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

}
