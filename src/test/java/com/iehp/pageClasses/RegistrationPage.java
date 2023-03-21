package com.iehp.pageClasses;

import com.iehp.stepDefinitions.MobileBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage {

    public static WebDriver driver = MobileBaseClass.driver;

    public RegistrationPage() {

    }

    public String gettingStarted = "//*[@name='get_started_button'] | //*[@resource-id='get_started_button']";
    public String iehpNumber = "//*[@name='register_member_input_field_test_id'] | //*[@resource-id='register_member_input_field_test_id']";
    public String dateOfBirth = "//*[@name='register_member_dob_field_test_id'] | //*[@resource-id='register_member_dob_field_test_id']";
    public String datePickerValues = "//*[@name='android:id/numberpicker_input']| //*[@resource-id='android:id/numberpicker_input']";
    public String confirm = "//*[@name='android:id/button1'] | //*[@resource-id='android:id/button1']";
    public String Cancel = "//*[@name='android:id/button2'] | //*[@resource-id='android:id/button2']";
    public String termsAndConditions = "//*[@name='register_member_radio_button_test_id'] | //*[@resource-id='register_member_radio_button_test_id']";
    public String nextInIEHP = "//*[@name='register_member_next_button_test_id'] | //*[@resource-id='register_member_next_button_test_id']";
    public String emailHeader = "//*[@name='email_capture_title'] | //*[@resource-id='email_capture_title']";
    public String emailAddress = "//*[@name='email_address_input'] | //*[@resource-id='email_address_input']";
    public String confirmEmailAddress = "//*[@name='confirm_email_address_input'] | //*[@resource-id='confirm_email_address_input']";
    public String nextInEmail = "//*[@name='next_button'] | //*[@resource-id='next_button']";
    public String password = "//*[@name='password_input'] | //*[@resource-id='password_input']";
    public String confirmPassword = "//*[@name='confirm_password_input'] | //*[@resource-id='confirm_password_input']";
    public String passwordHeader = "//*[@name='password_entry_title'] | //*[@resource-id='password_entry_title']";
    public String verificationHeader = "//*[@name='verification_title'] | //*[@resource-id='verification_title']";
    public String verificationHeaderOutline = "//*[@name='text-input-outline'] | //*[@resource-id='text-input-outline']";
    public String submitButton = "//*[@name='password_submit_button'] | //*[@resource-id='password_submit_button']";
    public String accessCodeScreenHeader = "//*[@name='access_code_screen_info_test_id'] | //*[@resource-id='access_code_screen_info_test_id']";
    public String accessCode = "//*[@name='access_code_input_field_test_id'] | //*[@resource-id='access_code_input_field_test_id']";
    public String allSet = "//*[@name='access_code_next_button_test_id'] | //*[@resource-id='access_code_next_button_test_id']";
    public String securityQuestion1 = "//*[@name='security_question_one'] | //*[@resource-id='security_question_one']";
    public String securityQuestion2 = "//*[@name='security_question_two'] | //*[@resource-id='security_question_two']";
    public String securityQuestion3 = "//*[@name='security_question_three'] | //*[@resource-id='security_question_three']";
    public String answerField1 = "//*[@name='answerFieldOne'] | //*[@resource-id='answerFieldOne']";
    public String answerField2 = "//*[@name='answerFieldTwo'] | //*[@resource-id='answerFieldTwo']";
    public String answerField3 = "//*[@name='answerFieldThree'] | //*[@resource-id='answerFieldThree']";
    public String almostDone = "//*[@name='almost_done_next_button_test_id'] | //*[@resource-id='almost_done_next_button_test_id']";
    public String registrationComplete = "//*[@name='registration_complete_text'] | //*[@resource-id='registration_complete_text']";

    public void selectDateOfBirthAndroid() {
        driver.findElement(By.xpath(dateOfBirth)).click();
        List<WebElement> dob = driver.findElements(By.xpath(datePickerValues));
        dob.get(0).sendKeys("October");
        dob.get(0).sendKeys("19");
        dob.get(0).sendKeys("2020");
    }

}
