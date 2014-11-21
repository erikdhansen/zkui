package com.parallelwireless.zkui.models;

import com.parallelwireless.zkui.models.AlarmModel.Severity;

public class AlarmDataUtil {

	public static AlarmList allAlarms = new AlarmList();
	
	static {
		allAlarms.add(new AlarmModel("Unicloud A", Severity.CRIT, 1001, "Link Down", "Link Down Event Detected", true));
		allAlarms.add(new AlarmModel("Unicloud B", Severity.CRIT, 1001, "Link Down", "Link Down Event Detected", true));
		allAlarms.add(new AlarmModel("Unicloud B", Severity.CRIT, 1001, "Link Down", "Link Down Event Detected", true));
		allAlarms.add(new AlarmModel("Unicloud C", Severity.CRIT, 1001, "Link Down", "Link Down Event Detected", false));
		allAlarms.add(new AlarmModel("Unicloud C", Severity.CRIT, 1001, "Link Down", "Link Down Event Detected", false));
		allAlarms.add(new AlarmModel("Unicloud A", Severity.MAJ, 2001, "Error count exceeded", "Error count exceeded from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud A", Severity.MAJ, 2001, "Error count exceeded", "Error count exceeded from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud B", Severity.MAJ, 2001, "Error count exceeded", "Error count exceeded from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud B", Severity.MAJ, 2001, "Error count exceeded", "Error count exceeded from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud C", Severity.MAJ, 2001, "Error count exceeded", "Error count exceeded from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud C", Severity.MAJ, 2001, "Error count exceeded", "Error count exceeded from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud D", Severity.MAJ, 2001, "Error count exceeded", "Error count exceeded from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud D", Severity.MAJ, 2001, "Error count exceeded", "Error count exceeded from CWS", false));
		allAlarms.add(new AlarmModel("Unicloud A", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud A", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud A", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud B", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud B", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud B", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud B", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud C", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud C", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud C", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud C", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud C", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud D", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud D", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud D", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud D", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud D", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", true));
		allAlarms.add(new AlarmModel("Unicloud D", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", false));
		allAlarms.add(new AlarmModel("Unicloud D", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", false));
		allAlarms.add(new AlarmModel("Unicloud D", Severity.MIN, 3001, "Heartbeat poll dropped", "Heartbeat poll dropped from CWS", false));	
	}
	
	public static AlarmList getAlarms() {
		return allAlarms;
	}
	
	public static AlarmList getAlarmsByDevice(String deviceName) {
		AlarmList bySystem = new AlarmList();
		for(AlarmModel a : allAlarms) {
			if(a.getSystemName().equalsIgnoreCase(deviceName)) {
				bySystem.add(a);
			}
		}
		return bySystem;
	}
}
