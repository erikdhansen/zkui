package com.parallelwireless.zkui;

import java.util.HashMap;
import java.util.Map;

public class ZulMapper {
	
	static Map<String,String> m = new HashMap<String,String>();
	static {
		m.put("navDashboard", "dashboard/dashboard.zul");
		m.put("navAlarms", "alarms/alarms.zul");
		m.put("navEventsHistory", "alarms/events_history.zul");
		m.put("navEventsLive",  "alarms/events_live.zul");
		m.put("navNetworkMap",  "network/network_map.zul");
		m.put("navDeviceManage", "devices/manage_device.zul");
		m.put("navDeviceGroups",  "devices/manage_groups.zul");
		m.put("navDeviceUpgrade",  "devices/upgrade_device.zul");
		m.put("navDeviceBackup",  "devices/backup_device.zul");
		m.put("navDeviceFiles",  "devices/device_files.zul");
		m.put("navStatsGraph",  "statistics/stats_graph.zul");
		m.put("navStatsConfigure",  "statistics/stats_configure.zul");
		m.put("navStatsThresholds",  "statistics/stats_thresholds.zul");
		m.put("navReports", "reports/reports.zul");
		m.put("navConfiguration",  "configuration/device_configuration.zul");
		m.put("navAdminAlarms",  "admin/alarms_admin.zul");
		m.put("navAdminWebResources",  "admin/admin_web_resources.zul");
		m.put("navSecurityUsers", "security/security_users.zul");
		m.put("navSecuritySessions",  "security/security_sessions.zul");
		m.put("navSecurityAudits",  "security/security_audits.zul");
		m.put("navSecurityViews",  "security/security_views.zul");
		m.put("navSystemBackup",  "backup/system_backup.zul");
		m.put("navHelp",  "help/help.zul");
	}
	
	private ZulMapper() {
		
	}
	
	public static String getZul(String navitem) {
		return m.get(navitem);
	}
}
