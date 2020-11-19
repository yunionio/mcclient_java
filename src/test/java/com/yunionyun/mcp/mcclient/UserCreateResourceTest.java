package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.LogManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author zxc
 * @date 2020/11/09
 */
public class UserCreateResourceTest extends TestCase {

	private static Logger logger = LoggerUtils.createLoggerFor(UserCreateResourceTest.class.getName());

	public void test() {
		Client cli = new Client("", 5000, true, true);
		try {
			TokenCredential token =
					cli.Authenticate("", "", "", "");
			logger.info(token.toString());
			logger.debug(token.toString());

			Session s = cli.newSession("region0", null, EndpointType.PublicURL, token, "v2");
			LogManager manager = new LogManager();
//			LogActionManager manager = new LogActionManager();
			JSONObject params = new JSONObject();
//			params.put("obj_type", "eip");
			params.put("user", "3fe20608166a4e7a844605c6ed77a6f3");
//			params.put("action", "create");
			Date now = new Date();
			Calendar instance = Calendar.getInstance();
			instance.add(Calendar.MINUTE, -5);
			Date time = instance.getTime();
			TimeZone tz = TimeZone.getTimeZone("UTC");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			df.setTimeZone(tz);
			String nowAsISO = df.format(time);
//			params.put("since", nowAsISO);
//			params.put("scope", "system");
//			params.put("limit", "0");
//			params.put("filter", "action.in(eip_detach)");
			ListResult list = manager.List(s, params);
			if (list != null) {

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Some error occured, see details: {}", e);
		}
	}
}
