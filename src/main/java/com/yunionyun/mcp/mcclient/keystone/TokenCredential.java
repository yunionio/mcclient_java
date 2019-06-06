package com.yunionyun.mcp.mcclient.keystone;

import java.util.Date;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.Utils;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;

public class TokenCredential {
    private final static Logger logger = LoggerFactory.getLogger(TokenCredential.class);
    
	private String token;
	private User user;
	private Project project;
	private Role[] roles;
	private Service[] services;
	private Date expires;
	
	public TokenCredential(String token) {
		this.token = token;
	}
	
	public void parseJSON(JSONObject result) {
		JSONObject token = result.getJSONObject("token");
		try {
			expires = Utils.string2Date(token.getString("expires_at"));
		} catch (Exception e) {
		    logger.error("parse date error " + e);
		}
		user = new User();
		user.parseJSON(token.getJSONObject("user"));
		project = new Project();
		project.parseJSON(token.getJSONObject("project"));
		JSONArray rolesJSON = token.getJSONArray("roles");
		roles = new Role[rolesJSON.size()];
		for (int i = 0; i < rolesJSON.size(); i ++) {
			roles[i] = new Role();
			roles[i].parseJSON(rolesJSON.getJSONObject(i));
		}
		JSONArray serviceJSON = token.getJSONArray("catalog");
		services = new Service[serviceJSON.size()];
		for (int i = 0; i < serviceJSON.size(); i ++) {
			services[i] = new Service();
			services[i].parseJSON(serviceJSON.getJSONObject(i));
		}
	}
	
	public String getToken() {
		return this.token;
	}
	
	public String getUserId() {
		return this.user.getId();
	}
	
	public String getUserName() {
		return this.user.getName();
	}
	
	public String getDomainId() {
		return this.user.getDomain().getId();
	}
	
	public String getDomainName() {
		return this.user.getDomain().getName();
	}
	
	public String getProjectDomainId() {
	    return this.project.getDomain().getId();
	}
	
	public String getProjectDomainName() {
	    return this.project.getDomain().getName();
	}
	
	public String getProjectId() {
		return this.project.getId();
	}
	
	public String getProjectName() {
		return this.project.getName();
	}
	
	public boolean isValid() {
		Date now = new Date();
		return this.expires.after(now);
	}
	
	public Date getExpires() {
		return this.expires;
	}
	
	public String[] getRoles() {
		String[] roles = new String[this.roles.length];
		for (int i = 0; i < roles.length; i ++) {
			roles[i] = this.roles[i].getName();
		}
		return roles;
	}
	
	public String[] getRegions() {
		HashSet<String> regionSet = new HashSet<String>();
		for (int i = 0; i < this.services.length; i ++) {
			services[i].addRegions(regionSet);
		}
		String[] regions = new String[regionSet.size()];
		return regionSet.toArray(regions);
	}
	
	public String[] getServiceUrls(String service, String region, String zone, EndpointType endpointType) throws McClientJavaBizException {
		for (int i = 0; i < this.services.length; i ++) {
			if (this.services[i].getType().equals(service)) {
				return this.services[i].getServiceUrls(region, zone, endpointType);
			}
		}
		throw new McClientJavaBizException("No service URL found for " + service + " " + endpointType + " " + Endpoint.RegionID(region, zone));
	}
	
	public String getServiceUrl(String service, String region, String zone, EndpointType endpointType) throws McClientJavaBizException {
		for (int i = 0; i < this.services.length; i ++) {
			if (this.services[i].getType().equals(service)) {
				return this.services[i].getServiceUrl(region, zone, endpointType);
			}
		}
		throw new McClientJavaBizException("No service URL found for " + service + " " + endpointType + " " + Endpoint.RegionID(region, zone));
	}
	
	public boolean isAdmin() {
		String[] roles = this.getRoles();
		for (int i = 0; i < roles.length; i ++) {
			if (roles[i].equals("admin")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isSystemAdmin() {
		return (this.getProjectName().equals("system") && this.isAdmin());
	}
	
	public long expireSeconds() {
		Date now = new Date();
		return this.expires.getTime() - now.getTime();
	}
}
