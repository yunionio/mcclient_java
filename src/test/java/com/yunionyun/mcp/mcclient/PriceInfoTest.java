package com.yunionyun.mcp.mcclient;

import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.PriceInfoManager;
import com.yunionyun.mcp.mcclient.utils.pricespec.InstanceSpec;

import junit.framework.TestCase;

public class PriceInfoTest extends TestCase {
	public void test() {
		Client cli = new Client("https://192.168.222.171:30500/v3", 1000, true, true);
		try {
			TokenCredential token = cli.Authenticate("user", "password0", "Yunion", "system");
			Session s = cli.newSession("YunionHQ", null, EndpointType.PublicURL, token, "");
			PriceInfoManager priceman = new PriceInfoManager();
			InstanceSpec is = new InstanceSpec("Qcloud", "ap-beijing", "ap-beijing-1", "S1.LARGE4", "CLOUD_PREMIUM", 50);
			System.out.println(priceman.getPrice(s, is.getSpecs()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
