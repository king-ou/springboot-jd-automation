package com.jd.auto.util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportManager {
    private static ExtentReports report;

    public static ExtentReports create() {
        if (report == null) {
            String path = "reports/JD-Test-Report-" +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("京东UI自动化测试报告");
            report = new ExtentReports();
            report.attachReporter(reporter);
            report.setSystemInfo("Platform", "JD.COM");
            report.setSystemInfo("Env", "K8s Test Cluster");
        }
        return report;
    }
}