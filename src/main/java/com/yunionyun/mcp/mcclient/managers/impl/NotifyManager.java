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
	
	/**
	 * 发送消息
	 * 
	 * @param s
	 * @param uid
	 * @param contact_type
	 * @param topic
	 * @param priority
	 * @param msg
	 * @return String 返回消息发送任务的ID
	 */
	public String notify(Session s, String uid, NotifyContactType contact_type, String topic, NotifyPriority priority, String msg) {
		JSONObject params = new JSONObject();
		params.put("uid", uid);
		params.put("contact_type", contact_type.String());
		params.put("topic", topic);
		params.put("priority", priority.String());
		params.put("msg", msg);
		try {
			JSONObject ret = super.Create(s, params);
			return ret.getString("id");
		}catch(Exception e) {
			return null;
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
	
	/**
	 * 更改发送任务状态为成功
	 * 
	 * @param s
	 * @param id 发送任务ID
	 * @return
	 */
	public boolean sendOk(Session s, String id) {
		return _sendStatus(s, id, "sent_ok", null);
	}
	
	/**
	 * 更改发送任务状态为失败
	 * 
	 * @param s
	 * @param id 发送任务ID
	 * @param reason 失败原因
	 * @return
	 */
	public boolean sendFail(Session s, String id, String reason) {
		return _sendStatus(s, id, "sent_fail", reason);
	}
}
