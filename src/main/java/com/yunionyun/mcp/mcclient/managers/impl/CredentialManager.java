package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;
import com.yunionyun.mcp.mcclient.managers.ListResult;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class CredentialManager extends KeystoneManager {
	private static final String ACCESS_SECRET_TYPE = "aksk";
	private static final String TOTP_TYPE = "totp";
	private static final String RECOVERY_SECRETS_TYPE = "recovery_secret";

	public CredentialManager() {
		this(EndpointType.InternalURL);
	}

	public CredentialManager(EndpointType endpointType) {
		super(
				"credential",
				"credentials",
				endpointType,
				new String[]{},
				new String[]{"ID", "Type", "user_id", "project_id", "blob"});
	}

	private ListResult fetchCredentials(Session session, String secType, String uid, String pid)
			throws JSONClientException, McClientJavaBizException, IOException {
		JSONObject query = new JSONObject();
		query.put("type", secType);
		query.put("scope", "system");
		query.put("user_id", uid);
		if (pid != null && pid.length() > 0) {
			query.put("project_id", pid);
		}
		return List(session, query);
	}

	public ListResult fetchAccessKeySecrets(Session session, String uid, String pid)
			throws JSONClientException, McClientJavaBizException, IOException {
		return fetchCredentials(session, ACCESS_SECRET_TYPE, uid, pid);
	}

	public ListResult fetchTotpSecrets(Session session, String uid)
			throws JSONClientException, McClientJavaBizException, IOException {
		return fetchCredentials(session, TOTP_TYPE, uid, "");
	}

	public ListResult fetchRecoverySecrets(Session session, String uid)
			throws JSONClientException, McClientJavaBizException, IOException {
		return fetchCredentials(session, RECOVERY_SECRETS_TYPE, uid, "");
	}
}
