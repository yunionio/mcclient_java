package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.entitys.RoleAssignmentsListInput;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.DomainManager;
import com.yunionyun.mcp.mcclient.managers.impl.RoleAssignmentManager;
import com.yunionyun.mcp.mcclient.managers.impl.UserManager;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zxc
 * @date 2020/03/27
 */
public class UserMangerTest extends TestCase {
	public void testApp() {
		Client cli = new Client("", 500, true, true);
		TokenCredential token = null;
		try {
			Set<String> hashSet = new HashSet<>();
			token = cli.Authenticate("", "", "Default", "system");
			Session s = cli.newSession("", null, null, token, "v1");
			UserManager userManager = new UserManager();
			JSONObject ob = new JSONObject();
//			ob.put("role", "domainadmin");
			ob.put("scope", "system");
			ob.put("limit", 0);
			ListResult list = userManager.List(s, ob);
			if (list != null) {
				for (int i = 0; i < list.getTotal(); i++) {
					JSONObject jsonObject = list.getDataAt(i);
					if (jsonObject.containsKey("id") && jsonObject.getString("id") != null) {
						String id = jsonObject.getString("id");
						if (id != null && id.length() != 0) {
							StringBuilder sb = new StringBuilder();
							sb.append(" id:").append(id);
							sb.append(" name:").append(jsonObject.getString("name"));
							hashSet.add(id);
						}
					}
				}
			}
//			System.out.println(hashSet.size());
			DomainManager domainManager = new DomainManager();
			JSONObject jsonObject = domainManager.GetById(s, "zzytest", new JSONObject());
			String id = jsonObject.getString("id");
			if (!"".equalsIgnoreCase(id) && id != null) {

			}
			RoleAssignmentManager roleAssignmentManager = new RoleAssignmentManager();
			RoleAssignmentsListInput input = new RoleAssignmentsListInput();
			input.setEffective(true);
//			input.setRole("domainadmin");
			input.setProject("system");
			input.setProjectDomains(new String[]{"default"});
			input.setRoles(new String[]{"domainadmin"});
			ListResult list1 = roleAssignmentManager.List(s, input);
			if (list1 != null) {
				for (int i = 0; i < list1.getDataSize(); i++) {
					JSONObject dataAt = list1.getDataAt(i);
					if (dataAt.containsKey("user")) {
						JSONObject userObj = dataAt.getJSONObject("user");
						String uId = userObj.getString("id");
						if ("" != uId && uId != null) {
							StringBuilder sb = new StringBuilder();
							sb.append(" id:").append(id);
							sb.append(" name:").append(userObj.getString("name"));
							hashSet.add(uId);
						}
					}
				}
			}
			System.out.println(hashSet.size());
		} catch (JSONClientException e) {
			e.printStackTrace();
		} catch (McClientJavaBizException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
