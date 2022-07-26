package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    protected WebDriver driver;

    private By txt_username = By.id("signInName");

    private By txt_password = By.id("password");

    private By btn_login = By.id("next");

    private By btn_cookie = By.cssSelector("#cookie-options > div.govuk-button-group > button:nth-child(1)");

    private By btn_skip = By.cssSelector("body > div.govuk-cookie-banner > div:nth-child(2) > div.govuk-button-group > button");

    private By btn_logout = By.cssSelector("body > header > div > div.govuk-header__content > a.sign-out-link.govuk-header__link");


    public loginPage(WebDriver driver) {

        this.driver = driver;

        if (!driver.getTitle().equals("Sign in - Manage your vehicle testing")) {

            throw new IllegalStateException("This is not the signin page " + driver.getTitle());
        }
    }

    public void enterUsername(String username) {

        driver.findElement(txt_username).sendKeys(username);

    }

    public void enterPassword(String password) {

        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickLogin() {

        driver.findElement(btn_login).click();
    }

    public void clickCookie() {

        driver.findElement(btn_cookie).click();
    }

    public void clickSkip() {

        driver.findElement(btn_skip).click();
    }

    public void checkLogOutisDisplayed() {

        driver.findElement(btn_logout).isDisplayed();
    }

    public void loginValidUser(String username, String password) {

        driver.findElement(txt_username).sendKeys(username);
        driver.findElement(txt_password).sendKeys(password);
        driver.findElement(btn_login).click();
    }
}

