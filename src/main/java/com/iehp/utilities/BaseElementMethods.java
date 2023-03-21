package com.iehp.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static io.restassured.RestAssured.given;


public class BaseElementMethods {
    public static AppiumDriver<MobileElement> driver;

    public BaseElementMethods(AppiumDriver driver) {
        this.driver = driver;
    }

    public String getPageLocator(Object obj, String elementName) {
        Class c = obj.getClass();
        Field element = null;
        String locator = null;
        try {
            element = c.getField(elementName);
            try {
                locator = ((String) element.get(obj));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        return locator;
    }

    //Tap to an element for 250 milliseconds
    public void tapByElement (String androidElement) {
        WebElement element = driver.findElement(By.xpath(androidElement));
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int middleX = (rightX + leftX) / 2;
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(middleX, middleY))
                .perform();

//        new TouchAction(driver)
//                .tap(tapOptions().withElement(element(driver.findElement(By.xpath(androidElement)))))
//                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    public void tapOn(String buttonElement) {
        driver.findElement(By.xpath(buttonElement)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fills(String textFieldElement, String textToBeFilled) {
        driver.findElement(By.xpath(textFieldElement)).sendKeys(textToBeFilled);
       // if(textToBeFilled.contains("confirm")) {

       // }


    }

    public void assertText(String textFieldElement, String expectedValue) {
        String currentValue = driver.findElement(By.xpath(textFieldElement)).getText();
        Assert.assertEquals(currentValue,expectedValue);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBase64Screenshot() {
        String base64StringOfScreenshot = "";

        File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
        String sDate = sdf.format(date);
        try {
            FileUtils.copyFile(sourcePath, new File(System.getProperty("user.dir") + "/test-output/" + sDate + ".png"));
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            base64StringOfScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return base64StringOfScreenshot;
    }

    public static String getScreenshot(AppiumDriver driver, String screenshotName) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
        return destination;
    }

    public static void getResponseBody(){
        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
    }

    public static void getResponseStatus(){
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get("http://demo.guru99.com/V4/sinkministatement.php").then().assertThat().statusCode(200);
    }
}
