package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.MonitorAlarmEventManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AlarmEventTest extends TestCase {
  private static Logger logger = LoggerUtils.createLoggerFor(AlarmEventTest.class.getName());

  public void testBatchInsert() {
    Client cli = new Client("http://10.168.222.251:35357/v3", 5000, true, true);
    try {
      TokenCredential token = cli.Authenticate("sysadmin", "MxqhTC2VKe067jtD", "Default", "system");
      logger.info(token.toString());
      logger.debug(token.toString());
      Session s = cli.newSession("LocalTest", null, null, token, "");

      MonitorAlarmEventManager manager = new MonitorAlarmEventManager();

      JSONObject p1 = new JSONObject();
      p1.put("metric_name", "cpu.usage_user");
      p1.put("host_name", "tony.test1");
      p1.put("host_ip", "1.2.3.4");
      p1.put("alarm_level", "NORMAL");
      p1.put("alarm_condition", "{\"duration\":600,\"op\":\"min\",\"cmp\":\">=\",\"target\":90}");
      p1.put("template", "1");

      JSONObject p2 = new JSONObject();
      p2.put("metric_name", "cpu.usage_user");
      p2.put("host_name", "tony.test2");
      p2.put("host_ip", "4.3.2.1");
      p2.put("alarm_level", "IMPORTANT");
      p2.put("alarm_condition", "{\"duration\":600,\"op\":\"min\",\"cmp\":\">=\",\"target\":90}");
      p2.put("template", "2");

      List<JSONObject> list = new ArrayList<JSONObject>();

      list.add(p1);
      list.add(p2);

      manager.batchSubmit(s, list);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void testBatchUpdate() {
    Client cli = new Client("http://10.168.222.251:35357/v3", 5000, true, true);
    try {
      TokenCredential token = cli.Authenticate("sysadmin", "MxqhTC2VKe067jtD", "Default", "system");
      logger.info(token.toString());
      logger.debug(token.toString());
      Session s = cli.newSession("LocalTest", null, null, token, "");

      MonitorAlarmEventManager manager = new MonitorAlarmEventManager();

      JSONObject p1 = new JSONObject();
      p1.put("id", "1");
      p1.put("metric_name", "cpu.usage_user");
      p1.put("host_name", "tony.test1");
      p1.put("host_ip", "1.2.3.4");
      p1.put("alarm_level", "NORMAL");
      p1.put("alarm_condition", "{\"duration\":600,\"op\":\"min\",\"cmp\":\">=\",\"target\":90}");
      p1.put("template", "1");

      JSONObject p2 = new JSONObject();
      p2.put("id", "2");
      p2.put("metric_name", "cpu.usage_user");
      p2.put("host_name", "tony.test2");
      p2.put("host_ip", "4.3.2.1");
      p2.put("alarm_level", "IMPORTANT");
      p2.put("alarm_condition", "{\"duration\":600,\"op\":\"min\",\"cmp\":\">=\",\"target\":90}");
      p2.put("template", "2");

      List<JSONObject> list = new ArrayList<JSONObject>();

      list.add(p1);
      list.add(p2);

      manager.batchSubmit(s, list);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
