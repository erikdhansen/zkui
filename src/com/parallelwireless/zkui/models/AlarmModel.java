package com.parallelwireless.zkui.models;

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
	
	public AlarmModel(Severity severity, boolean acked) {
		this.severity = severity;
		this.acked = acked;
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
