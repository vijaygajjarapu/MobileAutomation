package com.iehp.hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Properties;

public class ReadConfigProperties {
    /*
     * This method will read/load the Config Properties at once and will return
     * the same as an HashMap and user can use this through the framework
     */
    public static Map<String, String> readProperties() {
        Properties CONFIG = new Properties();
        InputStream input = null;
        Map<String, String> map = new HashMap<String, String>();
        try {
            input = new FileInputStream(System.getProperty("user.dir") + "//config//config.properties");
            // Load a properties file
            CONFIG.load(input);
            // Saving the data in key:value format and returning it as a hashmap
            for (final Entry<Object, Object> entry : CONFIG.entrySet()) {
                map.put((String) entry.getKey(), (String) entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}