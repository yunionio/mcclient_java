package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;
import com.yunionyun.mcp.mcclient.utils.CodecUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DBInstanceAccountManager extends ComputeManager {
	public DBInstanceAccountManager() {
		this(EndpointType.InternalURL);
	}

	public DBInstanceAccountManager(EndpointType endpointType) {
		super(
				"dbinstanceaccount",
				"dbinstanceaccounts",
				endpointType,
				new String[]{"ID", "Name", "DBInstance_id", "Status", "Dbinstanceprivileges"},
				new String[]{});
	}

	public JSONObject getLoginInfo(Session session, String id, JSONObject query)
			throws JSONClientException, McClientJavaBizException, IOException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException,
			BadPaddingException, InvalidKeyException {
		JSONObject data = Get(session, id, null);
		String password = CodecUtils.decryptAESBase64(data.getString("secret"), data.getString("id"));
		JSONObject rtn = new JSONObject();
		rtn.put("accout", data.get("name"));
		rtn.put("password", password);
		return rtn;
	}
}
