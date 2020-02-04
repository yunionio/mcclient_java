package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class PriceInfoManager extends MeterManager {
    public PriceInfoManager() {
        this(EndpointType.InternalURL);
    }

    public PriceInfoManager(EndpointType endpointType){
        super("price_info", "price_infos", endpointType,
                new String[]{"provider", "currency", "sum_price", "spec", "quantity", "period", "price_key", "region_id"},
                new String[]{});
    }
}
