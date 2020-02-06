package com.yunionyun.mcp.mcclient.entitys.schedulermanager;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zxc
 * @date 2020/02/05
 */
public class CandidateDisk {
    @JSONField(name = "index")
    private int index;

    @JSONField(name = "storage_ids")
    private String[] storageIds;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String[] getStorageIds() {
        return storageIds;
    }

    public void setStorageIds(String[] storageIds) {
        this.storageIds = storageIds;
    }
}
