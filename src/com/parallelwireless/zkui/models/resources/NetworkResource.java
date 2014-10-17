package com.parallelwireless.zkui.models.resources;

import java.util.Comparator;

public class NetworkResource implements SystemResource,Comparator<NetworkResource> {
	String systemName;
	int bytes = 0;
	
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

	@Override
	public int compare(NetworkResource o1, NetworkResource o2) {
		Integer mem1 = o1.bytes;
		Integer mem2 = o2.bytes;
		return mem2.compareTo(mem1);
	}
}
