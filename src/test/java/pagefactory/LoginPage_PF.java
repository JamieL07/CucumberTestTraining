package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {

    @FindBy(id = "signInName")
    WebElement txt_username;

    @FindBy(id = "password")
    WebElement txt_password;

    @FindBy(id = "next")
    WebElement btn_login;

    @FindBy(css = "#cookie-options > div.govuk-button-group > button:nth-child(1)")
    WebElement btn_cookie;

    @FindBy(css = "body > div.govuk-cookie-banner > div:nth-child(2) > div.govuk-button-group > button")
    WebElement btn_skip;

    @FindBy(css = "body > header > div > div.govuk-header__content > a.sign-out-link.govuk-header__link")
    WebElement btn_logout;

    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void enterUsername(String username) {

        txt_username.sendKeys(username);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickLogin() {
        btn_login.click();
    }

    public void clickCookie() {
        btn_cookie.click();

    }

    public void clickSkip() {
        btn_skip.click();
    }

    public void checkLogOutisDisplayed() {

        btn_logout.isDisplayed();
    }
}

