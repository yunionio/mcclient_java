package com.yunionyun.mcp.mcclient.managers.impl;

import org.json.JSONObject;

import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.BaseNotifyManager;


public class NotifyManager extends BaseNotifyManager {
	
	public NotifyManager() {
		super("notification", "notifications",
				new String[] {"id", "uid", "contact_type", "topic", "priority", "msg", "status"},
				new String[] {});
	}
	
	
	private static class NotifyMetadata {
		private String rep;
		
		NotifyMetadata(String rep) {
			this.rep = rep;
		}
		
		public String String() {
			return this.rep;
		}
	}
	
	public static class NotifyContactType extends NotifyMetadata {
		private NotifyContactType(String rep) {
			super(rep);
		}
	}
	
	public static class NotifyPriority extends NotifyMetadata {
		private NotifyPriority(String rep) {
			super(rep);
		}
	}
	
	public static final NotifyContactType CONTACT_MOBILE;
	public static final NotifyContactType CONTACT_EMAIL;
	public static final NotifyContactType CONTACT_DINGTALK;
	
	public static final NotifyPriority PRIORITY_NORMAL;
	public static final NotifyPriority PRIORITY_IMPORTANT;
	public static final NotifyPriority PRIORITY_FATAL;

	static {
		CONTACT_MOBILE = new NotifyContactType("mobile");
		CONTACT_EMAIL = new NotifyContactType("email");
		CONTACT_DINGTALK = new NotifyContactType("dingtalk");
		
		PRIORITY_NORMAL = new NotifyPriority("normal");
		PRIORITY_IMPORTANT = new NotifyPriority("important");
		PRIORITY_FATAL = new NotifyPriority("fatal");
	}
	
	public boolean notify(Session s, String uid, NotifyContactType contact_type, String topic, NotifyPriority priority, String msg) {
		JSONObject params = new JSONObject();
		params.put("uid", uid);
		params.put("contact_type", contact_type.String());
		params.put("topic", topic);
		params.put("priority", priority.String());
		params.put("msg", msg);
		try {
			super.Create(s, params);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	private boolean _sendStatus(Session s, String id, String status, String reason) {
		JSONObject params = new JSONObject();
		params.put("status", "sent_ok");
		if (reason != null && reason.length() > 0) {
			params.put("remark", reason);
		}
		try {
			super.Update(s, id, params);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean sendOk(Session s, String id) {
		return _sendStatus(s, id, "sent_ok", null);
	}
	
	public boolean sendFail(Session s, String id, String reason) {
		return _sendStatus(s, id, "sent_fail", reason);
	}
}
