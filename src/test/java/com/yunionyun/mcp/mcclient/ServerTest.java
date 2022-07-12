package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.ServerManager;
import com.yunionyun.mcp.mcclient.utils.CodecUtils;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

/**
 * @author zxc
 * @date 2020/05/19
 */
public class ServerTest extends TestCase {

	private static Logger logger = LoggerUtils.createLoggerFor(ServerManager.class.getName());

	public void testApp() {
		Client cli = new Client("https://192.168.2.1:30500/v3", 5000, true, true);
		try {
			TokenCredential token =	cli.Authenticate("uname", "passwd", "udomain", "system", "Default");
			logger.info(token.toString());
			JSONObject rtn = new JSONObject();

			Session s = cli.newSession("region0", null, EndpointType.PublicURL, token);

			ServerManager serverManager = new ServerManager();
			JSONObject serverInfo = serverManager.GetById(s, "2db6124a-f5de-4ec2-8fbe-16e4b0362f63", null);
			JSONObject metaData = serverInfo.getJSONObject("metadata");

			String userName = metaData.getString("login_account");
			String loginKey = metaData.getString("login_key");
			String passwd = "";
			if (loginKey != null && loginKey != "") {
				rtn.put("userName", userName);
				rtn.put("loginKey", loginKey);

				String keypair_id = serverInfo.getString("keypair_id");
				if (keypair_id != null && keypair_id != "" && keypair_id != "none") {
					String private_key = "";//私钥
					passwd = CodecUtils.decryptAESBase64(loginKey, private_key);
				} else {
					//如果不存在keypair_id,直接用id信息进行解码
					String id = "2db6124a-f5de-4ec2-8fbe-16e4b0362f63";//.replace("_", "+").replace("-", "/");
					passwd = CodecUtils.decryptAESBase64(loginKey, id);
				}
				rtn.put("password", passwd);
			}
			System.out.println(rtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
