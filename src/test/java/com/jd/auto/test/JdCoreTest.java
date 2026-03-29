package com.jd.auto.test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jd.auto.JdAutomationApplication;
import com.jd.auto.config.TestConfig;
import com.jd.auto.core.DriverManager;
import com.jd.auto.pages.JdHomePage;
import com.jd.auto.pages.JdLoginPage;
import com.jd.auto.pages.JdOrderPage;
import com.jd.auto.util.ReportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@SpringBootTest(classes = JdAutomationApplication.class)
public class JdCoreTest extends AbstractTestNGSpringContextTests {

    @Autowired
    DriverManager driverManager;

    @Autowired
    TestConfig config;

    private ExtentReports report;
    private ExtentTest test;

    @BeforeSuite
    public void initReport() {
        report = ReportManager.create();
    }

    @BeforeMethod
    public void start() {
        driverManager.initDriver();
    }

    // 测试1：京东SSO登录
    @Test(priority = 1, description = "京东SSO登录测试")
    public void testLogin() {
        test = report.createTest("京东登录测试");
        driverManager.getDriver().get(config.getLoginUrl());
        JdLoginPage loginPage = new JdLoginPage(driverManager.getDriver());
        loginPage.login(config.getUsername(), config.getPassword());
        Assert.assertTrue(loginPage.isLoginSuccess());
        test.pass("登录成功");
    }

    // 测试2：首页加载
    @Test(priority = 2, description = "京东首页加载测试")
    public void testHome() {
        test = report.createTest("首页加载测试");
        driverManager.getDriver().get(config.getJdUrl());
        JdHomePage homePage = new JdHomePage(driverManager.getDriver());
        Assert.assertTrue(homePage.isHomeLoaded());
        test.pass("首页加载完成");
    }

    // 测试3：订单查询
    @Test(priority = 3, description = "京东订单查询测试")
    public void testOrderQuery() {
        test = report.createTest("订单查询测试");
        driverManager.getDriver().get(config.getOrderUrl());
        JdOrderPage orderPage = new JdOrderPage(driverManager.getDriver());
        boolean hasOrder = orderPage.hasOrders();
        Assert.assertTrue(hasOrder, "未查询到订单");
        test.pass("订单查询成功：" + orderPage.getOrderText());
    }

    @AfterMethod
    public void close() {
        driverManager.quit();
        report.flush();
    }
}