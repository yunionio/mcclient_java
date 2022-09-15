package com.yunionyun.mcp.mcclient.managers.impl.meter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.managers.MeterManager;
import com.yunionyun.mcp.mcclient.utils.pricespec.ResourceSpec;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;


/**
 * @author zxc
 * @date 2020/01/18
 */
public class PriceInfoManager extends MeterManager {
	public PriceInfoManager() {
		this(EndpointType.InternalURL);
	}

	public PriceInfoManager(EndpointType endpointType) {
		super(
				"price_info",
				"price_infos",
				endpointType,
				new String[]{
						"provider",
						"currency",
						"sum_price",
						"spec",
						"quantity",
						"period",
						"price_key",
						"region_id"
				},
				new String[]{});
	}
	
	public JSONObject getPrice(Session s, ArrayList<ResourceSpec> specs) 
			throws McClientJavaBizException, IOException, JSONClientException {
		String[] queries = new String[specs.size()];
		for(int i = 0; i < specs.size(); i ++) {
			queries[i] = "price_keys=" + URLEncoder.encode(specs.get(i).GetPriceKey(), "utf8");
		}
		String url = "/price_infos/total?" + String.join("&", queries);
		System.out.println(url);
		return this._get(s, url, this.keyword);
	}
}
