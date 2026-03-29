# SSO UI Automation Testing Framework
## Project Overview
This is an enterprise-grade automation framework for regression testing on Kubernetes-based systems.
It supports:
- SSO login automation
- Core page validation
- Business flow testing
- HTML test report generation

## Tech Stack
SpringBoot 3.2.0 + Selenium 4 + TestNG + ExtentReport 5

## How to Run
1. Configure account in TestConfig.java
2. Run: mvn clean test
3. View report in /reports

## Kubernetes Deployment
1. Build Docker image
2. Push to registry
3. Deploy: kubectl apply -f k8s/automation-job.yaml