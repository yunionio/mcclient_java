package com.yunionyun.mcp.mcclient.managers.impl.monitor;

import java.util.ArrayList;
import java.util.List;

public class MetricQuery {
	private MetricQueryModel model;

	public MetricQuery(MetricQueryModel model) {
		this.model = model;
	}

	public static MetricQuery newMetricQuery(String measurement, String field) {
		return newMetricQuery(measurement, field, "", "");
	}

	public static MetricQuery newMetricQuery(String measurement, String field, String filterKey, String filterVal) {
		return newMetricQuery(measurement, field, "", filterKey, filterVal);
	}

	public static MetricQuery newMetricQuery(String measurement, String field, String alias, String filterKey, String filterVal) {
		List<MetricQueryModelTag> tags = new ArrayList<>();
		if (filterKey != null && !filterKey.isEmpty()) {
			tags.add(MetricQueryModelTag.Equal(filterKey, filterVal));
		}
		return newMetricQuery(measurement, field, alias, tags, null);
	}

	public static MetricQuery newMetricQuery(String measurement, String field, String alias, List<MetricQueryModelTag> tags, List<MetricQueryPart> groupBy) {
		MetricQueryModel model = MetricQueryModel.newSingleFieldWithAlias(measurement, field, alias);
		return new MetricQuery(model.withTags(tags).withGroupBy(groupBy));
	}

	public static MetricQuery newMetricQuery(String measurement, List<MetricQueryPart> select, List<MetricQueryModelTag> tags, List<MetricQueryPart> groupBy) {
		MetricQueryModel model = MetricQueryModel.newWithSelect(measurement, select);
		model.withTags(tags).withGroupBy(groupBy);
		return new MetricQuery(model);
	}

	public MetricQueryModel getModel() {
		return model;
	}
}
