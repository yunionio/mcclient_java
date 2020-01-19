package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.AnsibleManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class AnsiblePlaybookManager extends AnsibleManager {
    public AnsiblePlaybookManager(){
        this(EndpointType.InternalURL);
    }
    public AnsiblePlaybookManager(EndpointType endpointType){
        super("ansibleplaybook", "ansibleplaybooks",endpointType,
                new String[]{ "id", "name", "status", "start_time", "end_time"},
                new String[]{});
    }

}
