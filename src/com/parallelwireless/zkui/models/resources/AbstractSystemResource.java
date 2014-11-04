package com.parallelwireless.zkui.models.resources;

public abstract class AbstractSystemResource implements SystemResource {

	int CRITICAL;
	int MAJOR;
	int MINOR;
	
	@Override
	public abstract String getSystemName();

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
		System.out.println("getCssClass(): monitoredValue=" + getMonitoredValue() + "  C/MJ/MN=" + CRITICAL + "/" + MAJOR + "/" + MINOR);
		return cssClass;
	}
	
	public abstract int getMonitoredValue();

}
