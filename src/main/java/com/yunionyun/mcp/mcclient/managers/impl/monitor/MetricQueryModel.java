package com.yunionyun.mcp.mcclient.managers.impl.monitor;

import java.util.ArrayList;
import java.util.List;

public class MetricQueryModel {
	private String alias;
	private String measurement;
	private List<List<MetricQueryPart>> select;
	private List<MetricQueryModelTag> tags;
	private List<MetricQueryPart> groupBy;

	public MetricQueryModel(String measurement, List<List<MetricQueryPart>> select) {
		this.measurement = measurement;
		this.select = select;
	}

	private static List<MetricQueryPart> newSelect() {
		return new ArrayList<>();
	}

	public static MetricQueryModel newSingleField(String measurement, String field) {
		return newSingleFieldWithAlias(measurement, field, "");
	}

	public static MetricQueryModel newSingleFieldWithAlias(String measurement, String field, String alias) {
		List<MetricQueryPart> parts = newSelect();
		parts.add(MetricQueryPart.newField(field));
		if (alias != null && alias.length() != 0) {
			parts.add(MetricQueryPart.ALIAS(alias));
		}
		return newWithSelect(measurement, parts);
	}

	public static MetricQueryModel newWithSelect(String measurement, List<MetricQueryPart> singleSelect) {
		List<List<MetricQueryPart>> selects = new ArrayList<>();
		selects.add(singleSelect);
		return new MetricQueryModel(measurement, selects);
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public List<List<MetricQueryPart>> getSelect() {
		return select;
	}

	public void setSelect(List<List<MetricQueryPart>> select) {
		this.select = select;
	}

	public List<MetricQueryModelTag> getTags() {
		return tags;
	}

	public void setTags(List<MetricQueryModelTag> tags) {
		this.tags = tags;
	}

	public MetricQueryModel withTags(List<MetricQueryModelTag> tags) {
		this.setTags(tags);
		return this;
	}

	public List<MetricQueryPart> getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(List<MetricQueryPart> groupBy) {
		this.groupBy = groupBy;
	}

	public MetricQueryModel withGroupBy(List<MetricQueryPart> groupBy) {
		this.setGroupBy(groupBy);
		return this;
	}

}
