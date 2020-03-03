package com.yunionyun.mcp.mcclient.entitys.schedulermanager;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zxc
 * @date 2020/02/05
 */
public class CandidateResource {
	@JSONField(name = "session_id")
	private String sessionId;

	@JSONField(name = "host_id")
	private String hostId;

	@JSONField(name = "name")
	private String name;

	@JSONField(name = "disks")
	private CandidateDisk[] disks;

	@JSONField(name = "nets")
	private CandidateNet[] nets;

	@JSONField(name = "backup_candidate")
	private CandidateResource backupCandidate;

	@JSONField(name = "error")
	private String error;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CandidateDisk[] getDisks() {
		return disks;
	}

	public void setDisks(CandidateDisk[] disks) {
		this.disks = disks;
	}

	public CandidateNet[] getNets() {
		return nets;
	}

	public void setNets(CandidateNet[] nets) {
		this.nets = nets;
	}

	public CandidateResource getBackupCandidate() {
		return backupCandidate;
	}

	public void setBackupCandidate(CandidateResource backupCandidate) {
		this.backupCandidate = backupCandidate;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
