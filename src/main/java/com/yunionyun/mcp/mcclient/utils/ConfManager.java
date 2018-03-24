package com.yunionyun.mcp.mcclient.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class ConfManager {
    private static Properties prop = null;
    private static Logger logger;


    static {
        try {
            prop = new Properties();
            InputStreamReader reader = new InputStreamReader(new FileInputStream(System.getProperty("conf")), "utf-8");
            // InputStreamReader reader =new InputStreamReader(new FileInputStream("extra/samples/config.properties"),"utf-8");
            prop.load(reader);
            System.setProperty("LOG_PATH", prop.getProperty("log.path"));
            System.setProperty("APPDIR", prop.getProperty("app.dir"));
            logger = LoggerFactory.getLogger("ConfManager");
            logger.info("properties:{}", prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获得指定key的值
     *
     * @param key 指定值得key
     * @return result
     */
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    public static String getProperty(String key,String def){
        String result = getProperty(key);
        if(result == null){
            return def;
        }
        return result;
    }


}
