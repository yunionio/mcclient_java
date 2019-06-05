package com.yunionyun.mcp.mcclient.keystone;

import com.alibaba.fastjson.JSONObject;

public abstract class BaseDomainResource extends BaseResource
{
    private Domain domain;
    
    
    public Domain getDomain()
    {
        return this.domain;
    }
    
    @Override
    public void parseJSON(JSONObject obj) 
    {
        super.parseJSON(obj);
        domain = new Domain();
        domain.parseJSON(obj.getJSONObject("domain"));
    }
}
