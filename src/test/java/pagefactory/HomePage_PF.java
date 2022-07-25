package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PF {

    @FindBy(xpath = "/html/body/main/div[2]/div/div/div/div/div/div/div/a")
    WebElement btn_signin;

    WebDriver driver;

    public HomePage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        if(!driver.getTitle().equals("Manage your vehicle testing")){

            throw new IllegalStateException("This is not the home page" +driver.getTitle());
        }

    }



    public void clickSignin() {
        btn_signin.click();
    }

}

