package com.iehp.hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BeforeHook {
    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver(HashMap<String, String> deviceCapabilities, String devicePlatform) {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            for (Map.Entry<String, String> entry : deviceCapabilities.entrySet()) {
                capabilities.setCapability(entry.getKey(), entry.getValue());
            }
            if (devicePlatform.equalsIgnoreCase("ios")) {
                try {
                    driver = new IOSDriver<MobileElement>(new URL("https://vijaykumarmohith_jmBgG9:dXmDNepytvJFbVGymgr2@hub-cloud.browserstack.com/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    driver = new AndroidDriver<MobileElement>(new URL("https://vijaykumarmohith_jmBgG9:dXmDNepytvJFbVGymgr2@hub-cloud.browserstack.com/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return driver;
    }
}