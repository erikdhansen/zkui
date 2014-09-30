package com.parallelwireless.zkui;

import org.zkoss.chart.Color;

	
public class AlarmSeverity {
	public static enum SEVERITY {
		Critical,
		Major,
		Minor		
	};

	SEVERITY level;
	int unacked;
	int acked;
	
	public AlarmSeverity(SEVERITY severity, int unacked, int acked) {
		this.level = severity;
		this.unacked = unacked;
		this.acked = acked;
	}
	
	public static Color getColorBySeverity(SEVERITY severity) {
		switch(severity) {
		case Critical:
			return new Color("#ff0000");
		case Major:
			return new Color("#ffa500");
		case Minor:
			return new Color("#fcff00");
		default:
			return new Color("gray");
		}
	}
	
	public static Color getColorBySeverity(SEVERITY severity, boolean acked) {
		if(!acked)
			return getColorBySeverity(severity);
		
		switch(severity) {
		case Critical:
			return new Color("#ff6666");
		case Major:
			return new Color("#ffce6f");
		case Minor:
			return new Color("#fdff78");
		default:
			return new Color("gray");
		}
	}
	
	public static Color getColorBySeverity(String severity) {
		if(severity.equalsIgnoreCase("critical")) {
			return getColorBySeverity(SEVERITY.Critical);
		} else if(severity.equalsIgnoreCase("major")) {
			return getColorBySeverity(SEVERITY.Major);
		} else if(severity.equalsIgnoreCase("minor")) {
			return getColorBySeverity(SEVERITY.Minor);
		} else {
			return new Color("gray");
		}
	}
}
