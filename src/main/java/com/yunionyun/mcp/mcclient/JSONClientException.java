package com.yunionyun.mcp.mcclient;

public class JSONClientException extends Exception {
	/** */
	private static final long serialVersionUID = -2733661415436825325L;

	private int code;
	private String errorClass;

	public JSONClientException(int code, String errCls, String msg) {
		super(msg);
		this.code = code;
		this.errorClass = errCls;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("(");
		builder.append(this.code);
		if (this.errorClass != null && this.errorClass.length() > 0) {
			builder.append("/");
			builder.append(errorClass);
		}
		builder.append(")");
		return builder.toString();
	}

	public int getCode() {
		return this.code;
	}
}
