package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class KeypairManager extends ComputeManager {
    public KeypairManager() {
        this(EndpointType.InternalURL);
    }

    public KeypairManager(EndpointType endpointType){
        super("keypair", "keypairs", endpointType,
                new String[]{"ID", "Name", "Scheme", "Fingerprint", "Created_at", "Private_key_len", "Description", "Linked_guest_count"},
                new String[]{});
    }
}
