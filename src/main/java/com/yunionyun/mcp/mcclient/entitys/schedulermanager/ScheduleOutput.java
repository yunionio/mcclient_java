package com.yunionyun.mcp.mcclient.entitys.schedulermanager;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zxc
 * @date 2020/02/05
 */
public class ScheduleOutput {
	@JSONField(name = "candidates")
	private CandidateResource[] candidates;

	public CandidateResource[] getCandidates() {
		return candidates;
	}

	public void setCandidates(CandidateResource[] candidates) {
		this.candidates = candidates;
	}
}
