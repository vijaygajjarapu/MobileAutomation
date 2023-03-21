package com.iehp.commonStepDefinitios;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.iehp.hooks.GetClass;
import com.iehp.stepDefinitions.MobileBaseClass;
import com.iehp.utilities.BaseElementMethods;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;

import java.util.HashMap;

public class ThenSteps {
    public AppiumDriver driver = MobileBaseClass.driver;
    public ExtentReports extent = MobileBaseClass.extent;
    public static ExtentTest parentTest;
    public BaseElementMethods baseElementMethods;
    public HashMap<String, String> pageContentCollection = MobileBaseClass.pageContent;

    public ThenSteps() {
        baseElementMethods = new BaseElementMethods(driver);
    }

    @Then("Verify user is navigated to {string}")
    public void verify_user_is_navigated_to(String string) {

    }

    @Then("Verify {string} text is displayed in {string} page")
    public void assert_text_present_in_the_page(String pageElementAndPageContent, String pageClassName) {
        Object obj = GetClass.getPageObject(pageClassName);
        String locator = baseElementMethods.getPageLocator(obj, pageElementAndPageContent);
        String pageContent = pageContentCollection.get(pageElementAndPageContent);
        baseElementMethods.assertText(locator,pageContent);
        parentTest = extent.createTest("Text "+ pageContent+" is matching");
    }
}
