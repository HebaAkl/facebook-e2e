package tests.login;

import data.GetTestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import tests.BaseTest;
import utilities.Helper;

public class FacebookLoginTest extends BaseTest {
    LoginPage loginPage;
    GetTestData getTestData;
    FacebookLoginAssertion facebookLoginAssertion;

    @BeforeMethod
    public void setUpData() {
        getTestData = new GetTestData();
        loginPage = new LoginPage(driver);
        facebookLoginAssertion = new FacebookLoginAssertion();
        loginPage.visitUrl("https://www.facebook.com/login");
    }

    @Test
    public void testLoginWithValidEmailAndPassword() {
        loginPage.login(getTestData.getTestingData("login", "validEmail"),
                        getTestData.getTestingData("login", "validPassword"));
        facebookLoginAssertion.assertUserLoginSuccessfully();
    }

    @Test
    public void testLoginWithInvalidEmailAndValidPassword() {
        loginPage.login(getTestData.getTestingData("login", "invalidEmail"),
                getTestData.getTestingData("login", "validPassword"));
        facebookLoginAssertion.assertNotExistCredentialsIsDisplayed();
    }

    @Test
    public void testLoginWithValidEmailAndInValidPassword() {
        loginPage.login(getTestData.getTestingData("login", "validEmail"),
                getTestData.getTestingData("login", "invalidPassword"));
        facebookLoginAssertion.assertNotExistCredentialsIsDisplayed();
    }
}
