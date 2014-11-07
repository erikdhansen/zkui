package com.parallelwireless.zkui.models.lte;

public abstract class AbstractLteStatisticType implements LteStatisticType {

	int CRITICAL;
	int MAJOR;
	int MINOR;
	
	@Override
	public String getCssClass() {
		String cssClass = "normal";
		if (getMonitoredValue() >= CRITICAL) {
			cssClass = "critical";
		} else if (getMonitoredValue() >= MAJOR) {
			cssClass = "major";
		} else if (getMonitoredValue() >= MINOR) {
			cssClass = "minor";
		}
		return cssClass;
	}
	
	@Override
	public abstract int getMonitoredValue();

}
