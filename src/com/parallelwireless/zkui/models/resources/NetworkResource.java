package com.parallelwireless.zkui.models.resources;

public class NetworkResource implements SystemResource {
	String systemName;
	int percentUtilization;
	
	public NetworkResource(String systemName) {
		this.systemName = systemName;
	}
	
	@Override
	public String getSystemName() {
		return systemName;
	}

	@Override
	public void addResources(ResourceConfig config) throws Exception {

	}

	public int getPercentUtilization() {
		return percentUtilization;
	}
}
