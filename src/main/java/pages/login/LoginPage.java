package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By email = By.id("email");
    private By password = By.id("pass");
    private By loginbtn = By.id("loginbutton");
    private By createAccountBtn = By.cssSelector("[data-testid=\"open-registration-form-button\"]");

    public void fillInEmailField(String email){
        fillInInputField(this.email, email);
    }

    public void fillInPasswordField(String password){
        fillInInputField(this.password, password);
    }

    public void clickLoginButton(){
        clickWebElement(loginbtn);
    }

    public void clickOnCreateAccount(){
        clickWebElement(createAccountBtn);
    }

    public void login(String email, String password) {
        fillInEmailField(email);
        fillInPasswordField(password);
        clickLoginButton();
    }
}
