package com.yunionyun.mcp.mcclient;

import com.yunionyun.mcp.mcclient.utils.StringUtils;

import junit.framework.TestCase;

public class StringUtilsTest extends TestCase {
	public void test() {
		System.out.println(StringUtils.Camel2Kebab("CPUTest", "-"));
		System.out.println(StringUtils.Camel2Kebab("GoogleTest", "-"));
		System.out.println(StringUtils.Camel2Kebab("AUTH_URL", "-"));
		System.out.println(StringUtils.Camel2Kebab("AuthURL", "-"));
		System.out.println(StringUtils.Camel2Kebab("kafka_in_msg.TestCount.Value", "-"));
		
		
		System.out.println(StringUtils.Kebab2Camel("cpu-Test", "-"));
	}
}
