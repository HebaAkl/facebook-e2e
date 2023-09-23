package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	//Method to take when the test case fail
	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
		Path destination = Paths.get("./screenshots",screenshotName+".png");
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream out = new FileOutputStream(destination.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getRandomEmail(){
		Faker faker = new Faker();
		return faker.internet().safeEmailAddress();
	}

}
