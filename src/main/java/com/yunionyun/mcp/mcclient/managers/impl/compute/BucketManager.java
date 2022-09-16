package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.HttpHeaders;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class BucketManager extends ComputeManager {
	public BucketManager() {
		this(EndpointType.InternalURL);
	}

	public BucketManager(EndpointType endpointType) {
		super(
				"bucket",
				"buckets",
				endpointType,
				new String[]{
						"ID", "Name", "Storage_Class", "Status", "location", "acl", "region", "manager_id"
				},
				new String[]{});
	}

	public JSONObject upLoad(
			Session session,
			String bucketId,
			String key,
			InputStream body,
			long contLength,
			String storageClass,
			String acl,
			HttpHeaders headers)
			throws JSONClientException, IOException, NoSuchAlgorithmException, McClientJavaBizException,
			KeyManagementException {
		StringBuilder url = new StringBuilder();
		url.append("/");
		url.append(this.urlKey());
		url.append("/").append(bucketId);
		url.append("/upload");
		headers.set("X-Yunion-Bucket-Upload-Key", key);
		if (contLength > 0) {
			headers.set("Content-Length", String.valueOf(contLength));
		}
		if (storageClass != null && storageClass.length() > 0) {
			headers.set("X-Yunion-Bucket-Upload-Storageclass", storageClass);
		}
		if (acl != null && acl.length() > 0) {
			headers.set("X-Yunion-Bucket-Upload-Acl", acl);
		}
		return upload(session, url.toString(), headers, body);
	}
}
