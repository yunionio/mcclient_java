package com.yunionyun.mcp.mcclient.managers.impl;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class ServerManager extends ComputeManager
{
    public ServerManager()
    {
        super("server", "servers", new String[] { "ID", "Name", "Billing_type", "IPs", "Disk", "Status", "vcpu_count", "vmem_size", "ext_bw", "Zone_name", "Secgroup", "Secgrp_id", "vrouter",
                "vrouter_id", "Created_at", "Group_name", "Group_id", "Hypervisor" }, new String[] { "Host", "Tenant", "is_system" });
    }
    
    
    public JSONObject changeConfig(Session session, String id, JSONObject body) throws McClientJavaBizException, IOException, JSONClientException
    {
        StringBuilder url = new StringBuilder();
        url.append("/");
        url.append(this.keywordPlural);
        url.append("/");
        url.append(id);
        url.append("/change-config");
        
        return this._post(session, url.toString(), body, this.keyword);
    }
}
