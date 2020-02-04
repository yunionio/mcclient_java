package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class BillConditionManager extends MeterManager {
    public BillConditionManager() {
       this(EndpointType.InternalURL);
    }

    public BillConditionManager(EndpointType endpointType) {
        super("bill_condition", "bill_conditions",endpointType,
                new String[]{"item_id", "item_name"},
                new String[]{});
    }
}
