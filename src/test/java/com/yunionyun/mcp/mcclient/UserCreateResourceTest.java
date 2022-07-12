package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.LogActionManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

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
					cli.Authenticate("", "", "", "", "");
			logger.info(token.toString());
			logger.debug(token.toString());

			Session s = cli.newSession("", null, EndpointType.PublicURL, token);
			LogActionManager manager = new LogActionManager();
			JSONObject params = new JSONObject();
			params.put("scope", "system");
			List<LogInfo> logs = new ArrayList<>();
			for (; ; ) {
				ListResult list = manager.List(s, params);
				if (list != null) {
					for (int i = 0; i < list.getDataSize(); i++) {
						JSONObject data = list.getDataAt(i);
						LogInfo logInfo = JSONObject.parseObject(data.toJSONString(), LogInfo.class);
						logs.add(logInfo);
					}
					String nextMarker = list.getNextMarker();
					if (nextMarker == null || nextMarker.length() == 0) {
						break;
					}
					params.put("paging_marker", nextMarker);
				} else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Some error occured, see details: {}", e);
		}
	}

	public static class LogInfo {
		private String ops_time;
		private String user_id;
		private String user;
		private String action;
		private String obj_type;

		public String getOps_time() {
			return ops_time;
		}

		public void setOps_time(String ops_time) {
			this.ops_time = ops_time;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

		public String getObj_type() {
			return obj_type;
		}

		public void setObj_type(String obj_type) {
			this.obj_type = obj_type;
		}
	}
}
