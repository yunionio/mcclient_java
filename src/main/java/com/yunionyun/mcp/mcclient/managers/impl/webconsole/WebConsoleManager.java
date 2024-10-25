package com.yunionyun.mcp.mcclient.managers.impl.webconsole;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseWebConsoleManager;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.*;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.compute.ContainerManager;
import com.yunionyun.mcp.mcclient.managers.impl.compute.ServerManager;
import com.yunionyun.mcp.mcclient.managers.impl.k8s.KubeClusterManager;
import com.yunionyun.mcp.mcclient.managers.impl.k8s.PodManager;
import com.yunionyun.mcp.mcclient.utils.StringUtils;

import java.io.IOException;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class WebConsoleManager extends BaseWebConsoleManager {
	public WebConsoleManager() {
		this(EndpointType.InternalURL);
	}

	public WebConsoleManager(EndpointType endpointType) {
		super("webconsole", "webconsole", endpointType, new String[]{}, new String[]{});
	}

	public JSONObject DoConnect(Session s, String connType, String id, String action, JSONObject params)
		throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = new StringBuilder();
		url.append("/webconsole/");
		url.append(connType);
		if (id != null && id.length() > 0) {
			url.append("/");
			url.append(id);
		}
		if (action != null && action.length() > 0) {
			url.append("/");
			url.append(action);
		}
		JSONObject body = new JSONObject();
		if (params != null) {
			body.put("webconsole", params);
		}
		System.out.println(url.toString() + body.toString());
		return this._post(s, url.toString(), body, "webconsole");
	}

	/**
	 * @param s			Session, client session, required
	 * @param id		Id of server to connect, required
	 * @param ip    	IP to connect, optional for server with single IP
	 * @param port  	Port number to connect, optional if the port is 22
	 * @param username 	username to login, optional
	 * @param password 	password for the user, optional
	 */
	public JSONObject DoSshConnect(Session s, String id, String ip, int port, String username, String password)
		throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject params = new JSONObject();
		if (ip != null && ip.length() > 0) {
			params.put("ip", ip);
		}
		if (port > 0) {
			params.put("port", port);
		}
		if (username != null && username.length() > 0) {
			params.put("username", username);
		}
		if (password != null && password.length() > 0) {
			params.put("password", password);
		}
		return this.DoConnect(s, "ssh", id, "", params);
	}

	/**
	 * @param s			Session, client session, required
	 * @param id		Id of server to connect, required
	 * @param host    	Host to connect, optional for server with single IP
	 * @param port  	Port number to connect, optional if the port is 3389
	 * @param username 	username to login, optional
	 * @param password 	password for the user, optional
	 */
	public JSONObject DoRdpConnect(Session s, String id, String ip, int port, String username, String password)
		throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject params = new JSONObject();
		if (ip != null && ip.length() > 0) {
			params.put("host", ip);
		}
		if (port > 0) {
			params.put("port", port);
		}
		if (username != null && username.length() > 0) {
			params.put("username", username);
		}
		if (password != null && password.length() > 0) {
			params.put("password", password);
		}
		return this.DoConnect(s, "server-rdp", id, "", params);
	}

	public JSONObject DoContainerExec(Session s, String ctrId) throws JSONClientException, McClientJavaBizException, IOException {
		ContainerManager containers = new ContainerManager();
		ServerManager servers = new ServerManager();
		JSONObject obj = containers.Get(s, ctrId, null);
		String containerName = obj.getString("name");
		String serverId = obj.getString("guest_id");
		JSONObject serverObj = servers.Get(s, serverId, null);

		K8sShellDisplayInfo info = new K8sShellDisplayInfo(
				serverObj.getString("name") + "/" + containerName,
				Arrays.asList(serverObj.getString("ips")));
		List<String> args = Arrays.asList("container-exec", ctrId, "sh");

		return DoCloudShell(s, info, "/opt/yunion/bin/climc", args);
	}

	class K8sShellDisplayInfo {
		@JSONField(name="instanceName")
		public String instanceName;
		@JSONField(name="ips")
		public List<String> IPs;

		public K8sShellDisplayInfo(String instanceName, List<String> IPs) {
			this.instanceName = instanceName;
			this.IPs = IPs;
		}
	}

	class K8sShellRequest {
		@JSONField(name = "display_info")
		public K8sShellDisplayInfo DisplayInfo;
		public String cluster;
		public String namespace;
		public String container;
		public String command;
		public List<String> args;
		public Map<String, String> env;

		public K8sShellRequest(String cluster, String namespace, String container, String command, List<String> args, Map<String, String> env) {
			this.cluster = cluster;
			this.namespace = namespace;
			this.container = container;
			this.command = command;
			this.args = args;
			this.env = env;
		}
	}

	public JSONObject DoCloudShell(Session s, K8sShellDisplayInfo info, String cmd, List<String> args) throws JSONClientException, McClientJavaBizException, IOException {
		ClimcPodInfo podInfo = getClimcPodInfo(s);

		Map<String, String> env = new HashMap<>();
		env.put("OS_AUTH_TOKEN", s.getToken().getToken());
		env.put("OS_PROJECT_NAME", s.getToken().getProjectName());
		env.put("OS_PROJECT_DOMAIN", s.getToken().getProjectDomainName());
		env.put("YUNION_USE_CACHED_TOKEN", "false");
		env.put("YUNION_INSECURE", "true");
		env.put("OS_USERNAME", "");
		env.put("OS_PASSWORD", "");
		env.put("OS_DOMAIN_NAME", "");
		env.put("OS_ACCESS_KEY", "");
		env.put("OS_SECRET_KEY", "");
		env.put("OS_TRY_TERM_WIDTH", "false");

		K8sShellRequest req = new K8sShellRequest(podInfo.clusterId, podInfo.namespace, "climc", cmd, args, env);
		req.DisplayInfo = info;
		return DoK8sConnect(s, podInfo.name, "shell", (JSONObject) JSON.toJSON(req));
	}

	ClimcPodInfo getClimcPodInfo(Session s) throws JSONClientException, McClientJavaBizException, IOException {
		JSONObject query = new JSONObject();
		query.put("system", true);
		query.put("scope", "system");
		query.put("name", "system-default");
		KubeClusterManager clusters = new KubeClusterManager();
		ListResult list = clusters.List(s, query);
		if (list.getDataSize() == 0) {
			throw new JSONClientException(404, "NotFound", "not found system cluster");
		}
		JSONObject clusterObj = list.getDataAt(0);
		query = new JSONObject();
		query.put("cluster", clusterObj.getString("id"));
		query.put("namespace", "onecloud");
		query.put("scope", "system");
		query.put("search", "climc");
		query.put("details", true);
		PodManager pods = new PodManager();
		ListResult podObjs = pods.List(s, query);
		if (podObjs.getDataSize() == 0) {
			throw new JSONClientException(404, "NotFound", "not found climc pod");
		}
		JSONObject pod = podObjs.getDataAt(0);
		return new ClimcPodInfo(pod.getString("name"), "onecloud", clusterObj.getString("id"));
	}

	public JSONObject DoK8sConnect(Session s, String id, String action, JSONObject params) throws JSONClientException, McClientJavaBizException, IOException {
		return this.DoConnect(s, "k8s", id, action, params);
	}

	private class ClimcPodInfo {
		String name;
		String namespace;
		String clusterId;

		public ClimcPodInfo(String name, String namespace, String clusterId) {
			this.name = name;
			this.namespace = namespace;
			this.clusterId = clusterId;
		}
	}
}
