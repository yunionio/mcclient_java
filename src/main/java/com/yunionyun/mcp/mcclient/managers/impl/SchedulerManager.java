package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.entitys.schedulermanager.ScheduleInput;
import com.yunionyun.mcp.mcclient.entitys.schedulermanager.ScheduleOutput;
import com.yunionyun.mcp.mcclient.managers.BaseSchedulerManager;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SchedulerManager extends BaseSchedulerManager {
	public SchedulerManager() {
		this(EndpointType.InternalURL);
	}

	public SchedulerManager(EndpointType endpointType) {
		super("scheduler", "schedulers", endpointType, new String[]{}, new String[]{});
	}

	public ScheduleOutput doSchedule(Session session, ScheduleInput input, int count)
			throws JSONClientException, McClientJavaBizException, IOException {
		StringBuilder url = new StringBuilder("/");
		url.append(this.keyword);
		if (count <= 0) {
			count = 1;
		}
		input.setCount(count);
		JSONObject body = JSONObject.parseObject(JSONObject.toJSONString(input));
		JSONObject rtn = this._post(session, url.toString(), body, "");
		ScheduleOutput scheduleOutput = rtn.toJavaObject(ScheduleOutput.class);
		return scheduleOutput;
	}

	public JSONObject doForecast(Session session, JSONObject params)
			throws JSONClientException, McClientJavaBizException, IOException {
		String projectId = session.getProjectId();
		String domainId = session.getProjectDomainId();
		String cliProjectId = null;
		if (params != null) {
			cliProjectId = params.getString("project_id");
		} else {
			params = new JSONObject();
		}
		if (cliProjectId != null && cliProjectId != "") {
			projectId = cliProjectId;
			domainId = "";
		}
		if (domainId == "") {
			ProjectManager projectManager = new ProjectManager(this.getEndpontType());
			JSONObject rtn = projectManager.Get(session, projectId, null);
			domainId = rtn.getString("domain_id");
		}
		params.put("domain_id", domainId);
		params.put("project_id", projectId);
		String url = newSchedURL("forecast");
		return this.jsonRequest(session, "POST", url, null, params);
	}

	private String newSchedURL(String action) {
		return String.format("/scheduler/%s", action);
	}
}
