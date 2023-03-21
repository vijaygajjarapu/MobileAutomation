package com.iehp.stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.iehp.hooks.BeforeHook;
import com.iehp.hooks.ReadConfigProperties;
import com.iehp.utilities.JsonReader;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class APIBaseClass {
    public static HashMap<String, String> inputTestData;

    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    ExtentTest test;
    public static String reportTime;
    public void loadInputData(String testData) {
        String filePath = System.getProperty("user.dir") + "/testData/" + testData + ".json";
        inputTestData = JsonReader.ReadJSONFile(filePath);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        reportTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm zzz").format(Calendar.getInstance().getTime());
        htmlReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/ExtentReports/" + reportTime + "_Results.html");
        //htmlReporter..setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("Host Name", "API Automation");
        htmlReporter.config().setTimeStampFormat("MMM dd,yyyy hh:mm:ss a zzz");
        htmlReporter.config().setDocumentTitle("API Automation Report");
        htmlReporter.config().setReportName("API Automation Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        loadInputData("inputTestData");


    }

    @After
    public void afterScenario(Scenario scenario) throws Throwable {
        if (scenario.isFailed()) {
            // extent.createTest(scenario.getName()).addScreenCaptureFromBase64String(BaseElementMethods.getBase64Screenshot());
        }
        extent.flush();
    }

}

