package pages.registration;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class RegistrationPage extends BasePage {

    private By firstName = By.cssSelector("[name=\"firstname\"]");
    private By lastname = By.cssSelector("[name=\"lastname\"]");
    private By email = By.cssSelector("[name=\"reg_email__\"]");
    private By emailConfirmation = By.cssSelector("[name=\"reg_email_confirmation__\"]");
    private By password = By.id("password_step_input");
    private By dayOfBirth = By.id("day");
    private By monthOfBirth = By.id("month");
    private By yearOfBirth = By.id("year");
    private String gender = "//*[text()=\"%s\"]/following-sibling::input";
    private By pronounDDL = By.cssSelector("[name=\"preferred_pronoun\"]");
    private By signUpBtn = By.cssSelector("[name=\"websubmit\"]");
    private By genderInput = By.cssSelector("[name=\"custom_gender\"]");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillInFirstName(String text) {
        fillInInputField(firstName, text);
    }

    public void fillInLastName(String text) {
        fillInInputField(lastname, text);
    }

    public void fillInEmail(String text) {
        fillInInputField(email, text);
    }

    public void fillInConfirmationEmail(String text) {
        fillInInputField(emailConfirmation, text);
    }

    public void fillInPassword(String text) {
        fillInInputField(password, text);
    }

    public void selectDayOfBirth(String option) {
        selectElement(dayOfBirth, option);
    }

    public void selectMonthOfBirth(String option) {
        selectElement(monthOfBirth, option);
    }

    public void selectYearOfBirth(String option) {
        selectElement(yearOfBirth, option);
    }

    public void selectGender(String gender){
        By locator = By.xpath(String.format(this.gender, gender));
        clickWebElement(locator);
    }

    public void selectPronoun(String option) {
        selectElement(pronounDDL, option);
    }

    public void fillInGenderInput(String text){
        fillInInputField(genderInput, text);
    }

    public void clickSignUp(){
        clickWebElement(signUpBtn);
    }

    public void pressOnLastName() {
        clickWebElement(lastname);
    }

    public void pressOnEmail() {
        clickWebElement(email);
    }

    public void pressOnPassword() {
        clickWebElement(password);
    }

    public void registerWith(User user){
        fillInFirstName(user.getFirstName());
        fillInLastName(user.getLastname());
        fillInEmail(user.getEmail());
        fillInConfirmationEmail(user.getEmail());
        fillInPassword(user.getPassword());
        selectDayOfBirth(user.getDayOfBirth());
        selectMonthOfBirth(user.getMonthOfBirth());
        selectYearOfBirth(user.getYearOfBirth());
        selectGender(user.getGender());
        clickSignUp();
    }

    public void registerWithCustomGender(User user){
        fillInFirstName(user.getFirstName());
        fillInLastName(user.getLastname());
        fillInEmail(user.getEmail());
        fillInConfirmationEmail(user.getEmail());
        fillInPassword(user.getPassword());
        selectDayOfBirth(user.getDayOfBirth());
        selectMonthOfBirth(user.getMonthOfBirth());
        selectYearOfBirth(user.getYearOfBirth());
        selectGender(user.getGender());
        selectPronoun(user.getPronoun());
        fillInGenderInput(user.getCustomGenderInput());
        clickSignUp();
    }




}
