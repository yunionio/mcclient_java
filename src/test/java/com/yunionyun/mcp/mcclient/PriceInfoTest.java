package com.yunionyun.mcp.mcclient;

import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.PriceInfoManager;
import com.yunionyun.mcp.mcclient.utils.pricespec.InstanceSpec;
import com.yunionyun.mcp.mcclient.utils.pricespec.RdsSpec;
import com.yunionyun.mcp.mcclient.utils.pricespec.RedisSpec;

import junit.framework.TestCase;

public class PriceInfoTest extends TestCase {
	public void test() {
		Client cli = new Client("https://192.168.222.171:30500/v3", 1000, true, true);
		try {
			TokenCredential token = cli.Authenticate("user", "password0", "Yunion", "system", "");
			Session s = cli.newSession("YunionHQ", null, EndpointType.PublicURL, token);
			PriceInfoManager priceman = new PriceInfoManager();
			InstanceSpec is = new InstanceSpec("Qcloud", "ap-beijing", "ap-beijing-1", "S1.LARGE4", "CLOUD_PREMIUM", 50);
			System.out.println(priceman.getPrice(s, is.getSpecs()));
			RdsSpec rdsSpec = new RdsSpec("Aliyun", "cn-beijing", "", "mariadb.n2.medium.2c",
					"high_availability_MariaDB_cloud_ssd", 50);
			System.out.println(priceman.getPrice(s, rdsSpec.getSpecs()));
			RedisSpec redisSpec = new RedisSpec("Huawei", "cn-north-1", "cn-north-1b",
					"redis.ha.xu1.large.r5.1:m1g:v4.0");
			System.out.println(priceman.getPrice(s, redisSpec.getSpecs()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
