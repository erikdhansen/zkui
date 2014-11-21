package com.parallelwireless.zkui.models;

import java.util.Date;

import org.zkoss.chart.Color;

public class AlarmModel {
	
	public enum Severity {
		CRIT,
		MAJ,
		MIN,
		CLEAR
	};
	
	Severity severity;
	boolean  acked;
	String systemName;
	Date timestamp = new Date();
	int  eventId = 1001;
	String alarmName = "Link down";
	String alarmDescription = "Link down event detected";
	
	public AlarmModel(String systemName, Severity severity, int eventId, String alarmName, String alarmDescription, boolean acked) {
		this.systemName = systemName;
		this.severity = severity;
		this.eventId = eventId;
		this.alarmName = alarmName;
		this.alarmDescription = alarmDescription;
		this.acked = acked;
	}
	
	public String getSystemName() {
		return systemName;
	}
	
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	public Severity getSeverity() {
		return severity;
	}
	
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	
	public boolean isAcked() {
		return acked;
	}
	
	public void setAcked(boolean acked) {
		this.acked = acked;
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getAlarmName() {
		return alarmName;
	}

	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}

	public String getAlarmDescription() {
		return alarmDescription;
	}

	public void setAlarmDescription(String alarmDescription) {
		this.alarmDescription = alarmDescription;
	}

	public String getCssClass() {
		switch(severity) {
			case CRIT:
				return "critical";
			case MAJ:
				return "major";
			case MIN:
				return "minor";
			default:
				return "normal";
		}
	}
	
	public Color getColor() {
		Color c = new Color("gray");
		switch(severity) {
		case CRIT:
			if(acked)
				c = new Color("#ff6666");
			else
				c = new Color("#ff0000");
			break;
		case MAJ:
			if(acked)
				c = new Color("#ffce6f");
			else
				c = new Color("#ffa500");
			break;
		case MIN:
			if(acked)
				c = new Color("#fdff78");
			else
				c = new Color("#fcff00");
			break;
		case CLEAR:
		default:
		}
		return c;
	}
	
	public String toString() {
		return "[ALARM]: " + this.severity + " acked=" + isAcked();
	}
}
