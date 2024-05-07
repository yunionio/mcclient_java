package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.entitys.RoleAssignmentsListInput;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.k8s.ContainerRegistryManager;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class KubeServerMangerTest extends TestCase {
	public void testApp() {
		Client cli = new Client(Env.get("authUrl"), 5000, true, true);
		TokenCredential token = null;
		try {
			token = cli.Authenticate(Env.get("username"), 
			Env.get("password"), 
			Env.get("domain"),
			Env.get("project"),
			Env.get("projectDomain"));
			Session s = cli.newSession(Env.get("region"), null, EndpointType.PublicURL, token);
			ContainerRegistryManager regManager = new ContainerRegistryManager();
			JSONObject ob = new JSONObject();
			ob.put("scope", "max");
			ob.put("limit", 0);
			ListResult list = regManager.List(s, ob);
			if (list != null) {
				for (int i = 0; i < list.getTotal(); i++) {
					JSONObject jsonObject = list.getDataAt(i);
					if (jsonObject.containsKey("id") && jsonObject.getString("id") != null) {
						String id = jsonObject.getString("id");
						if (id != null && id.length() != 0) {
							StringBuilder sb = new StringBuilder();
							sb.append(" id:").append(id);
							sb.append(" name:").append(jsonObject.getString("name"));
							System.out.println(sb.toString());
						}
					}
				}
			}
		} catch (JSONClientException e) {
			e.printStackTrace();
		} catch (McClientJavaBizException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
