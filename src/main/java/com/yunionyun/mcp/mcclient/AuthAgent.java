package com.yunionyun.mcp.mcclient;

import java.util.Timer;
import java.util.TimerTask;

import com.yunionyun.mcp.mcclient.keystone.TokenCredential;

public class AuthAgent {
	private Client client;
	private String domain;
	private String user;
	private String passwd;
	private String project;
	private TokenCredential adminToken;
	private Cache<TokenCredential> tokenCache;
	private int checkPeriodSeconds;
	
	public AuthAgent(String authUrl, String domain, String user, String passwd, String project, int cacheSize, int timeout, boolean debug, boolean insecure) {
		this.client = new Client(authUrl, timeout, debug, insecure);
		this.domain = domain;
		this.user = user;
		this.passwd = passwd;
		this.project = project;
		this.tokenCache = new Cache<TokenCredential>(cacheSize);
		this.checkPeriodSeconds = 300;  // every 5 mintues
	}
	
	public void refreshAdminToken() {
		if (this.adminToken == null || this.adminToken.expireSeconds() < 3600) {
			try {
				TokenCredential adminToken = this.client.Authenticate(this.user, this.passwd, this.domain, this.project);
				this.adminToken = adminToken;
			}catch(Exception e) {
				System.out.println("Fail to get adminToken");
			}
		}
	}
	
	public void start() {
		final AuthAgent self = this;
		TimerTask task = new TimerTask() {
			public void run() {
				self.refreshAdminToken();
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 0, this.checkPeriodSeconds*1000);
	}

	public TokenCredential verify(String token) {
		if (this.adminToken == null || !this.adminToken.isValid()) {
			return null;
		}
		TokenCredential cred = this.tokenCache.get(token);
		if (cred != null) {
			return cred;
		}
		cred = this._verify(token);
		if (cred != null) {
			this.tokenCache.set(token, cred);
		}
		return cred;
	}
	
	private TokenCredential _verify(String token) {
		try {
			return this.client.Verify(this.adminToken.getToken(), token);
		}catch(Exception e) {
			return null;
		}
	}
}
