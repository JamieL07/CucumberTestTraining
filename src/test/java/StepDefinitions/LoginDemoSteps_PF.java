package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.HomePage_PF;
import pagefactory.LoginPage_PF;

import java.util.concurrent.TimeUnit;

public class LoginDemoSteps_PF {

    WebDriver driver = null;
    LoginPage_PF login;
    HomePage_PF home;

    final By Signin = By.cssSelector("#main-content > div.govuk-width-container.app-width-container > div > div > div > div > div > div > div > a");

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("Inside Step - browser is open");

        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is :" + projectPath);

        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

    }

    @And("user is on login page")
    public void user_is_on_login_page() {

        driver.navigate().to("https://myvttest.powerappsportals.com/");
        driver.manage().window().maximize();

    }

    @And("user clicks on sign in")
    public void user_clicks_on_sign_in() throws InterruptedException {

        home = new HomePage_PF(driver);
        home.clickSignin();
        //driver.findElement(By.cssSelector("#main-content > div.govuk-width-container.app-width-container > div > div > div > div > div > div > div > a")).click();
        Thread.sleep(2000);
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {

        login = new LoginPage_PF(driver);

        login.enterUsername(username);
        login.enterPassword(password);

        // driver.findElement(By.id("signInName")).sendKeys(username);
        // driver.findElement(By.id("password")).sendKeys(password);

    }

    @And("user clicks on login")
    public void user_clicks_on_login() {

        login.clickLogin();

        //driver.findElement(By.id("next")).click();

    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws InterruptedException {

        login.clickCookie();
        login.clickSkip();
        login.checkLogOutisDisplayed();
        //driver.findElement(By.cssSelector("body > header > div > div.govuk-header__content > a.sign-out-link.govuk-header__link")).isDisplayed();

        Thread.sleep(2000);
    }

    @And("user clicks on Accessibility Button")
    public void user_clicks_on_accessibility_button() {

        driver.findElement(By.cssSelector("body > footer > div > div > div.govuk-footer__meta-item.govuk-footer__meta-item--grow > ul > li:nth-child(1) > a")).click();

    }

    @Then("Accessibility page is displayed")
    public void accessibility_page_is_displayed() throws InterruptedException {

        driver.getPageSource().contains("Accessibility statement");
        Thread.sleep(2000);

    }

    @Then("user closes the browser")
    public void user_closes_the_browser() {
        driver.close();
    }
}
