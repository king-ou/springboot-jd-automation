package com.jd.auto.pages;
import com.jd.auto.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JdHomePage extends BasePage {

    @FindBy(css = "title")
    private WebElement title;

    public JdHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeLoaded() {
        return driver.getTitle().contains("京东");
    }
}