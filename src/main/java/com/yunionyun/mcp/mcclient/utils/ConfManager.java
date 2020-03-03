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
			logger = LoggerFactory.getLogger("ConfManager");
			System.out.println("Read configure: " + System.getProperty("conf"));
			prop = new Properties();
			InputStreamReader reader =
					new InputStreamReader(new FileInputStream(System.getProperty("conf")), "utf-8");
			// InputStreamReader reader =new InputStreamReader(new
			// FileInputStream("extra/samples/config.properties"),"utf-8");
			prop.load(reader);
			// System.setProperty("LOG_PATH", prop.getProperty("log.path"));
			// System.setProperty("APPDIR", prop.getProperty("app.dir"));
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

	public static String getProperty(String key, String def) {
		String result = getProperty(key);
		if (result == null) {
			return def;
		}
		return result;
	}

	public static Integer getIntProperty(String key) {
		Object o = prop.get(key);
		if (o instanceof Integer) {
			return (Integer) o;
		} else if (o instanceof String) {
			return Integer.parseInt((String) o);
		}
		throw new IllegalArgumentException("Don't know how to convert " + o + " to int");
	}

	public static Double getDouble(String key) {
		Object o = prop.get(key);
		if (o instanceof Number) {
			return ((Number) o).doubleValue();
		} else if (o instanceof String) {
			return Double.parseDouble((String) o);
		}
		throw new IllegalArgumentException("Don't know how to convert " + o + " + to double");
	}

	public static boolean getBoolean(String key) {
		Object o = prop.get(key);
		if (o instanceof Boolean) {
			return (Boolean) o;
		} else if (o instanceof String) {
			return Boolean.valueOf((String) o);
		}
		throw new IllegalArgumentException("Don't know how to convert " + o + " + to boolean");
	}
}
