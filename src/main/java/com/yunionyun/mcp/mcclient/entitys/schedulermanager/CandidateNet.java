package com.yunionyun.mcp.mcclient.entitys.schedulermanager;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zxc
 * @date 2020/02/05
 */
public class CandidateNet {
    @JSONField(name = "index")
    private String index;

    @JSONField(name = "network_ids")
    private String networkIds;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getNetworkIds() {
        return networkIds;
    }

    public void setNetworkIds(String networkIds) {
        this.networkIds = networkIds;
    }
}
