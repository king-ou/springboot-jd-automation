package com.jd.auto.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver initDriver() {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");

        EdgeOptions options = new EdgeOptions();

        // CORE FIX FOR EDGE
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-blink-features=AutomationControlled");

        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");

        // START EDGE (AUTOMATIC DRIVER MANAGEMENT)
        System.setProperty("webdriver.edge.autoDownload", "false");
        WebDriver webDriver = new EdgeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.set(webDriver);
        return webDriver;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void quit() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}