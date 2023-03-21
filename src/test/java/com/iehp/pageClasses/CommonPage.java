package com.iehp.pageClasses;

import com.iehp.stepDefinitions.MobileBaseClass;
import com.iehp.utilities.Scroll;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;

import java.util.List;

public class CommonPage {

    public static WebDriver driver = MobileBaseClass.driver;
    public String gettingStarted = "//*[@name='get_started_button'] | //*[@resource-id='get_started_button']";
    public String iehpNumber = "//*[@name='register_member_input_field_test_id'] | //*[@resource-id='get_started_button']";
    public String dateOfBirth = "//*[@name='register_member_dob_field_test_id'] | //*[@resource-id='register_member_dob_field_test_id']";
    public String datePickerValues = "//*[@name='android:id/numberpicker_input']| //*[@resource-id='android:id/numberpicker_input']";
    public String datePicValues = "//*[@name='com.sidebench.iehp.healthhub.staging:id/pickerWrapper']| //*[@resource-id='com.sidebench.iehp.healthhub.staging:id/pickerWrapper']";
    public String datePicClass = "//*[@name='android.widget.NumberPicker']| //*[@resource-id='android.widget.NumberPicker']";
    //public String datePicValues = "//*[@name='com.sidebench.iehp.healthhub.staging:id/pickerWrapper']| //*[@resource-id='com.sidebench.iehp.healthhub.staging:id/pickerWrapper']";
    //public String datePicValues = "//*[@name='com.sidebench.iehp.healthhub.staging:id/pickerWrapper']| //*[@resource-id='com.sidebench.iehp.healthhub.staging:id/pickerWrapper']";
    public String confirm = "//*[@name='android:id/button1'] | //*[@resource-id='android:id/button1']";
    public String Cancel = "//*[@name='android:id/button2'] | //*[@resource-id='android:id/button2']";
    public String termsAndConditions = "//*[@name='register_member_radio_button_test_id'] | //*[@resource-id='register_member_radio_button_test_id']";
    public String nextInIEHP = "//*[@name='register_member_next_button_test_id'] | //*[@resource-id='register_member_next_button_test_id']";

    public void selectDateOfBirthAndroid() {
        List<WebElement> dob = driver.findElements(By.xpath(datePickerValues));
        dob.get(0).findElement(By.xpath(datePickerValues)).sendKeys("September");
        dob.get(1).findElement(By.xpath(datePickerValues)).sendKeys("11");
        dob.get(2).findElement(By.xpath(datePickerValues)).sendKeys("1990");
        //String  list[] = {"September","11","1990"};
        //System.out.println("Starting the process");
        //Scroll.scrollChecker((AppiumDriver) driver,list);
       // System.out.println("Ending Process");


//


    }

    private String OTPloop(int size, List<AndroidElement> element) {
        System.out.println("Inside OTP Loop method");
        for (int i = 0; i < size; i++) {
            System.out.println("Current position = " + i);
            if (element.get(i).getText().contains("OTP: ")) {
                return element.get(i).getText();
            }
        }
        return "";
    }

    public void enterSsnOrPhone(String ssnOrPhone){
        String val = ssnOrPhone;
        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            String inputSsnOrPhone = "//*[@name='digit_input_"+(i+1)+"'] | //*[@resource-id='digit_input_"+(i+1)+"']";
            driver.findElement(By.xpath(inputSsnOrPhone)).sendKeys(s);
        }
        driver.findElement(By.xpath("//*[@name='digit_input_1'] | //*[@resource-id='digit_input_1']")).click();
    }
}
