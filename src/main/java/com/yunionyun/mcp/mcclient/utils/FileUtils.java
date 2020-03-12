package com.yunionyun.mcp.mcclient.utils;

import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.TextUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 模拟accessToken和jsTicket的数据持久化<br>
 *
 * <p>正式项目最好是写入到Mysql
 */
public class FileUtils {
	private static final String FILEPATH = "conf";
	private static Logger logger = LoggerUtils.createLoggerFor(FileUtils.class.getName());

	// json写入文件
	static synchronized void write2File(Object json, String fileName) {
		BufferedWriter writer = null;
		File filePath = new File(FILEPATH);
		JSONObject eJSON = null;

		if (!filePath.exists() && !filePath.isDirectory()) {
			filePath.mkdirs();
		}

		File file = new File(FILEPATH + File.separator + fileName + ".xml");
		logger.info("path:" + file.getPath() + " abs path:" + file.getAbsolutePath());
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				logger.info("createNewFile，出现异常:");
				e.printStackTrace();
			}
		} else {
			try {
				eJSON = read2JSON(fileName);
			} catch (Exception e) {
				logger.info("error: cat't parse onject:" + fileName);
			}
		}

		try {
			writer = new BufferedWriter(new FileWriter(file));

			if (eJSON == null) {
				writer.write(json.toString());
			} else {
				Object[] array = ((JSONObject) json).keySet().toArray();
				for (Object anArray : array) {
					eJSON.put(anArray.toString(), ((JSONObject) json).get(anArray.toString()));
				}

				writer.write(eJSON.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 读文件到json
	private static JSONObject read2JSON(String fileName) {
		File file = new File(FILEPATH + File.separator + fileName + ".xml");
		if (!file.exists()) {
			return null;
		}

		BufferedReader reader;
		StringBuilder laststr = new StringBuilder();
		JSONObject jsonObject = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString;
			while ((tempString = reader.readLine()) != null) {
				laststr.append(tempString);
			}
			reader.close();
			jsonObject = JSONObject.parseObject(laststr.toString());
		} catch (IOException e) {
			logger.info("data error:" + laststr);
			logger.info(e.getMessage(), e);
		}

		return jsonObject;
	}

	// 通过key值获取文件中的value
	public static Object getValue(String fileName, String key) {
		JSONObject eJSON;
		eJSON = read2JSON(fileName);
		if (null != eJSON && eJSON.containsKey(key)) {
			@SuppressWarnings("unchecked")
			Map<String, Object> values = JSON.parseObject(eJSON.toString(), Map.class);
			return values.get(key);
		} else {
			return null;
		}
	}

	public static HashMap<Long, Long> toHashMap(JSONObject js) {
		if (js == null) {
			return null;
		}
		HashMap<Long, Long> data = new HashMap<Long, Long>();
		// 将json字符串转换成jsonObject
		Set<String> set = js.keySet();
		// 遍历jsonObject数据，添加到Map对象
		for (String aSet : set) {
			String key = String.valueOf(aSet);
			Long keyLong = Long.valueOf(key);

			String value = js.getString(key);
			Long valueLong;
			if (TextUtils.isEmpty(value)) {
				valueLong = js.getLong(key);
			} else {
				valueLong = Long.valueOf(value);
			}
			data.put(keyLong, valueLong);
		}
		return data;
	}
}
