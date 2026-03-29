package com.jd.auto.pages;
import com.jd.auto.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JdOrderPage extends BasePage {

    @FindBy(css = ".order-total")
    private WebElement orderCount;

    @FindBy(css = ".order-item")
    private WebElement orderItem;

    public JdOrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasOrders() {
        try {
            return orderItem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getOrderText() {
        return text(orderItem);
    }
}