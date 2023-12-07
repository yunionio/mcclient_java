package com.yunionyun.mcp.mcclient.managers.impl.monitor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;

public class MetricQueryInputTest extends TestCase {

	private void testQuery1(MetricQueryInput input) {
		JSONObject obj = input.toJSONObject();
		System.out.println(obj.toString());
		assertTrue(obj.getBoolean("skip_check_series"));
		JSONArray queries = obj.getJSONArray("metric_query");
		assertEquals(queries.size(), 1);

		JSONObject query = (JSONObject) queries.get(0);
		JSONObject model = query.getJSONObject("model");
		assertEquals(model.getString("measurement"), "vm_cpu");
	}

	public void testToJSONObject() {
		MetricQueryInput input = MetricQueryInput.newSingleMetricQuery("vm_cpu", "usage_active", "vm_id", "abcd");
		input.setSkipCheckSeries(true);
		testQuery1(input);

		input = MetricQueryInput.newQuery("24h", "5m");
		input.skipCheckSeries(true).addMetric("vm_cpu", "usage_active", "vm_id", "ab9502de-c6b6-4150-880b-d0e3e6ba8ec8");
		testQuery1(input);
	}
}