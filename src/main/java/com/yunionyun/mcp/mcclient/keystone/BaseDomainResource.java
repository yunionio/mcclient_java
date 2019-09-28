package com.yunionyun.mcp.mcclient.keystone;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zxc
 * @date 2019/09/26
 */


public abstract class BaseDomainResource extends BaseResource {
    private Domain domain;

    public BaseDomainResource() {
    }

    public Domain getDomain() {
        return this.domain;
    }

    public void parseJSON(JSONObject obj) {
        super.parseJSON(obj);
        this.domain = new Domain();
        this.domain.parseJSON(obj.getJSONObject("domain"));
    }
}
