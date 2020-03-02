package com.yunionyun.mcp.mcclient;

import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import org.slf4j.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class AuthAgent {
	private static Logger logger = LoggerUtils.createLoggerFor(AuthAgent.class.getName());
	private Client client;
	private String domain;
	private String user;
	private String passwd;
	private String project;
	private TokenCredential adminToken;
	private Cache<TokenCredential> tokenCache;
	private int checkPeriodSeconds;

	public AuthAgent(
			String authUrl,
			String domain,
			String user,
			String passwd,
			String project,
			int cacheSize,
			int timeout,
			boolean debug,
			boolean insecure) {
		this.client = new Client(authUrl, timeout, debug, insecure);
		this.domain = domain;
		this.user = user;
		this.passwd = passwd;
		this.project = project;
		this.tokenCache = new Cache<TokenCredential>(cacheSize);
		this.checkPeriodSeconds = 300; // every 5 mintues
	}

	private void refreshAdminToken() {
		if (this.adminToken == null || this.adminToken.expireSeconds() < 3600) {
			try {
				TokenCredential adminToken =
						this.client.Authenticate(this.user, this.passwd, this.domain, this.project);
				this.adminToken = adminToken;
			} catch (Exception e) {
				logger.error("Fail to get adminToken");
			}
		}
	}

	public void start_sync_ready() {
		while (this.adminToken == null) {
			this.refreshAdminToken();
			if (this.adminToken == null) {
				try {
					Thread.sleep(2000); //
				} catch (Exception e) {
					logger.error("Fail to sleep???");
				}
			}
		}
		this.start();
	}

	public void start() {
		final AuthAgent self = this;
		TimerTask task =
				new TimerTask() {
					public void run() {
						self.refreshAdminToken();
					}
				};
		Timer timer = new Timer();
		timer.schedule(task, 0, this.checkPeriodSeconds * 1000);
	}

	public Session getAdminSession(
			String region, String zone, EndpointType endpointType, String apiVersion) {
		return this.client.newSession(region, zone, endpointType, this.adminToken, apiVersion);
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
		} catch (Exception e) {
			return null;
		}
	}
}
