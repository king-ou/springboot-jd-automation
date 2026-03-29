package com.jd.auto.pages;
import com.jd.auto.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JdLoginPage extends BasePage {

    @FindBy(id = "loginname")
    private WebElement usernameInput;

    @FindBy(id = "nloginpwd")
    private WebElement passwordInput;

    @FindBy(id = "loginsubmit")
    private WebElement submitBtn;

    public JdLoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pwd) {
        send(usernameInput, user);
        send(passwordInput, pwd);
        click(submitBtn);
    }

    public boolean isLoginSuccess() {
        return driver.getTitle().contains("京东") || driver.getCurrentUrl().contains("order");
    }
}