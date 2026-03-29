package com.jd.auto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestConfig {
    @Value("${test.jd-url}")
    private String jdUrl;

    @Value("${test.jd-login-url}")
    private String loginUrl;

    @Value("${test.jd-order-url}")
    private String orderUrl;

    @Value("${test.username}")
    private String username;

    @Value("${test.password}")
    private String password;

    // getter
    public String getJdUrl() {return jdUrl;}
    public String getLoginUrl() {return loginUrl;}
    public String getOrderUrl() {return orderUrl;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}
}