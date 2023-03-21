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

public class MobileBaseClass {
    public static AppiumDriver driver = null;
    public static Map<String, String> readProperties;
    public static String devicePlatform;
    public static HashMap<String, String> deviceCapabilities;
    public static HashMap<String, String> inputTestData;
    public static HashMap<String, String> pageContent;

    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    ExtentTest test;


    public static ExtentTest subChildTest;
    public static String reportTime;

    public void initConfig() {
        readProperties = ReadConfigProperties.readProperties();
        devicePlatform = readProperties.get("device");
    }

    public void loadCapabilities(String platform) {
        String filePath = System.getProperty("user.dir") + "/deviceCapabilities/" + platform + ".json";
        deviceCapabilities = JsonReader.ReadJSONFile(filePath);
    }

    public void loadInputData(String testData) {
        String filePath = System.getProperty("user.dir") + "/testData/" + testData + ".json";
        inputTestData = JsonReader.ReadJSONFile(filePath);
    }

    public void loadPageContents(String pageContents) {
        String filePath = System.getProperty("user.dir") + "/pageContents/" + pageContents + ".json";
        pageContent = JsonReader.ReadJSONFile(filePath);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        initConfig();
        reportTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm zzz").format(Calendar.getInstance().getTime());
        htmlReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/ExtentReports/" + reportTime + "_Results.html");
        //htmlReporter..setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", devicePlatform);
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("Host Name", "Mobile Automation");
        htmlReporter.config().setTimeStampFormat("MMM dd,yyyy hh:mm:ss a zzz");
        htmlReporter.config().setDocumentTitle("IEHP Automation Report");
        htmlReporter.config().setReportName("IEHP Automation Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        loadCapabilities(devicePlatform);
        loadInputData("inputTestData");
        loadPageContents("pageContents");
        if (driver == null) {
            driver = BeforeHook.getDriver(deviceCapabilities, devicePlatform);
        }
    }

    @After
    public void afterScenario(Scenario scenario) throws Throwable {
        if (scenario.isFailed()) {
            // extent.createTest(scenario.getName()).addScreenCaptureFromBase64String(BaseElementMethods.getBase64Screenshot());
        }
        extent.flush();
        driver.closeApp();
    }

}
