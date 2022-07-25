package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{
    @FindBy(id = "email")
    public WebElement emailTextField;

    @FindBy(id = "email-err")
    public WebElement emailErrorMsq;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@data-continue-to = 'password-container']")
    public WebElement continueBtn;

    @FindBy(xpath = "//button[@data-continue-to = 'username-container']")
    public WebElement continueBtn2;

    @FindBy(xpath = "//p[@class ='password-validity-summary password-validity-summary-fail mb-1']")
    public WebElement redErrorMsg;

    @FindBy(id = "password-err")
    public WebElement errorMsg;

    @FindBy(id = "login")
    public WebElement userNameField;

    @FindBy(id = "login-err")
    public WebElement loginErrorMsg;

    public void clickContinueBtn2(){
        continueBtn2.click();
    }

    public boolean isLoginErrorMsgVisible(){
        loginErrorMsg.isDisplayed();
        return true;
    }

    public boolean isSearchWordContainsInErrorMsg(){
        loginErrorMsg.getText().contains("garyk");
        return true;
    }

    public boolean isUserNameFieldVisible(){
        userNameField.isDisplayed();
        return true;
    }

    public void enterUserName(){
        userNameField.sendKeys("garyk");
    }


    public boolean isRedErrorMsgVisible(){
        redErrorMsg.isDisplayed();
        return true;
    }

    public boolean isErrorMsgVisible(){
        errorMsg.isDisplayed();
        return true;
    }

    public boolean isContinueBtnVisible(){
        continueBtn.isDisplayed();
        return true;
    }

    public boolean isPasswordFieldVisible(){
        passwordField.isDisplayed();
        return true;
    }

    public void enterValidPassword(){
        passwordField.sendKeys("novik2345kaka");
    }

    public void passwordFieldAAA(){
        passwordField.sendKeys("AAA");
    }

    public void passwordField_AAAaaa(){
        passwordField.sendKeys("AAAaaa");
    }

    public void clickContinueBtn(){
        continueBtn.click();
    }

    public boolean isEmailErrorMsgVisible(){
        emailErrorMsq.isDisplayed();
        return true;
    }

    public boolean isEmailTextFieldVisible(){
        emailTextField.isDisplayed();
        return true;
    }

    public void enterTextToEmailTextField(){
        emailTextField.sendKeys("invalid123");
    }

    public void enterValidEmail(){
        emailTextField.sendKeys("annatkacheva3826@gmail.com");
    }

    public SignUpPage(WebDriver driver) {
        super(driver);
    }
}
