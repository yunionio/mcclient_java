package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DNSRecordManager extends ComputeManager {
    public DNSRecordManager() {
        this(EndpointType.InternalURL);
    }

    public DNSRecordManager(EndpointType endpointType){
        super("dnsrecord", "dnsrecords",endpointType,
                new String[]{"ID", "Name", "Records", "TTL", "is_public"},
                new String[]{});
    }
}
