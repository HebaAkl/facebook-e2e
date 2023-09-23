package tests.registration;

import data.GetTestData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import pages.registration.RegistrationPage;
import tests.BaseTest;

public class FacebookRegistrationTest extends BaseTest {
    RegistrationPage registrationPage;
    GetTestData getTestData;
    LoginPage loginPage;
    User user;

    @BeforeMethod
    public void setUpData() {
        initializeObjects();
        createTestData();
        registrationPage.visitUrl("https://www.facebook.com");
    }

    @Test
    public void testRegistrationWithValidData() {
        loginPage.clickOnCreateAccount();
        registrationPage.waitFor(2);
        registrationPage.registerWith(user);
        registrationPage.waitFor(2);
        Assert.assertEquals(registrationPage.haveContentCount(getTestData.getTestingData("emailConfirmation", "title")), 2);
    }

    @Test
    public void testRegistrationWithCustomGender() {
        setCustomGender();
        loginPage.clickOnCreateAccount();
        registrationPage.waitFor(2);
        registrationPage.registerWithCustomGender(user);
        registrationPage.waitFor(2);
        Assert.assertEquals(registrationPage.haveContentCount(getTestData.getTestingData("emailConfirmation", "title")), 2);
    }

    @Test
    public void testEmptyFirstNameValidationAppear() {
        loginPage.clickOnCreateAccount();
        registrationPage.waitFor(2);
        registrationPage.clickSignUp();
        Assert.assertTrue(registrationPage.isTextDisplayed(getTestData.getTestingData("registrationValidation", "firstName")));
    }

    @Test
    public void testEmptyLastNameValidationAppear() {
        loginPage.clickOnCreateAccount();
        registrationPage.waitFor(2);
        registrationPage.clickSignUp();
        registrationPage.pressOnLastName();
        Assert.assertEquals(registrationPage.haveContentCount(getTestData.getTestingData("registrationValidation", "lastName")), 2);
    }

    @Test
    public void testEmptyEmailValidationAppear() {
        loginPage.clickOnCreateAccount();
        registrationPage.waitFor(2);
        registrationPage.clickSignUp();
        registrationPage.pressOnEmail();
        Assert.assertTrue(registrationPage.isTextDisplayed(getTestData.getTestingData("registrationValidation", "email")));
    }

    @Test
    public void testEmptyPasswordValidationAppear() {
        loginPage.clickOnCreateAccount();
        registrationPage.waitFor(2);
        registrationPage.clickSignUp();
        registrationPage.pressOnPassword();
        Assert.assertTrue(registrationPage.isTextDisplayed(getTestData.getTestingData("registrationValidation", "password")));
    }


    private void initializeObjects(){
        getTestData = new GetTestData();
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
    }

    private void createTestData(){
        user = new User(
                getTestData.getTestingData("registration", "firstName"),
                getTestData.getTestingData("registration", "lastName"),
                getTestData.getTestingData("registration", "email"),
                getTestData.getTestingData("registration", "password"),
                getTestData.getTestingData("registration", "dayOfBirth"),
                getTestData.getTestingData("registration", "monthOfBirth"),
                getTestData.getTestingData("registration", "yearOfBirth"),
                getTestData.getTestingData("registration", "female")
        );
    }

    private void setCustomGender(){
        user.setGender(getTestData.getTestingData("registration", "custom"));
        user.setPronoun(getTestData.getTestingData("registration", "pronoun").replace("\\", "\""));
        user.setCustomGenderInput(getTestData.getTestingData("registration", "genderInput"));
    }
}
