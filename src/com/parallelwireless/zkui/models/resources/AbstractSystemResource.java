package com.parallelwireless.zkui.models.resources;

public abstract class AbstractSystemResource implements SystemResource {

	int CRITICAL;
	int MAJOR;
	int MINOR;
	String systemName;
	
	@Override
	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	@Override
	public abstract void addResources(ResourceConfig config) throws Exception;

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
	
	public abstract int getMonitoredValue();

}
