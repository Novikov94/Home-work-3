package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SignUpPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 480;
    WebDriver driver;
    HomePage homePage;
    SignUpPage signUpPage;
    PageFactoryManager pageFactoryManager;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("Github {string} is opened")
    public void githubHomePageIsOpened(final String url) throws InterruptedException {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        Thread.sleep(1000);
        homePage.isSignUpBtnVisible();
        homePage.signUpBtnClick();
    }

    @When("user enters “invalid123” into email field")
    public void userEntersInvalidIntoEmailField() {
        signUpPage = pageFactoryManager.getSignUpPage();
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.emailTextField);
        signUpPage.enterTextToEmailTextField();
        Assert.assertTrue(signUpPage.isEmailTextFieldVisible());
    }

    @Then("error message below email field should be displayed")
    public void errorMessageBelowEmailFieldShouldBeDisplayed() {
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.emailErrorMsq);
        Assert.assertTrue(signUpPage.isEmailErrorMsgVisible());
    }


    @When("user enters “AAA” into password field")
    public void userEntersAAAIntoPasswordField() throws InterruptedException {
        signUpPage = pageFactoryManager.getSignUpPage();
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.emailTextField);
        signUpPage.enterValidEmail();
        //signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,signUpPage.continueBtn);
        Thread.sleep(1000);
        signUpPage.clickContinueBtn();
        signUpPage.isPasswordFieldVisible();
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,signUpPage.passwordField);
        signUpPage.passwordFieldAAA();
    }

    @Then("“at least 15 characters” message should be marked red")
    public void atLeastCharactersMessageShouldBeMarkedRed() {
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,signUpPage.errorMsg);
        Assert.assertTrue(signUpPage.isErrorMsgVisible());
    }


    @And("“a lowercase letter” message should be marked red")
    public void aLowercaseLetterMessageShouldBeMarkedRed() {
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,signUpPage.redErrorMsg);
        Assert.assertTrue(signUpPage.isRedErrorMsgVisible());
    }

    @When("user enters “AAAaaa” into password field")
    public void userEntersAAAaaaIntoPasswordField() {
        Assert.assertTrue(signUpPage.isPasswordFieldVisible());
        signUpPage.passwordField_AAAaaa();
    }

    @And("at least one username is already registered in application")
    public void atLeastOneUsernameIsAlreadyRegisteredInApplication() throws InterruptedException {
        signUpPage = pageFactoryManager.getSignUpPage();
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.emailTextField);
        signUpPage.enterValidEmail();
        Thread.sleep(1000);
        signUpPage.clickContinueBtn();
        Assert.assertTrue(signUpPage.isPasswordFieldVisible());
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,signUpPage.passwordField);
        signUpPage.enterValidPassword();
        Thread.sleep(1000);
        signUpPage.clickContinueBtn2();
    }


    @When("user enters already existent username into username field")
    public void userEntersAlreadyExistentUsernameIntoUsernameField() {
        Assert.assertTrue(signUpPage.isUserNameFieldVisible());
        signUpPage.enterUserName();
    }


    @Then("error message below username field should be displayed")
    public void errorMessageBelowUsernameFieldShouldBeDisplayed() {
        Assert.assertTrue(signUpPage.isLoginErrorMsgVisible());
    }

    @And("suggested usernames in error message contains the username entered")
    public void suggestedUsernamesInErrorMessageContainsTheUsernameEntered() {
        Assert.assertTrue(signUpPage.isSearchWordContainsInErrorMsg());
    }
}
