package com.yunionyun.mcp.mcclient.managers.impl.monitor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetricQueryInput {
	private String from;
	private String to;
	private String scope;
	private String interval;
	private boolean skipCheckSeries;
	private String signature;

//	@JSONField(serialzeFeatures = SerializerFeature.BeanToArray, parseFeatures = Feature.SupportArrayToBean)
	private List<MetricQuery> metricQuery;

	private MetricQueryInput(List<MetricQuery> metricQuery) {
		this.metricQuery = metricQuery;
	}

	private MetricQueryInput() {
		this.metricQuery = new ArrayList<>();
	}

	public static MetricQueryInput newQuery(String from, String interval) {
		MetricQueryInput input = new MetricQueryInput();
		return input.withFrom(from).withInterval(interval);
	}

	public static MetricQueryInput newSingleMetricQuery(String measurement, String field) {
		return newSingleMetricQuery(measurement, field, "", "");
	}

	public static MetricQueryInput newSingleMetricQuery(String measurement, String field, String filterKey, String filterVal) {
		return newSingleMetricQuery(measurement, field, "", filterKey, filterVal);
	}

	public static MetricQueryInput newSingleMetricQuery(String measurement, String field, List<MetricQueryModelTag> tags, List<MetricQueryPart> groupBy) {
		return newSingleMetricQuery(MetricQuery.newMetricQuery(measurement, field, "", tags, groupBy));
	}

	private static MetricQueryInput newSingleMetricQuery(String measurement, String field, String alias, String filterKey, String filterVal) {
		return newSingleMetricQuery(MetricQuery.newMetricQuery(measurement, field, alias, filterKey, filterVal));
	}

	public static MetricQueryInput newSingleMetricQuery(String measurement, String field, String alias, List<MetricQueryModelTag> tags, List<MetricQueryPart> groupBy) {
		return newSingleMetricQuery(MetricQuery.newMetricQuery(measurement, field, alias, tags, groupBy));
	}

	public static MetricQueryInput newSingleMetricQuery(String measurement, List<MetricQueryPart> select, List<MetricQueryModelTag> tags, List<MetricQueryPart> groupBy) {
		return newSingleMetricQuery(MetricQuery.newMetricQuery(measurement, select, tags, groupBy));
	}

	public static MetricQueryInput newSingleMetricQuery(MetricQuery query) {
		return new MetricQueryInput(newSingleQuery(query));
	}

	public static List<MetricQuery> newSingleQuery(MetricQuery query) {
		List<MetricQuery> q = new ArrayList<>();
		q.add(query);
		return q;
	}

	public MetricQueryInput addMetric(MetricQuery q) {
		this.metricQuery.add(q);
		return this;
	}


	private MetricQueryInput addMetric(String measurement, String field, String alias, String filterKey, String filterValue) {
		MetricQuery query = MetricQuery.newMetricQuery(measurement, field, alias, filterKey, filterValue);
		return this.addMetric(query);
	}

	public MetricQueryInput addMetric(String measurement, String field) {
		return this.addMetric(measurement, field, "", "", "");
	}

	public MetricQueryInput addMetric(String measurement, String field, String filterKey, String filterValue) {
		return this.addMetric(measurement, field, "", filterKey, filterValue);
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public MetricQueryInput withFrom(String from) {
		setFrom(from);
		return this;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public MetricQueryInput withTo(String to) {
		setTo(to);
		return this;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public MetricQueryInput withScope(String scope) {
		setScope(scope);
		return this;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public MetricQueryInput withInterval(String interval) {
		this.setInterval(interval);
		return this;
	}

	public boolean isSkipCheckSeries() {
		return skipCheckSeries;
	}

	public void setSkipCheckSeries(boolean skipCheckSeries) {
		this.skipCheckSeries = skipCheckSeries;
	}

	public MetricQueryInput skipCheckSeries(boolean skipCheckSeries) {
		this.setSkipCheckSeries(skipCheckSeries);
		return this;
	}

	public String getSignature() {
		return signature;
	}

	private String calculateSignature() {
		JSONObject object = this._toJSONObject();
		object.remove("signature");
		String data = object.toJSONString(object, SerializerFeature.MapSortField);
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
			StringBuilder hexStr = new StringBuilder();
			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					hexStr.append('0');
				}
				hexStr.append(hex);
			}
			return hexStr.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public List<MetricQuery> getMetricQuery() {
		return metricQuery;
	}

	private JSONObject _toJSONObject() {
		SerializeConfig config = new SerializeConfig();
		config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;

		return (JSONObject) JSON.toJSON(this, config);
	}

	public JSONObject toJSONObject() {
		SerializeConfig config = new SerializeConfig();
		config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
		this.signature = this.calculateSignature();

		return (JSONObject) JSON.toJSON(this, config);
	}

}
