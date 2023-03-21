package com.iehp.commonStepDefinitios;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.iehp.hooks.GetClass;
import com.iehp.pageClasses.CommonPage;
import com.iehp.stepDefinitions.MobileBaseClass;
import com.iehp.utilities.BaseElementMethods;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.HashMap;

public class WhenSteps {
    public AppiumDriver driver = MobileBaseClass.driver;
    public HashMap<String, String> inputTestData = MobileBaseClass.inputTestData;
    public BaseElementMethods baseElementMethods;
    public ExtentReports extent = MobileBaseClass.extent;
    public static ExtentTest parentTest;
    CommonPage commonPage = new CommonPage();

    public WhenSteps() {
        baseElementMethods = new BaseElementMethods(driver);
    }

    @When("User fills {string} text field in {string} page")
    public void userFillsTextFieldInPage(String textField, String pageClassName) {
        Object obj = GetClass.getPageObject(pageClassName);
        String locator = baseElementMethods.getPageLocator(obj, textField);
        String valueToBeFilled = inputTestData.get(textField);
        baseElementMethods.fills(locator, valueToBeFilled);
        parentTest = extent.createTest("Filled " + textField + " field with value " + valueToBeFilled)
                .assignDevice(MobileBaseClass.devicePlatform).pass("User is able to enter");
    }

    @When("User select {string} in {string} page")
    public void user_select_dob_in_device(String dateOfBirth, String pageClassName) {
        //Object obj = GetClass.getPageObject(pageClassName);
        //CommonPage commonPage = new CommonPage();
        if (MobileBaseClass.devicePlatform.equalsIgnoreCase("android")) {
            commonPage.selectDateOfBirthAndroid();
        } else {

        }

    }

    @And("User enters {string} using common page")
    public void enter_ssn_or_phone(String lastFourDigits) {
        String valueToBeFilled = inputTestData.get(lastFourDigits);
        commonPage.enterSsnOrPhone(valueToBeFilled);
    }

}
