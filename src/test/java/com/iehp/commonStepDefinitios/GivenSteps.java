package com.iehp.commonStepDefinitios;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.iehp.hooks.GetClass;
import com.iehp.stepDefinitions.MobileBaseClass;
import com.iehp.utilities.BaseElementMethods;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

public class GivenSteps {

    public AppiumDriver driver = MobileBaseClass.driver;
    public ExtentReports extent = MobileBaseClass.extent;
    public static ExtentTest parentTest;
    public BaseElementMethods baseElementMethods;

    public GivenSteps() {
        baseElementMethods = new BaseElementMethods(driver);
    }

    @Given("User tap {string} button in {string} page")
    public void userTapButtonInPage(String buttonName, String pageClassName) {
        Object obj = GetClass.getPageObject(pageClassName);
        String locator = baseElementMethods.getPageLocator(obj, buttonName);
        baseElementMethods.tapOn(locator);
        parentTest = extent.createTest("Clicked on " + buttonName + " button");
    }

    @Given("User taps {string} button in {string} page")
    public void userTapsButtonInPage(String buttonName, String pageClassName) {
        Object obj = GetClass.getPageObject(pageClassName);
        String locator = baseElementMethods.getPageLocator(obj, buttonName);
        baseElementMethods.tapByElement(locator);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        parentTest = extent.createTest("Tapped on " + buttonName + " button");
    }
}
