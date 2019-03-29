package com.yunionyun.mcp.mcclient.managers.impl;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;
import com.yunionyun.mcp.mcclient.managers.ManagerContext;

public class MonitorAlarmEventManager extends BaseMonitorManager
{
    
    public MonitorAlarmEventManager()
    {
        super("alarm_event", "alarm_events",
                new String[] { "id", "node_labels", "metric_name", "host_name", "host_ip", "alarm_level", "alarm_condition", "template", "first_alarm_time", "last_alarm_time", "alarm_status", "alarm_times", "ack_time", "ack_status", "ack_wait_time", "upgrade_time", "upgrade_status", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark" }, 
                new String[] {});
    }
    
    public void batchSubmit(Session s, List<JSONObject> list) throws McClientJavaBizException, IOException, JSONClientException 
    {
        JSONObject params = buildBatchParam(list);
        
        StringBuilder url = this.getContextPath(new ManagerContext[] {});
        url.append(this.urlKey());
        
        this._post(s, url.toString(), params, null);
    }

    public void batchUpdate(Session s, List<JSONObject> list) throws McClientJavaBizException, IOException, JSONClientException
    {
        JSONObject params = buildBatchParam(list);
        
        StringBuilder url = this.getContextPath(new ManagerContext[] {});
        url.append(this.urlKey());
        
        this._put(s, url.toString(), params, null);
    }

    private JSONObject buildBatchParam(List<JSONObject> list)
    {
        JSONArray alarmEvents = new JSONArray();
        for (JSONObject item : list)
        {
            alarmEvents.add(item);
        }
        
        JSONObject params = new JSONObject();
        params.put("alarm_events", alarmEvents);
        return params;
    }
}
