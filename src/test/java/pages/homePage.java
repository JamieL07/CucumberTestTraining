package pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {

    protected WebDriver driver;

    private By btn_signin = By.cssSelector("#main-content > div.govuk-width-container.app-width-container > div > div > div > div > div > div > div > a");

    public homePage(WebDriver driver) {

        this.driver = driver;

        if (!driver.getTitle().equals("Manage your vehicle testing")) {

            throw new IllegalStateException("This is not the home page" +driver.getTitle());

        }
    }

    public void clickSignin(){

        driver.findElement(btn_signin).click();
    }
}

