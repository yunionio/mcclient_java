package com.yunionyun.mcp.mcclient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Env {
    public static String get(String key) {
        try {
            InputStream input = new FileInputStream(System.getProperty("testEnv"));
            
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            return prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}