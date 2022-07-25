package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class ='HeaderMenu-link flex-shrink-0 d-inline-block no-underline border color-border-default " +
            "rounded px-2 py-1']")
    public WebElement signUpBtn;

    @FindBy(xpath = "//a[@class = 'HeaderMenu-link flex-shrink-0 no-underline']")
    public WebElement signInBtn;

    public void signInBtnClick(){
        signUpBtn.click();
    }

    public void isSignUpBtnVisible(){
        signUpBtn.isDisplayed();
    }
    public void signUpBtnClick(){
        signUpBtn.click();
    }


    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void openHomePage(String url){
        driver.get(url);
    }


}
